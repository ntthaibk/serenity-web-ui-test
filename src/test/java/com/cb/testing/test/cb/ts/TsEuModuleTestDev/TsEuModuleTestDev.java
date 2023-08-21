package com.cb.testing.test.cb.ts.TsEuModuleTestDev;

import com.cb.testing.pages.cb.ts.TsEuOnDev.AdminTsEuPageDev;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SerenityJUnit5Extension.class)
public class TsEuModuleTestDev {

    @Managed()
    WebDriver webDriver;

    AdminTsEuPageDev adminTsEuPageDev;

    @Test
    public void createNewRequisition() throws InterruptedException{
        adminTsEuPageDev.clearCacheLanguage();
        adminTsEuPageDev.clearCacheSystem();
        adminTsEuPageDev.assignOwnerToTest("demo");
        adminTsEuPageDev.navigateAdminLoginPage();
        adminTsEuPageDev.loginWithUsernameAndPassWord("han.nguyen@mail.careerbuilder.vn","Vkook123");
        adminTsEuPageDev.hoverAndClickOnCreateNewRequisition();
        adminTsEuPageDev.selectHiringManager("Hân Nguyễn HR (han.nguyen@mail.careerbuilder.vn)");
        adminTsEuPageDev.selectRecruiterUser("Hân test account (nguyenlebaohanufm@gmail.com)");
        adminTsEuPageDev.setJobCode("A123");
        adminTsEuPageDev.setJobTitle("QA Analyst");
        adminTsEuPageDev.selectEmploymentType("1000");
    }

}

