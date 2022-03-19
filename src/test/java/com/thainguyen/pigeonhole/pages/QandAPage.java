package com.thainguyen.pigeonhole.pages;

import net.serenitybdd.core.Serenity;
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

    @FindBy(xpath = "//div[@class='question-list-container ']/div[1]")
    private WebElementFacade lastedQuestion;

    @FindBy(xpath = "//textarea[@class='comment-input']")
    private WebElementFacade questionCommentTextArea;

    @FindBy(xpath = "//div[@class='comment-btn-content']")
    private WebElementFacade commentButton;

    @FindBy(xpath = "//div[@class='modal-box']//button[text()[normalize-space() = 'Submit']]")
    private WebElementFacade modalBoxSubmitButton;

    @FindBy(xpath = "//div[contains(@class,'comment-item')]//div[@class='comment-text-box']")
    private List<WebElementFacade> questionComments;

    @FindBy(xpath = "//div[@class='modal-box-tick']")
    private WebElementFacade thankYouModalBox;

    private WebElementFacade lastQuestionCommentUpvoteButton;

    private int currentQuestionListSize;
    private String currentQuestionId;
    private int currentQuestionCommentListSize;


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

    @Step("Verify Modal Box Disappeared")
    public void verifyModalBoxDisappeared(){
        waitForAbsenceOf("//div[@class='modal-box']");
    }

    @Step("Finish asking question")
    public void finishAskingQuestionInModalBox(){
        clickOn(modalBoxAskButton);
    }

    @Step("Modal Box closed and Question List should be updated")
    public void verifyQuestionListUpdated(){
        verifyModalBoxDisappeared();
        Serenity.reportThat(String.format("Current questions list number is [%s]'", questionList.size()),
                () -> assertThat(questionList.size()).isEqualTo(currentQuestionListSize+1)
        );

    }

    @Step("Add comment {0} to newly created question")
    public void addCommentToLastQuestion(String comment){
        thankYouModalBox.waitUntilNotVisible();
        this.currentQuestionId = lastedQuestion.getAttribute("data-id");
        clickOn(lastedQuestionAddCommentBox);
        verifyAtCommentPage();
        inputIntoTextAreaOfComment(comment);
    }

    @Step("verify at comment page")
    public void verifyAtCommentPage(){
        Serenity.reportThat(String.format("Current url with comment is [%s]'", currentQuestionId),
                () -> assertThat(getDriver().getCurrentUrl().contains(currentQuestionId)).isTrue()
        );

    }

    @Step("Input into comment text area")
    public void inputIntoTextAreaOfComment(String comment){
        currentQuestionCommentListSize = questionComments.size();
        questionCommentTextArea.sendKeys(comment);
        clickOn(commentButton);
        verifyModalBoxAppeared();
        clickOn(modalBoxSubmitButton);
        verifyModalBoxDisappeared();
    }

    @Step("Verify Comment Appeared")
    public void verifyCommentAppeared(String comment){
        thankYouModalBox.waitUntilNotVisible();
        Serenity.reportThat(String.format("Current questions comment list number is [%s]'", questionComments.size()),
                () -> assertThat(questionComments.size()).isEqualTo(currentQuestionCommentListSize +1)
        );
        waitForPresenceOf(String.format("//div[contains(@class,'comment-item')][last()]//div[@class='comment-text-box'][.//text()='%s']", comment));

    }

    @Step("Upvote the newly created comment")
    public void upvoteComment(String comment){
        this.lastQuestionCommentUpvoteButton = $(String.format("xpath://div[contains(@class,'comment-item')][last()]//div[@class='comment-text-box'][.//text()='%s']/following::button[contains(@class,'comment-upvote')]", comment));
        clickOn(this.lastQuestionCommentUpvoteButton);
        waitForPresenceOf(String.format("//div[contains(@class,'comment-item')][last()]//div[@class='comment-text-box'][.//text()='%s']/following::button[contains(@class,'active')]", comment));
    }

    @Step("Verify comment upvoted")
    public void verifyCommentUpvoted(){
        String upvotedNumber = this.lastQuestionCommentUpvoteButton.getAttribute("innerText");
        Serenity.reportThat("question is upvoted",
                () -> assertThat(upvotedNumber.contains("1")).isTrue()
        );


    }


}
