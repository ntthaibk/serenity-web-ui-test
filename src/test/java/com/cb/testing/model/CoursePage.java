package com.cb.testing.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Data
@NoArgsConstructor

public class CoursePage {
    private WebDriver driver;

    // Page elements
/*    private String applyButton;
    private String inputSignInEmail;
    private String inputSignInPassword;
    private String signInButton;
    private String signUpCourseButton;
    private String signOutButton;
*/
    @FindBy(xpath = "//a[@class=\"btn-register\"]")
    private WebElementFacade applyButton;

    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElementFacade inputSignInEmail;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElementFacade inputSignInPassword;

    @FindBy(xpath = "//div[@class=\"modal-body\"]//button[@type=\"submit\"]")
    private WebElementFacade signInButton;

    @FindBy(xpath = "//button[@type=\"button\" and @class =\"btn-register\"]")
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

    @FindBy(xpath = "//div[@class=\"main-register\"]")
    private WebElementFacade signOutButton;


    public void applyForCourse(String courseURL, EmailSignInInputModel inputModel) {
        driver.get(courseURL);
        applyButton.click();
        inputSignInEmail.sendKeys(inputModel.getUserName());
        inputSignInPassword.sendKeys(inputModel.getPassWord());
        signInButton.click();
        signUpCourseButton.click();
        signOutButton.click();
    }
}
