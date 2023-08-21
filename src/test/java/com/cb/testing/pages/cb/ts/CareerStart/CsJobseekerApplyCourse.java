package com.cb.testing.pages.cb.ts.CareerStart;

import com.cb.testing.model.EmailSignInInputModel;
import com.cb.testing.pages.cb.ts.CareerStart.BaseCsPage;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@Getter
public class CsJobseekerApplyCourse extends BaseCsPage {

    private static final String JSK_HOME_PAGE = "login";

    @FindBy(xpath = "//a[@class=\"btn-register\"]")
    private WebElementFacade applyButton;

    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElementFacade inputSignInEmail;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElementFacade inputSignInPassword;

    @FindBy(xpath = "//input[@id=\"mobile\"]")
    private WebElementFacade inputPhoneNumber;

    @FindBy(xpath = "//div[@class=\"modal-body\"]//button[@type=\"submit\"]")
    private WebElementFacade signInButton;

    @FindBy(xpath = "//div/*[@class=\"btn-register\"]")
    private WebElementFacade signUpCourseButton;

    @FindBy(xpath = "//div[@class=\"main-menu\"]//a[@title=\"Khóa Học\"]")
    private WebElementFacade courseSectionButton;

    @FindBy(xpath = "//div[@class = \"section section-1\"]//*[@class=\"btn-link\"]")
    private WebElementFacade exploreNowButton;

    @FindBy(xpath = "//input[@id=\"keywordEL\"]")
    private WebElementFacade insertCourseKeyword;

    @FindBy(xpath = "//div[@id=\"cate_id_chosen\"]")
    private WebElementFacade selectCourseOption;

    @FindBy(xpath = "//button[@type= \"submit\"]")
    private WebElementFacade searchCourseButton;

    @FindBy(xpath = "//button[@class=\"btn-register\"]")
    private WebElementFacade signUpPopUpButton;

    @FindBy(xpath = "//div[@class ='main-register']//a[@title='Đăng xuất']")
    private WebElementFacade signOutButton;


    private static final String courseID = "//option[@value=\"%s\"]";
    private static final String courseName = "//div[@class=\"top-caption\"]//*[@title=\"%s\"]";


    @Step("Click Apply Course Button From Course Detail")
    public void clickApplyCourseButtonFromCourseDetail() {
        applyButton.click();
        WebElementFacade element = $(inputSignInEmail).waitUntilClickable();
        element.click();
    }

    @Step("Confirm Apply Form")
    public void clickConfirmApplyForm() {
        signUpCourseButton.click();
    }

    @Step("Get Course URL to apply")
    public String navigateToCourseURL(String url) {
        openUrl(url);
        return url;
    }

    public void applyForCourse(List<EmailSignInInputModel> inputModels, String url) {
        inputModels.forEach(
                inputModel -> {
                    openUrl(url);
                    applyButton.click();
                    inputSignInEmail.sendKeys(inputModel.getUserName());
                    inputSignInPassword.sendKeys(inputModel.getPassWord());
                    signInButton.click();
                    signUpCourseButton.click();
                    inputPhoneNumber.sendKeys("0354799915");
                    signUpPopUpButton.click();
                    getDriver().get(url);
                    waitFor(signOutButton).click();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}

/*    public void searchActiveCourseJobseeker(String keyword, String courseID){
        courseSectionButton.click();
        exploreNowButton.click();
        insertCourseKeyword.sendKeys(keyword);
        Select select = new Select(selectCourseOption);
        select.selectByValue(courseID);
        searchCourseButton.click();
        WebElementFacade courseToClick = $(String.format(courseName));
        clickOn(courseToClick);
    }
*/
