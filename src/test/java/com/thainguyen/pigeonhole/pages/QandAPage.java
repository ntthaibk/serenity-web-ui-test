package com.thainguyen.pigeonhole.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QandAPage extends BasePage{

    @FindBy(xpath = "//textarea[@class='question-input']")
    private  WebElementFacade qAndATextArea;

    @FindBy(xpath = "//button[./div[@class='question-input-btn-content']]")
    private  WebElementFacade askButton;

    @FindBy(xpath = "//div[@class='modal-box']//button[text()[normalize-space() = 'Ask']]")
    private  WebElementFacade modalBoxAskButton;

    @FindBy(xpath = "//div[@class='question-list-container ']/div")
    private List<WebElementFacade> questionList;

    @FindBy(xpath = "//div[@class='question-list-container ']/div[1]//span[text()[normalize-space() = 'Add a comment']]")
    private  WebElementFacade lastedQuestionAddCommentBox;
    private int currentQuestionListSize;
    private String currentQuestionId;


    @Step("Ask Question with {0} Code")
    public void askQuestionUsingCode(String attendeeCode){
        qAndATextArea.waitUntilClickable();
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
        this.currentQuestionId = lastedQuestionAddCommentBox.getAttribute("data-id");
        clickOn(lastedQuestionAddCommentBox);
        verifyAtCommentPage();
    }

    @Step("verify at comment page")
    public void verifyAtCommentPage(){
        Serenity.reportThat(String.format("Current url with comment is [%s]'", currentQuestionId),
                () -> assertThat(getDriver().getCurrentUrl().contains(currentQuestionId)).isTrue()
        );

    }


}
