package com.cb.testing.pages.cb.ts;

import com.cb.testing.constant.TsPageUrlConstant;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BaseTsPage {

    private static final String LOGIN_PATH = "login";


    @FindBy(xpath = "//input[@name = \"user\"]")
    private WebElementFacade userName;

    @FindBy(xpath = "//input[@name= \"pwd\"]")
    private WebElementFacade password;

    @FindBy(xpath = "//input[@value= \"Enter\"]")
    private WebElementFacade enterButton;

    @FindBy(xpath = "//li[@id= \"yui-gen1\"]")
    private WebElementFacade employerButton;

    @FindBy(xpath = "//*[@name = \"chkSearchBy\" and @value=\"1\"]")
    private WebElementFacade keywordButton;

    @FindBy(xpath = "//*[@name = \"keyword\" and @id=\"id_keyword_1\"]")
    private WebElementFacade inputKeyword;

    @FindBy(xpath = "//*[@name = \"btnSearch\" and @value=\" Filter \"]")
    private WebElementFacade filterButton;

    @FindBy(xpath = "//a[@href=\"javascript:editRw('dhphuxuan')\"]")
    private WebElementFacade configOwner;

    @FindBy(xpath = "//li[@class=\"ui-state-default ui-corner-top ui-tabs-selected ui-state-active\"]")
    private WebElementFacade configAddOnTab;

    @Step("navigate to ts admin page")
    public void navigateAdminLoginPage() {
        String fullPageURL = TsPageUrlConstant.TS_HOME_PAGE+LOGIN_PATH;
        openUrl(fullPageURL);
    }


    @Step("login with username and password")
    public void loginWithUsernameAndPassword() {
        userName.sendKeys("adminrws");
        password.sendKeys("123456");
        clickOn(enterButton);

    }
    @Step("click on employer button")
    public void clickOnEmployerButton(){
        employerButton.click();

    }

    @Step("click on keyword")
    public void clickOnKeyword(){
        keywordButton.click();
    }

    @Step("input keyword")
    public void setInputKeyword(){
        inputKeyword.sendKeys("dhphuxuan");
        clickOn(filterButton);
    }

    @Step("set config owner")
    public void setConfigOwner() {
        configOwner.click();
    }

    }


    @Step("click on config add on tab")
    public void configFunctionAddOn(){
        configAddOnTab.click();
    }
}
