package com.thainguyen.pigeonhole.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

public class AgendaPage extends BasePage {

    @FindBy(xpath = "//a/span[@class=\"btn-text\"][text()='Enter this Q&A']")
    private WebElementFacade enterThisQAButton;

    @Step("And I Click on Q&A button")
    public void clickOnQAButton(){
        clickOn(enterThisQAButton);
    }

}
