package com.cb.testing.pages.cb.ts;

import com.cb.testing.constant.TsPageUrlConstant;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    @FindBy(xpath = "//a[contains(text(),'Config function Add On')]")
    private WebElementFacade configAddOnTab;


    @FindBy(xpath = "//div[@id = 'tab_Addon']//div[@class = 'col_right']/input[contains(@type,'button')]")
    private WebElementFacade saveAddOnButton;

    @FindBy(xpath = "//a[@href=\"https://admin.talentnetworkdev.vn/news/index/owner/dhphuxuan\"]")
    private WebElementFacade configMenuButton;


    @FindBy(xpath = "//input[@value = 'Add New']")
    private WebElementFacade addNewButton;

    @FindBy(xpath = "//input[@name = 'txtName[en]']")
    private WebElementFacade insertMenuEn;

    @FindBy(xpath = "//input[@name = 'txtName[vi]']")
    private WebElementFacade insertMenuVi;

    @FindBy(xpath = "//select[@name = 'selMainCate']")
    private WebElementFacade selectMain;

    @FindBy(xpath = "//select[@name ='selFuncPage']//option[@value = '7']")
    private WebElementFacade optionHome;


    @FindBy(xpath = "//input[@name = 'txtOrder']")
    private WebElementFacade priorityField;

    @FindBy(xpath = "//div[@id ='result_search']//input[@value = 'Save']")
    private WebElementFacade saveMenuButton;

    @FindBy(xpath = "//input[@value= '2']")
    private WebElementFacade optionPage;

    @FindBy(xpath = "//input[@value= '3']")
    private WebElementFacade optionList;

    @FindBy(xpath = "//select[@name ='selFuncPage']//option[@value = '6']")
    private WebElementFacade optionContact;

    @FindBy(xpath = "//select[@name ='selFuncPage']//option[@value = '3']")
    private WebElementFacade optionCareer;

    @FindBy(xpath = "//a[@href=\"javascript:window.close()\"]")
    private WebElementFacade closeMenu;


    @Step("navigate to ts admin page")
    public void navigateAdminLoginPage() {
        String fullPageURL = TsPageUrlConstant.TS_HOME_PAGE + LOGIN_PATH;
        openUrl(fullPageURL);
    }


    @Step("login with username and password")
    public void loginWithUsernameAndPassword() {
        userName.sendKeys("adminrws");
        password.sendKeys("123456");
        clickOn(enterButton);

    }

    @Step("click on employer button")
    public void clickOnEmployerButton() {
        employerButton.click();

    }

    @Step("click on keyword")
    public void clickOnKeyword() {
        keywordButton.click();
    }

    @Step("input keyword")
    public void setInputKeyword() {
        inputKeyword.sendKeys("dhphuxuan");
        clickOn(filterButton);
    }

    @Step("set config owner")
    public void setConfigOwner() {
        configOwner.click();
    }

    @Step("Switch to Next Tab")
    public void switchToNextTab(String tabName) {
        String currentWindow = getDriver().getWindowHandle();
        if (!currentWindow.equalsIgnoreCase(tabName)) {
            getDriver().switchTo().window(tabName);
        }
    }

    @Step("Switch to next Tab by ID")
    public void switchToNextTabById(int index) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        List<String> windowStrings = new ArrayList<>(windowHandles);
        String reqWindow = windowStrings.get(index);
        getDriver().switchTo().window(reqWindow);
    }

    @Step("click on config add on tab")
    public void configFunctionAddOn() {
        configAddOnTab.click();
    }

    @Step("check these checkboxes")
    public void clickOnTheCheckBox(List<String> checkBoxIds) {
        checkBoxIds.forEach(
                checkBoxId -> {
                    WebElementFacade currentCheckbox = $(String.format("//input[@type=\"checkbox\" and @name=\"chk[]\" and @value=\"%s\"]", checkBoxId));
                    clickOn(currentCheckbox);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Step("Save config add on")
    public void clickOnSaveButtonAddOn() {
        saveAddOnButton.click();
        getDriver().close();
    }


    @Step("Navigate back to previous tab")
    public void switchToPreviousTabByID(int index) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        List<String> windowStrings = new ArrayList<>(windowHandles);
        String preWindow = windowStrings.get(index);
        getDriver().switchTo().window(preWindow);
    }

    @Step("Select Menu to config")
    public void configMenu() {
        configMenuButton.click();
    }



    @Step("Switch to next Tab by ID")
    public void switchToTabMenuById(int index) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        List<String> windowStrings = new ArrayList<>(windowHandles);
        String reqWindow = windowStrings.get(index);
        getDriver().switchTo().window(reqWindow);
    }

    @Step("Config Menu")
    public void setConfigMenu(){
        addNewButton.click();
    }

    @Step("Insert Menu")
    public void insertMenu(Map<String, String> inputMenuDualLanguage, AtomicInteger counter) {
        inputMenuDualLanguage.forEach(
                (en, vie) -> {
                    insertMenuEn.sendKeys(en);
                    insertMenuVi.sendKeys(vie);
                    priorityField.sendKeys(String.valueOf(counter.get()));
                    selectMain.click();
                    optionHome.click();
                    saveMenuButton.click();
                    counter.getAndIncrement();
                    String isRemoved = inputMenuDualLanguage.remove(inputMenuDualLanguage);
                    System.out.println(isRemoved);
                }
        );
    }


}



































































































































