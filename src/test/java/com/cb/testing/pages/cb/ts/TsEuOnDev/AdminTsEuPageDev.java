package com.cb.testing.pages.cb.ts.TsEuOnDev;

import com.cb.testing.constant.TsKarieragroupOnProduction.TsKieragroupConstant;
import io.cucumber.java.sl.In;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class AdminTsEuPageDev extends BaseTsEuPageDev {

    private static final String LOGIN_PATH = "login";
    private static final String OWNER_NAME = "demo";

    @FindBy(xpath = "//li[@class=\"dropdown  dropdown\"]")
    private WebElementFacade requisitionButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Create Requisition']")
    private WebElementFacade createRequisitionButton;

    @FindBy(xpath = "//select[@name='manager']/following-sibling::div[@class='chosen-container chosen-container-single']")
    private WebElementFacade hiringManagerDropdownList;

    private String managerEmailToSelect = "//li[contains(text(), '%s')]";

    @FindBy(xpath = "//select[@name='recruiter_user']/following-sibling::div[@class='chosen-container chosen-container-single']")
    private WebElementFacade recruiterUserDropdownList;

    private String recruiterEmailToSelect = "//select[@name='recruiter_user']/following-sibling::div/descendant::li[contains(text(), '%s')]";

    @FindBy(xpath = "//input[@name=\"job_code\"]")
    private WebElementFacade insertJobCode;

    @FindBy(xpath = "//input[@name=\"job_title\"]")
    private WebElementFacade insertJobTitle;


    @FindBy(name = "email")
    private WebElementFacade username;

    @FindBy(name = "password")
    private WebElementFacade password;

    @FindBy(id = "btnLogin")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//select[@name='employment_type']")
    private WebElementFacade employmentTypeDropdownList;

    private String employmentTypeValue = "//select/option[@value='%s']";



    WebDriver webDriver;

    @Step("Clear cache language")
    public void clearCacheLanguage() {
        String urlClearCacheLanguage = "https://talentsolutiondev.eu/system/clearlanguage";
        openUrl(urlClearCacheLanguage);
        getDriver().close();
    }

    @Step("Clear cache system")
    public void clearCacheSystem() {
        String urlClearCacheSystem = "https://talentsolutiondev.eu/cache/clear-employer";
        openUrl(urlClearCacheSystem);
        getDriver().close();
    }

    @Step("Assign Owner To Test")
    public void assignOwnerToTest(String ownerName) {
        String fullPageURL = TsKieragroupConstant.TS_EU_ASSIGN_OWNER_PAGE + ownerName;
        openUrl(fullPageURL);
        getDriver().close();
    }

    @Step("navigate to ts Karieragroup Admin Page")
    public void navigateAdminLoginPage() {
        String fullPageURL = TsKieragroupConstant.TS_EU_HOME_PAGE + LOGIN_PATH;
        openUrl(fullPageURL);
    }

    @Step("login to TS Kariergroup Admin Page")
    public void loginWithUsernameAndPassWord(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        clickOn(loginButton);
    }


    @Step("Select option Create new requisition From Dropdown Menu")
    public void hoverAndClickOnCreateNewRequisition() throws InterruptedException {
        Actions hoverRequisitionButton = new Actions(getDriver());
        hoverRequisitionButton.moveToElement(requisitionButton).build().perform();

        WebElementFacade element = $(createRequisitionButton).waitUntilClickable();
        element.click();

    }

    @Step("Select Hiring Manager")
    public void selectHiringManager(String userEmail) throws InterruptedException {

        clickOn(hiringManagerDropdownList);
        WebElementFacade managerDropdownList = $(String.format(managerEmailToSelect, userEmail));
        Actions hoverRequisitionButton = new Actions(getDriver());
        hoverRequisitionButton.moveToElement(managerDropdownList).build().perform();
        managerDropdownList.click();
    }

    @Step("Select Recruiter User")
    public void selectRecruiterUser(String recruiterEmail) throws InterruptedException {

        clickOn(recruiterUserDropdownList);
        WebElementFacade recruiterToSelect = $(String.format(recruiterEmailToSelect, recruiterEmail));
        Actions hoverRequisitionButton = new Actions(getDriver());
        hoverRequisitionButton.moveToElement(recruiterToSelect).build().perform();
        recruiterToSelect.click();
    }

    @Step("Insert Job Code")
    public void setJobCode(String jobCode) throws InterruptedException {

        insertJobCode.sendKeys(jobCode);
    }

    @Step("Insert Job Title ")
    public void setJobTitle(String jobTitle) throws InterruptedException {

        insertJobTitle.sendKeys(jobTitle);
    }

    @Step("Select employment type")
    public void selectEmploymentType(String typeValue) throws InterruptedException {
        employmentTypeDropdownList.click();
        WebElementFacade employmentTypeToSelect = $(String.format(employmentTypeValue, typeValue));
        Actions hoverRequisitionButton = new Actions(getDriver());
        hoverRequisitionButton.moveToElement(employmentTypeToSelect).build().perform();
        employmentTypeToSelect.click();
    }
}




























































































