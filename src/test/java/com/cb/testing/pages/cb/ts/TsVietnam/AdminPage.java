package com.cb.testing.pages.cb.ts.TsVietnam;

import com.cb.testing.constant.TsVietnam.TsPageUrlConstant;
import com.cb.testing.model.AdminPageInputModel;
import com.cb.testing.model.CheckBoxInMenuPageModel;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.List;

@Getter
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
    private WebElementFacade keywordOwner;
    @FindBy(xpath = "//*[@name = \"btnSearch\" and @value=\" Filter \"]")
    private WebElementFacade filterButton;

    @FindBy(xpath = "//a[contains(text(),'Config function Add On')]")
    private WebElementFacade configAddOnTab;
    @FindBy(xpath = "//div[@id = 'tab_Addon']//div[@class = 'col_right']/input[contains(@type,'button')]")
    private WebElementFacade saveAddOnButton;
    @FindBy(xpath = "//*[contains(text(),'Menu/Submenu')]")
    private WebElementFacade configMenuButton;
    @FindBy(xpath = "//input[@value = 'Add New']")
    private WebElementFacade addNewButton;
    @FindBy(xpath = "//input[@name = 'txtName[en]']")
    private WebElementFacade insertMenuEn;
    @FindBy(xpath = "//input[@name = 'txtName[vi]']")
    private WebElementFacade insertMenuVi;
    @FindBy(xpath = "//select[@name = 'selMainCate']")
    private WebElementFacade selectMain;
    @FindBy(xpath = "//input[@name = 'txtOrder']")
    private WebElementFacade priorityField;
    @FindBy(xpath = "//div[@id ='result_search']//input[@value = 'Save']")
    private WebElementFacade saveMenuButton;
    @FindBy(xpath = "//input[@value= '2']")
    private WebElementFacade optionPage;
    @FindBy(xpath = "//input[@value= '3']")
    private WebElementFacade optionList;
    @FindBy(xpath = "//select[@name ='selFuncPage']//option[@value = '7']")
    private WebElementFacade optionHome;
    @FindBy(xpath = "//select[@name ='selFuncPage']//option[@value = '6']")
    private WebElementFacade optionContact;
    @FindBy(xpath = "//select[@name ='selFuncPage']//option[@value = '3']")
    private WebElementFacade optionCareer;
    @FindBy(xpath = "//a[@href=\"javascript:window.close()\"]")
    private WebElementFacade closeMenu;
    @FindBy(xpath = "//input[@type=\"button\" and @value = \"Update\"]")
    private WebElementFacade updateMenuButton;
    @FindBy(xpath = "//*[contains(text(),'Cate/Industry')]")
    private WebElementFacade configCateIndustryButton;

    @FindBy(xpath = "//input[@value=\"create talent network\"]")
    private WebElementFacade createTalentNetworkButton;

    @FindBy(xpath = "//input[@value=\"create auto talent network\"]")
    private WebElementFacade createAutoTalentNetwork;

        private String checkboxInMenuPage = "//tr/td[contains(.,'%s')]/following-sibling::td/input[contains(@name,'%s')]";

    @FindBy(xpath = "//input[@type = \"submit\" and @value=\"Save\"]")
    private WebElementFacade saveIndustryButton;

    @FindBy(xpath = "//a[contains(text(),'Location')]")
    private WebElementFacade configLocationButton;

    private String checkboxLanguage = "//input[@type=\"checkbox\" and @value = \"%s\"]";
    private String radioLanguage = "//input[@type=\"radio\" and @value = \"%s\"]";

    @FindBy(xpath = "//input[@type=\"radio\" and @value = \"vi\"]")
    private WebElementFacade viRadioOptionButton;

    @FindBy(xpath = "//div[@class=\"tab_TS_leftcol\"]//input[@value = \"Save\"]")
    private WebElementFacade saveConfigTalentSolutionButton;


    @FindBy(xpath = "//input[@name =\"btnButton\" and @value = \"Save\"]")
    private WebElementFacade saveLocationButton;


    @FindBy(xpath = "//a[contains(text(),'Level')]")
    private WebElementFacade configLevelButton;


    @FindBy(xpath = "//input[@type =\"submit\" and @value= \"Save\"]")
    private WebElementFacade saveLevelButton;

    @FindBy(xpath = "//a[contains(text(),'Degree')]")
    private WebElementFacade configDegreeButton;

    @FindBy(xpath = "//input[@type =\"submit\" and @value= \"Save\"]")
    private WebElementFacade saveDegreeButton;

    private static final String ownerNameLabel = "//td/a[text()='%s']";
    private String ownerName = "";


    @FindBy (xpath = "//option[@value = '%s']")
    private String templateType;

    private static final String template = "//option[@value = '%s']";

    @FindBy(xpath = "//li//a[contains(text(),'Create Talent Network')]")
    private WebElementFacade createNewTsOption;

    @FindBy(xpath = "//input[@id=\"txtEmpId\"]")
    private WebElementFacade employerIDField;

    @FindBy(xpath = "//input[@id=\"btnCheckEmployer\"]")
    private WebElementFacade checkEmployerIDButton;

    @FindBy(xpath = "//select[@id='selTemplate']")
    private WebElementFacade selectTemplateList;

    @FindBy(xpath = "//select[@id='selOwnerClone']")
    private WebElementFacade selectOwnerCopyList;


    private static final String ownerCopy = "//option[@value = '%s']";

    @FindBy(xpath = "//input[@name='txtURL']")
    private WebElementFacade ownerDomainField;

    @FindBy(xpath = "//input[@name='txtOwner']")
    private WebElementFacade insertOwnerName;

    @FindBy(xpath = "//input[@name='txtReOwner']")
    private WebElementFacade insertReOwnerName;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElementFacade saveOwnerButton;

    @FindBy(xpath = "//li//a[contains(text(),'Config Talent Solution')]")
    private WebElementFacade configTalentSolutionTab;

    public AdminPage() {
    }


    @Step("navigate to ts admin page")
    public void navigateAdminLoginPage() {
        String fullPageURL = TsPageUrlConstant.TS_HOME_PAGE + LOGIN_PATH;
        openUrl(fullPageURL);
    }


    @Step("login with username and password")
    public void loginWithUsernameAndPassword(String userName, String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        clickOn(enterButton);
        Thread.sleep(4000);

    }

    @Step("create new talent network")
    public void createTalentNetwork() throws InterruptedException {

    }

    @Step("click on employer button")
    public void clickOnEmployerButton() throws InterruptedException {
        employerButton.click();

        Thread.sleep(2000);

    }

    @Step("click on keyword")
    public void clickKeywordRadioButton() throws InterruptedException {
        keywordButton.click();
        Thread.sleep(2000);
    }

    @Step("input keyword")
    public void setKeywordOwner(String keywordOwner) throws InterruptedException {
        this.keywordOwner.sendKeys(keywordOwner);
        this.ownerName = keywordOwner;
        Thread.sleep(2000);
    }

    public void clickOnFilterButton() throws InterruptedException {
        filterButton.click();

        Thread.sleep(1000);
    }

    @Step("click on Owner name (the owner that just created)")
    public void clickOnOwnerName() throws InterruptedException {
        WebElementFacade ownerLabel = $(String.format(this.ownerNameLabel, this.ownerName));
        ownerLabel.click();

        Thread.sleep(2000);
    }

    @Step("Switch to Next Tab")
    public void switchToNextTab(String tabName) {
        String currentWindow = getDriver().getWindowHandle();
        if (!currentWindow.equalsIgnoreCase(tabName)) {
            getDriver().switchTo().window(tabName);
        }
    }

    @Step("Switch to next Tab by ID")
    public void switchToTabById(int index) throws InterruptedException {
//        Set<String> windowHandles = getDriver().getWindowHandles();
//        List<String> windowStrings = new ArrayList<>(windowHandles);
//        String reqWindow = windowStrings.get(index);
//        getDriver().switchTo().window(reqWindow);
        List<String> allWindows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(allWindows.get(index));

        Thread.sleep(2000);
    }


    @Step("click on Config talent solution tab")
    public void clickOnConfigTalentSolutionTab(){
        configTalentSolutionTab.click();
    }

    @Step("check Language checkboxes")
    public void clickOnTheLanguageCheckBox(List<String> checkBoxIds) throws InterruptedException {
        checkBoxIds.forEach(
                checkBoxValue -> {
                    WebElementFacade currentCheckbox = $(String.format("//input[@type=\"checkbox\" and @value = \"%s\"]", checkBoxValue));
                    clickOn(currentCheckbox);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        Thread.sleep(2000);
    }

    @Step("select Vi language radio button")
    public void clickOnTheLanguageRadioButton(){
        viRadioOptionButton.click();
    }


    @Step("Save Config Talent Solution")
    public void clickOnSaveConfigTalentSolutionButton() {
        saveConfigTalentSolutionButton.click();
        getDriver().close();
    }

    @Step("click on config add on tab")
    public void configFunctionAddOn() throws InterruptedException {
        configAddOnTab.click();
        Thread.sleep(4000);
    }

    @Step("check Menu checkboxes")
    public void clickOnTheCheckBox(List<String> checkBoxIds) throws InterruptedException {
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
        Thread.sleep(2000);
    }

    @Step("Save config add on")
    public void clickOnSaveButtonAddOn() throws InterruptedException {
        saveAddOnButton.click();
        getDriver().close();

        Thread.sleep(2000);
    }

    @Step("Select Menu to config")
    public void clickOnConfigMenuButton() throws InterruptedException {
        configMenuButton.click();

        Thread.sleep(2000);
    }

    @Step("Config Menu")
    public void clickOnAddNewMenuButton() throws InterruptedException {
        addNewButton.click();

        Thread.sleep(2000);
    }

    @Step("Insert Menu")
    public void insertMenuItemForOwner(List<AdminPageInputModel> inputModels) {
        inputModels.forEach(
                inputModel -> {
                    insertMenuEn.sendKeys(inputModel.getEnValue());
                    insertMenuVi.sendKeys(inputModel.getVieValue());
                    priorityField.sendKeys(inputModel.getPriority());
                    inputModel.getButtonToClick1().click();
                    saveMenuButton.click();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    inputModel.getButtonToClick2().click();
                    if (!inputModel.getPriority().equalsIgnoreCase("5")) {
                        inputModel.getButtonToClick3().click();
                    }

                }
        );
    }

    @Step("check menu checkboxes")
    public void clickOnDesiredMenuItemCheckbox(List<CheckBoxInMenuPageModel> checkBoxInMenuPageModelList) {
        checkBoxInMenuPageModelList.forEach(
                checkBoxInMenuPageModelItem -> {
                    if (checkBoxInMenuPageModelItem.getMenuColumnType().equals(Boolean.TRUE)) {
                        WebElementFacade menuColumnType = $(String.format(this.checkboxInMenuPage, checkBoxInMenuPageModelItem.getMenuName(), "chkVer"));
                        clickOn(menuColumnType);
                    }
                    if (checkBoxInMenuPageModelItem.getMenuCrossType().equals(Boolean.TRUE)) {
                        WebElementFacade menuCrossType = $(String.format(this.checkboxInMenuPage, checkBoxInMenuPageModelItem.getMenuName(), "chkHoz"));
                        clickOn(menuCrossType);
                    }
                    if (checkBoxInMenuPageModelItem.getMenuFooterType().equals(Boolean.TRUE)) {
                        WebElementFacade menuFooterType = $(String.format(this.checkboxInMenuPage, checkBoxInMenuPageModelItem.getMenuName(), "chkFooter"));
                        clickOn(menuFooterType);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Step("Click on update menu button")
    public void clickOnUpdateMenuCheckbox() throws InterruptedException {
        updateMenuButton.click();

        Thread.sleep(1000);
    }

    @Step("Click on Cate Industry button")
    public void clickOnConfigCateIndustryButton() throws InterruptedException {
        configCateIndustryButton.click();

        Thread.sleep(1000);
    }

    @Step("check Industry checkboxes")
    public void clickOnDesiredIndustryItemCheckbox(List<String> checkBoxIds) throws InterruptedException {
        checkBoxIds.forEach(
                checkBoxId -> {
                    WebElementFacade currentCheckbox = $(String.format("//input[@type=\"checkbox\" and @name=\"chk_%s\" and @value=\"1\"]", checkBoxId));
                    clickOn(currentCheckbox);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        Thread.sleep(2000);
    }

    @Step("Save Industry checkboxes and close tab")
    public void clickOnSaveIndustryButton(){
        saveIndustryButton.click();
    }

    @Step("click to config Location")
    public void clickOnLocationButton(){
        configLocationButton.click();
    }

    @Step("Click on Location checkboxes")
    public void clickOnLocationCheckbox(List<String> checkBoxIds) throws InterruptedException {
        checkBoxIds.forEach(
                checkBoxId -> {
                    WebElementFacade currentCheckbox = $(String.format("//input[@type=\"checkbox\" and @name=\"chk_%s\" and @value=\"1\"]", checkBoxId));
                    clickOn(currentCheckbox);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Step("Save Location checkboxes")
    public void clickOnSaveLocationButton() throws InterruptedException {
        saveLocationButton.click();
        getDriver().close();

        Thread.sleep(1000);
    }

    @Step("Click on config level")
    public void clickOnConfigLevelButton() throws InterruptedException {
        configLevelButton.click();

        Thread.sleep(1000);
    }

    @Step("Click on Level checkboxes")
    public void clickOnLevelCheckboxes (List<String> checkBoxIds) throws InterruptedException {
        checkBoxIds.forEach (
                checkBoxId -> {
                    WebElementFacade currentCheckbox = $(String.format("//input[@type=\"checkbox\" and @name=\"chk_%s\" and @value=\"1\"]", checkBoxId));
                    clickOn(currentCheckbox);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Step("Click on save level button")
    public void clickOnSaveLevelButton() {
        saveLevelButton.click();
    }


    @Step("Click on config Degree button")
    public void clickOnConfigDegreeButton(){
        configDegreeButton.click();
    }
    @Step("Click on Degree checkboxes")
    public void clickOnDegreeCheckboxes (List<String> checkBoxIds) throws InterruptedException {
        checkBoxIds.forEach (
                checkBoxId -> {
                    WebElementFacade currentCheckbox = $(String.format("//input[@type=\"checkbox\" and @name=\"chk_%s\" and @value=\"1\"]", checkBoxId));
                    clickOn(currentCheckbox);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Step("Click on save degree button")
    public void clickOnSaveDegreeButton() {
        saveDegreeButton.click();
    }


    @Step("Create new TS")
    public void hoverAndClickOnCreateNewTs() throws InterruptedException {

        Actions hoverEmployerButton = new Actions(getDriver());
        hoverEmployerButton.moveToElement(employerButton).build().perform();

        WebElementFacade element = $(createNewTsOption).waitUntilClickable();
        element.click();
    }

    @Step("Check empty Employer ID")
    public void insertEmloyerIDToCheck(String employerID) throws InterruptedException {
        this.employerIDField.sendKeys(employerID);
        WebElementFacade element = $(checkEmployerIDButton).waitUntilClickable();
        element.click();
    }

    @Step("Create regular TS")
    public void createRegularTalentNetWork() throws InterruptedException {
        createTalentNetworkButton.click();
    }

    @Step("Create auto TS")
    public void createAutoTalentNetwork() throws InterruptedException {
        createAutoTalentNetwork.click();
    }


    @Step("Select Owner Template")
    public void selectOwnerTemplate(String template) {
        selectTemplateList.click();
        Select select = new Select((selectTemplateList));
        select.selectByValue(template);
    }

    @Step("select owner copy")
    public void selectOwnerCopy(String ownerCopy) {
        selectOwnerCopyList.click();
        Select select = new Select((selectOwnerCopyList));
        select.selectByValue(ownerCopy);

    }

    @Step("insert domain for new ts")
    public void inputDomainName(String domain) {
        ownerDomainField.clear();
        this.ownerDomainField.sendKeys(domain);
    }

    @Step("insert new owner name")
    public void inputOwnerName(String newOwnerName){
        this.insertOwnerName.sendKeys(newOwnerName);
    }

    @Step("insert re-owner name")
    public void inputReOwnerName(String newReOwnerName){
        this.insertReOwnerName.sendKeys(newReOwnerName);
    }

    @Step("save new created owner")
    public void saveNewOwner() throws InterruptedException {
        saveOwnerButton.click();
        Thread.sleep(2000);
    }
}



































































































































