package com.thainguyen.pigeonhole.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class QandAPage extends BasePage{

    private final WebElement qAndATextArea = $("//textarea[@class='question-input question-input-no-radius']");
    private final WebElement askButton = $("//button[./div[@class='question-input-btn-content']]");
    private final WebElement modalBoxAskButton = $("//div[@class='modal-box']//button[text()[normalize-space() = 'Ask']]");
    private final ListOfWebElementFacades questionList = $$("//div[@class='question-list-container ']/div");
    private final WebElement lastedQuestionAddCommentBox = $("//div[@class='question-list-container ']/div[1]//span[text()[normalize-space() = 'Add a comment']]");
    private int currentQuestionListSize;

    @Step("Ask Question with {0} Code")
    public void askQuestionUsingCode(String attendeeCode){
        this.currentQuestionListSize = questionList.size();
        qAndATextArea.sendKeys(attendeeCode);
        clickOn(askButton);

    }

    @Step("Verify Modal Box Appeared")
    public void verifyModalBoxAppeared(){
        waitForPresenceOf("//div[@class='modal-box']");
    }

    @Step("Finish asking question")
    public void finishAskingQuestionInModalBox(){
        clickOn(modalBoxAskButton);
    }

    @Step("Modal Box closed and Question List should be updated")
    public void verifyQuestionListUpdated(){
        waitForAbsenceOf("//div[@class='modal-box']");
        Serenity.reportThat(String.format("Current questions list number is [%s]'", questionList.size()),
                () -> assertThat(questionList.size()).isEqualTo(currentQuestionListSize+1)
        );

    }

    @Step("Add comment to newly created question")
    public void addCommentToLastQuestion(){
        clickOn(lastedQuestionAddCommentBox);
    }


}
