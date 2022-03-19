package com.thainguyen.pigeonhole.pages;

import com.thainguyen.pigeonhole.constant.PageUrlConstant;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id=\"passcodeInput\"]")
    private WebElementFacade passCodeInputTextBox;
    @FindBy(xpath = "//div[@class='passcode-entry-submit icon icon-v3-arrow-right-thick icon-lg']")
    private WebElementFacade passCodeRightArrow;

    @FindBy(xpath = "//input[@class='passcode-entry-input']")
    private WebElementFacade passCodeEntryInputTextBox;

    @FindBy(xpath = "//div[@class='passcode-entry-submit icon-v3-arrow-right-thick icon-lg']" )
    private WebElementFacade passCodeEntryInputRightArrow;



    @Step("Given I Navigate to homePage of PigeonHole")
    public void navigateToPigeonHoleHomePage(){
        openUrl(PageUrlConstant.HOME_PAGE_URL);
    }

    @Step("And I Input the Event passcode as {0}")
    public void inputEventPasscode(String eventPassCode){
        passCodeInputTextBox.sendKeys(eventPassCode);
        clickOn(passCodeRightArrow);
        waitForPresenceOf("xpath://div[contains(@class,'passcode-entry-submit icon icon-v3-tick-thick icon-lg')]");
    }

    @Step("And then I input the Attendee code as {0}")
    public void inputAttendeeCode(String attendeeCode){
        passCodeEntryInputTextBox.sendKeys(attendeeCode);
        clickOn(passCodeEntryInputRightArrow);
        passCodeInputTextBox.waitUntilNotVisible();
    }

}
