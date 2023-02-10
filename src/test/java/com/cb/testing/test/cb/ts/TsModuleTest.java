package com.cb.testing.test.cb.ts;

import com.cb.testing.model.AdminPageInputModel;
import com.cb.testing.pages.cb.ts.AdminPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
        adminPage.insertMenu(generateAdminPageInputModel());
        Thread.sleep(6000);
        adminPage.configCateIndustry();
        Thread.sleep(1000);
        adminPage.switchToTabCateIndustryById(1);
        Thread.sleep(1000);
        List<String> checkBoxCateIds = new ArrayList<>();
        checkBoxCateIds.add("1");
        checkBoxCateIds.add("2");
        checkBoxCateIds.add("3");
        checkBoxCateIds.add("4");
        checkBoxCateIds.add("5");
        adminPage.clickOnIndustryCheckBox(checkBoxCateIds);
        Thread.sleep(2000);

    }

    private List<AdminPageInputModel> generateAdminPageInputModel(){
        AdminPageInputModel homeInput = new AdminPageInputModel();
        homeInput.setPriority("1");
        homeInput.setEnValue("Home");
        homeInput.setVieValue("Trang chủ");
        homeInput.setButtonToClick(adminPage.getOptionHome());

        AdminPageInputModel aboutUsInput = new AdminPageInputModel();
        aboutUsInput.setPriority("2");
        aboutUsInput.setEnValue("About us");
        aboutUsInput.setVieValue("Giới thiệu");
        aboutUsInput.setButtonToClick(adminPage.getOptionPage());

        AdminPageInputModel careerInput = new AdminPageInputModel();
        careerInput.setPriority("3");
        careerInput.setEnValue("Career Opportunities");
        careerInput.setVieValue("Cơ hội nghề nghiệp");
        careerInput.setButtonToClick(adminPage.getOptionCareer());

        AdminPageInputModel newsInput = new AdminPageInputModel();
        newsInput.setPriority("4");
        newsInput.setEnValue("News");
        newsInput.setVieValue("Tin tức");
        newsInput.setButtonToClick(adminPage.getOptionList());

        AdminPageInputModel contactInput = new AdminPageInputModel();
        contactInput.setPriority("5");
        contactInput.setEnValue("Contact");
        contactInput.setVieValue("Liên hệ");
        contactInput.setButtonToClick(adminPage.getOptionContact());

        return new ArrayList<>(Arrays.asList(homeInput, aboutUsInput, careerInput, newsInput, contactInput));
    }




}
