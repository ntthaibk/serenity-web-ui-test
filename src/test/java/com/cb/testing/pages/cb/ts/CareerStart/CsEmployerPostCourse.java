package com.cb.testing.pages.cb.ts.CareerStart;

import com.cb.testing.constant.CareerStart.EleaningUrlConstant;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CsEmployerPostCourse extends BaseCsPage {

    private static final String LOGIN_PATH = "login";

    //    WebDriver driver;
    @FindBy(xpath = "//div[@class = \"form-input\"]/input[@name=\"username\"]")
    private WebElementFacade userName;

    @FindBy(xpath = "//div[@class = \"form-input\"]/input[@name=\"password\"]")
    private WebElementFacade password;

    @FindBy(xpath = "//div[@class=\"btn-area\"]/button[@type = \"submit\"]")
    private WebElementFacade enterButton;

    @FindBy(xpath = "//div[@class = 'main-menu']//li//*[@title ='Khóa Học Online']")
    private WebElementFacade courseButtonOnMenu;

    @FindBy(xpath = "//div[@class=\"button\"]")
    private WebElementFacade addCourseButton;

    @FindBy(xpath = "//select[@id=\"cate-id\"]")
    private WebElementFacade selectTopic;

    @FindBy(xpath = "//input[@id=\"course-name\"]")
    private WebElementFacade inputCourseName;

    @FindBy(xpath = "//iframe[@title=\"Rich Text Editor, course_about\"]")
    private WebElementFacade inputCourseDescription;

    @FindBy(xpath = "//iframe[@title=\"Rich Text Editor, course_desc\"]")
    private WebElementFacade inputCourseIntroduction;

    @FindBy(xpath = "//input[@name=\"content[0]\"]")
    private WebElementFacade inputLessonName;

    @FindBy(xpath = "//input[@name=\"subcontent[0][]\"]")
    private WebElementFacade inputLessonDescription;

    @FindBy(xpath = "//input[@id=\"number-student\"]")
    private WebElementFacade inputNumberOfStudent;

    @FindBy(xpath = "//input[@id=\"course-price\"]")
    private WebElementFacade inputCoursePrice;

    @FindBy(xpath = "//select[@id=\"teacher-id\"]")
    private WebElementFacade selectTeacher;

    @FindBy(xpath = "//input[@id=\"date-from\"]")
    private WebElementFacade inputDateFrom;

    @FindBy(xpath = "//input[@id=\"date-to\"]")
    private WebElementFacade inputDateTo;

    @FindBy(xpath = "//div[@class=\"dtpicker-comp day\"]/input[@class=\"dtpicker-compValue\"]")
    private WebElementFacade dateFrom;

    @FindBy(xpath = "//div[@class=\"dtpicker-comp day\"]/input")
    private WebElementFacade dateTo;

//    @FindBy(xpath = "//div[@class=\"dtpicker-comp month\"]/input")
//    private WebElementFacade setStartMonth;
//
//    @FindBy(xpath = "//div[@class=\"dtpicker-comp month\"]/input")
//    private WebElementFacade setEndMonth;
//
//    @FindBy(xpath = "//div[@class=\"dtpicker-comp year\"]/input")
//    private WebElementFacade setStartYear;
//
//    @FindBy(xpath = "//div[@class=\"dtpicker-comp year\"]/input")
//    private WebElementFacade setEndYear;

    @FindBy(xpath = "//*[@class=\"dtpicker-button dtpicker-buttonSet\"]")
    private WebElementFacade buttonSet;

    @FindBy(id = "filephoto")
    WebElement uploadCoursePhotoButton;

    @FindBy(xpath = "//label[@for=\"filebanner\"]")
    private WebElementFacade uploadCourseBannerButton;

    @FindBy(xpath = "//li/a[@class=\"btn-add pointer\"]")
    private WebElementFacade saveCourseButton;

    private static final String topicID = "//select[@id=\"cate-id\"]/option[@value = '%s']";
    private static final String teacherID = "//select[@id=\"teacher-id\"]/option[@value = '%s']";

/*    private static final String CHROMEDRIVER_PATH = "C:\\Users\\hannlb\\Documents\\chromedriver.exe";
    private static final String UPLOAD_URL = "https://qccareerstart.vn/employers/employercenter/postcourse";
    private static final String FILE_PATH = "C:\\Users\\hannlb\\Pictures\\image300x300.png";
    private static final int REMOTE_DEBUGGING_PORT = 9222;
*/

    @Step("navigate to Employer page")
    public void navigateEmployerLoginPage() {
        String fullPageURL = EleaningUrlConstant.CS_EMP_HOME_PAGE + LOGIN_PATH;
        openUrl(fullPageURL);
    }


    @Step("login with username and password")
    public void loginWithUsernameAndPassword(String userName, String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        clickOn(enterButton);

    }

    @Step("Click on Add New Course Button")
    public void clickOnCourseButtonOnMenu() {
        courseButtonOnMenu.click();
        WebElementFacade element = $(addCourseButton).waitUntilClickable();
        element.click();
    }

    @Step("Select a Topic for New Course")
    public void selectTopicForNewCourse(String topicID) {
        selectTopic.click();
        Select select = new Select((selectTopic));
        select.selectByValue(topicID);
    }

    @Step("input course name")
    public void setInputCourseName(String courseName) {
        inputCourseName.sendKeys(courseName);
    }

    @Step("input course description")
    public void setInputCourseDescription(String courseDescription) {
        inputCourseDescription.sendKeys(courseDescription);
    }

    @Step("input course introduction")
    public void setInputCourseIntroduction(String courseIntroduction) {
        inputCourseIntroduction.sendKeys(courseIntroduction);
    }

    @Step("input lesson description")
    public void setInputLessonName(String lessonName) {
        inputLessonName.sendKeys(lessonName);
    }

    @Step("input lesson description")
    public void setInputLessonDescription(String lessonDescription) {
        inputLessonDescription.sendKeys(lessonDescription);
    }

    @Step("input number of students")
    public void setInputNumberOfStudent(String numberOfStudent) {
        inputNumberOfStudent.sendKeys(numberOfStudent);
    }

    @Step("input course price")
    public void setInputCoursePrice(String coursePrice) {
        inputCoursePrice.sendKeys(coursePrice);
    }

    @Step("select teacher name")
    public void setSelectTeacher(String teacherID) {
        selectTeacher.click();
        Select select = new Select(selectTeacher);
        select.selectByValue(teacherID);
    }

    @Step("set Date From")
    public void setInputDateFrom(String dateFrom) {
//        inputDateFrom.sendKeys(dateFrom);
        this.inputDateFrom.sendKeys(dateFrom);
        this.buttonSet.click();
    }

    @Step("set Date To")
    public void setInputDateTo(String dateTo) {
//        inputDateTo.sendKeys(dateTo);
        this.inputDateTo.sendKeys(dateTo);
        this.buttonSet.click();

    }


    @Step("upload course photo")
    public void setUploadCoursePhoto(String pathtophoto) {
        uploadCoursePhotoButton.sendKeys(pathtophoto);
        }

/*        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hannlb\\Documents\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port");
        String url = "https://qccareerstart.vn/employers/employercenter/postcourse";
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get(url);
            driver.findElement(By.id("filephoto")).sendKeys("C:\\Users\\hannlb\\Pictures\\image300x300.png");
//            driver.findElement(By.id("filephoto")).sendKeys(filePathPhoto);
            System.out.println("File uploaded successfully.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    /*@Step("upload course banner")
    public void setUploadCourseBanner(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hannlb\\Desktop\\Katalon_Studio_Windows_64-8.3.0 (1)\\Katalon_Studio_Windows_64-8.3.0\\configuration\\resources\\drivers\\chromedriver_win32"); // Replace with the path to your chromedriver.exe

        WebDriver driver = new ChromeDriver();
        try {
            driver.get(urlBanner);

            WebElement uploadButton = driver.findElement(By.id(String.valueOf(urlBanner)));
            ((RemoteWebElement) uploadButton).setFileDetector(new LocalFileDetector());
            uploadButton.sendKeys(filePathBanner);

            System.out.println("File uploaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }*/

    @Step("click on Add course button")
    public void clickOnAddCourseButton() {
        saveCourseButton.click();
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

}
