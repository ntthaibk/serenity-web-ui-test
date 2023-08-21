package com.cb.testing.test.cb.ts.CareerStartModuleTest;

import com.cb.testing.model.EmailSignInInputModel;
import com.cb.testing.pages.cb.ts.CareerStart.CsJobseekerApplyCourse;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(SerenityJUnit5Extension.class)
public class CsApplyCourseModuleTest {

    @Managed()
    WebDriver webDriver;
    WebDriver driver;
    WebDriverWait wait;

    CsJobseekerApplyCourse csJobseekerApplyCourse;

    @Test
    public void applyCourseFromCourseDetail() throws InterruptedException {
        csJobseekerApplyCourse.applyForCourse(generateEmailSignInInputModel(),"https://qccareerstart.vn/khoa-hoc/microsoft-productivity-bundle-sharepoint-onenote-teams.35A4E96A.html");
    }
    private List<EmailSignInInputModel> generateEmailSignInInputModel() {

        EmailSignInInputModel email1 = new EmailSignInInputModel();
        email1.setUserName("hannguyen@yopmail.com");
        email1.setPassWord("Vkook123");

        EmailSignInInputModel email2 = new EmailSignInInputModel();
        email2.setUserName("hannguyen567@yopmail.com");
        email2.setPassWord("Vkook123");

        EmailSignInInputModel email3 = new EmailSignInInputModel();
        email3.setUserName("hannguyen345@yopmail.com");
        email3.setPassWord("Vkook123");

        EmailSignInInputModel email4 = new EmailSignInInputModel();
        email4.setUserName("hannguyen789@yopmail.com");
        email4.setPassWord("Vkook123");


        return new ArrayList<>(Arrays.asList(email1, email2, email3, email4));
    }
}



