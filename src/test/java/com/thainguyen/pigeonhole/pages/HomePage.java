package com.thainguyen.pigeonhole.pages;

import com.thainguyen.pigeonhole.constant.PageUrlConstant;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class HomePage extends CommonPage {


    @Step("Given I Navigate to homePage of PigeonHole")
    public void navigateToPigeonHoleHomePage(){
        openUrl(PageUrlConstant.HOME_PAGE_URL);
    }

    @Step("And I Input the Event passcode as {0}")
    public void inputEventPasscode(String eventPassCode){
        $("xpath://input[@id=\"passcodeInput\"]").sendKeys(eventPassCode);
        clickOn($("xpath://div[@class='passcode-entry-submit icon icon-v3-arrow-right-thick icon-lg']"));
        waitForPresenceOf("xpath://div[contains(@class,'passcode-entry-submit icon icon-v3-tick-thick icon-lg')]");

    }



    @Step("And then I input the Attendee code as {0}")
    public void inputAttendeeCode(String attendeeCode){
        WebElement textBox = $("xpath://input[@class='passcode-entry-input']");
        textBox.sendKeys(attendeeCode);
        clickOn($("//div[@class='passcode-entry-submit icon-v3-arrow-right-thick icon-lg']"));

    }

}
