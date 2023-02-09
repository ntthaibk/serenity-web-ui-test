package com.cb.testing.test.cb.ts;

import com.cb.testing.pages.cb.ts.AdminPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class TsModuleTest {

    @Managed()
    WebDriver webDriver;

    AdminPage adminPage;


    @Test
    public void testTSPage () throws InterruptedException {
        adminPage.navigateAdminLoginPage();

        adminPage.loginWithUsernameAndPassword();

        Thread.sleep(4000);

        adminPage.clickOnEmployerButton();

        Thread.sleep(2000);

        adminPage.clickOnKeyword();

        Thread.sleep(2000);

        adminPage.setInputKeyword();

        Thread.sleep(2000);

        adminPage.setConfigOwner();

        Thread.sleep(2000);

        adminPage.switchToNextTabById(1);

        Thread.sleep(2000);

        adminPage.configFunctionAddOn();

        Thread.sleep(4000);

        List<String> checkBoxIds = new ArrayList<>();
        checkBoxIds.add("10");
        checkBoxIds.add("19");
        adminPage.clickOnTheCheckBox(checkBoxIds);
        Thread.sleep(2000);

        adminPage.clickOnSaveButtonAddOn();

        Thread.sleep(2000);

        adminPage.switchToPreviousTabByID(0);

        Thread.sleep(2000);

        adminPage.configMenu();

        Thread.sleep(2000);

        adminPage.switchToTabMenuById(1);
        Thread.sleep(1000);

        adminPage.setConfigMenu();

        Thread.sleep(1000);

        adminPage.insertMenu();

        Thread.sleep(4000);

    }




}
