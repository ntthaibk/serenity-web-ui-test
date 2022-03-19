package com.thainguyen.pigeonhole.pages;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class AgendaPage extends BasePage {

    private final WebElement enterThisQAButton = $("//a/span[@class=\"btn-text\"][text()='Enter this Q&A']");

    @Step("Click on Q&A button")
    public void clickOnQAButton(){
        clickOn(enterThisQAButton);
    }



}
