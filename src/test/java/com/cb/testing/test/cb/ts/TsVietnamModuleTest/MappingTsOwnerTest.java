package com.cb.testing.test.cb.ts.TsVietnamModuleTest;

import com.cb.testing.pages.cb.ts.TsVietnam.AdminPage;
import com.cb.testing.pages.cb.ts.TsVietnam.MappingTsOwnerPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SerenityJUnit5Extension.class)
    public class MappingTsOwnerTest {
    AdminPage adminPage;
    public MappingTsOwnerTest() {

        adminPage = new AdminPage();
    }

    @Managed
    WebDriver webDriver;

    @Steps
    MappingTsOwnerPage mappingTsOwnerPage;

    @Test
    public void testNavigationAndLogin() throws InterruptedException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\test-data\\180823-ttcsugar.xlsx";
            adminPage.navigateAdminLoginPage();
            adminPage.loginWithUsernameAndPassword("adminrws", "123456");
            mappingTsOwnerPage.navigateToMappingPage(filePath);
        }
}

