package com.cb.testing.test.cb.ts;

import com.cb.testing.model.AdminPageInputModel;
import com.cb.testing.pages.cb.ts.AdminPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
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
        adminPage.clickOnEmployerButton();
        adminPage.clickOnKeyword();
        adminPage.setInputKeyword();
        adminPage.setConfigOwner();
        adminPage.switchToTabById(1);
        adminPage.configFunctionAddOn();
        adminPage.clickOnTheCheckBox(generateCheckboxesId());
        adminPage.clickOnSaveButtonAddOn();
        adminPage.switchToTabById(0);
        adminPage.configMenu();
        adminPage.switchToTabById(1);
        adminPage.setConfigMenu();
        adminPage.insertMenu(generateAdminPageInputModel());
        adminPage.configCateIndustry();
        adminPage.switchToTabById(1);
        adminPage.clickOnIndustryCheckBox(generateCheckboxCateIds());
    }

    private List<String> generateCheckboxCateIds(){
        return new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    }

    private List<String> generateCheckboxesId(){
        return new ArrayList<>(Arrays.asList("10", "19"));
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
