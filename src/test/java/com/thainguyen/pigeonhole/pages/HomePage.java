package com.thainguyen.pigeonhole.pages;

import com.thainguyen.pigeonhole.constant.PageUrlConstant;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class HomePage extends UIInteractions {


    @Step("Navigate to homePage of PigeonHole")
    public void navigateToPigeonHoleHomePage(){
        openUrl(PageUrlConstant.HOME_PAGE_URL);
    }

    @Step("Input the Event passcode as {string}")
    public void inputEventPasscode(String eventPassCode){
        $("xpath://input[@id=\"passcodeInput\"]").sendKeys(eventPassCode);
        clickOn($("//div[@class='passcode-entry-submit icon icon-v3-arrow-right-thick icon-lg']"));
        waitForPresenceOf("xpath://div[@class='passcode-entry-submit icon icon-v3-tick-thick icon-lg'");

    }

    public void inputAttendeeCode(String attendeeCode){
        $("//input[@class='passcode-entry-input'").sendKeys(attendeeCode);
    }

}
