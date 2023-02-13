package com.cb.testing.test.cb.ts;

import com.cb.testing.model.AdminPageInputModel;
import com.cb.testing.model.CheckBoxInMenuPageModel;
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
    public void cleanUpMenuBeforeTestSuite() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigMenuButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnAddNewMenuButton();

    }


    @Test
    public void addOnConfigForOwnerTest() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnOwnerName();
        adminPage.switchToTabById(1);
        adminPage.configFunctionAddOn();
        adminPage.clickOnTheCheckBox(generateCheckboxesId());
        adminPage.clickOnSaveButtonAddOn();

        //TODO: add verification points
    }

    @Test
    public void configMenuForOwnerTest() throws InterruptedException{
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigMenuButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnAddNewMenuButton();
        adminPage.insertMenuItemForOwner(generateAdminPageInputModel());
        adminPage.clickOnDesiredMenuItemCheckbox(generateMenuCheckBoxItemToClick());
    }

    private List<String> generateCheckboxesId() {
        return new ArrayList<>(Arrays.asList("10", "19"));
    }

    private List<AdminPageInputModel> generateAdminPageInputModel() {
        AdminPageInputModel homeInput = new AdminPageInputModel();
        homeInput.setPriority("1");
        homeInput.setEnValue("Home");
        homeInput.setVieValue("Trang chủ");
        homeInput.setButtonToClick1(adminPage.getOptionHome());
        homeInput.setButtonToClick2(adminPage.getConfigMenuButton());
        homeInput.setButtonToClick3(adminPage.getAddNewButton());

        AdminPageInputModel aboutUsInput = new AdminPageInputModel();
        aboutUsInput.setPriority("2");
        aboutUsInput.setEnValue("About us");
        aboutUsInput.setVieValue("Giới thiệu");
        aboutUsInput.setButtonToClick1(adminPage.getOptionPage());
        aboutUsInput.setButtonToClick2(adminPage.getConfigMenuButton());
        aboutUsInput.setButtonToClick3(adminPage.getAddNewButton());

        AdminPageInputModel careerInput = new AdminPageInputModel();
        careerInput.setPriority("3");
        careerInput.setEnValue("Career Opportunities");
        careerInput.setVieValue("Cơ hội nghề nghiệp");
        careerInput.setButtonToClick1(adminPage.getOptionCareer());
        careerInput.setButtonToClick2(adminPage.getConfigMenuButton());
        careerInput.setButtonToClick3(adminPage.getAddNewButton());

        AdminPageInputModel newsInput = new AdminPageInputModel();
        newsInput.setPriority("4");
        newsInput.setEnValue("News");
        newsInput.setVieValue("Tin tức");
        newsInput.setButtonToClick1(adminPage.getOptionList());
        newsInput.setButtonToClick2(adminPage.getConfigMenuButton());
        newsInput.setButtonToClick3(adminPage.getAddNewButton());


        AdminPageInputModel contactInput = new AdminPageInputModel();
        contactInput.setPriority("5");
        contactInput.setEnValue("Contact");
        contactInput.setVieValue("Liên hệ");
        contactInput.setButtonToClick1(adminPage.getOptionContact());
        contactInput.setButtonToClick2(adminPage.getConfigMenuButton());
        contactInput.setButtonToClick3(adminPage.getAddNewButton());

        return new ArrayList<>(Arrays.asList(homeInput, aboutUsInput, careerInput, newsInput, contactInput));
    }

    private List<CheckBoxInMenuPageModel> generateMenuCheckBoxItemToClick() {
        CheckBoxInMenuPageModel trangChu = new CheckBoxInMenuPageModel();
        trangChu.setMenuName("Trang chủ");
        trangChu.setMenuColumnType(Boolean.FALSE);
        trangChu.setMenuCrossType(Boolean.TRUE);
        trangChu.setMenuFooterType(Boolean.TRUE);


        CheckBoxInMenuPageModel gioiThieu = new CheckBoxInMenuPageModel();
        gioiThieu.setMenuName("Giới thiệu");
        gioiThieu.setMenuColumnType(Boolean.FALSE);
        gioiThieu.setMenuCrossType(Boolean.TRUE);
        gioiThieu.setMenuFooterType(Boolean.TRUE);

        CheckBoxInMenuPageModel coHoiNgheNghiep = new CheckBoxInMenuPageModel();
        coHoiNgheNghiep.setMenuName("Cơ hội nghề nghiệp");
        coHoiNgheNghiep.setMenuColumnType(Boolean.FALSE);
        coHoiNgheNghiep.setMenuCrossType(Boolean.TRUE);
        coHoiNgheNghiep.setMenuFooterType(Boolean.TRUE);

        CheckBoxInMenuPageModel tinTuc = new CheckBoxInMenuPageModel();
        tinTuc.setMenuName("Tin tức");
        tinTuc.setMenuColumnType(Boolean.FALSE);
        tinTuc.setMenuCrossType(Boolean.TRUE);
        tinTuc.setMenuFooterType(Boolean.TRUE);

        CheckBoxInMenuPageModel lienHe = new CheckBoxInMenuPageModel();
        lienHe.setMenuName("Liên hệ");
        lienHe.setMenuColumnType(Boolean.FALSE);
        lienHe.setMenuCrossType(Boolean.TRUE);
        lienHe.setMenuFooterType(Boolean.TRUE);

        return new ArrayList<>(Arrays.asList(trangChu, gioiThieu, coHoiNgheNghiep, tinTuc, lienHe));

    }

    @Test
    public void configCateIndustryForOwner() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigCateIndustryButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnDesiredIndustryItemCheckbox(generateCheckboxesIndustryIdToClick());
        adminPage.clickOnSaveIndustryButton();
    }
    private List<String> generateCheckboxesIndustryIdToClick() {
        return new ArrayList<>(Arrays.asList("1", "2","3","4","5"));
    }

    @Test
    public void configLocationForOwner() throws InterruptedException{
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnLocationButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnLocationCheckbox(generateCheckboxesLocationIdToClick());
        adminPage.clickOnSaveLocationButton();

    }

    private List<String> generateCheckboxesLocationIdToClick() {
        return new ArrayList<>(Arrays.asList("4", "8","18","19","20"));
    }

    @Test
    public void configLevelForOwner() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigLevelButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnLevelCheckboxes(generateCheckboxesLevelIdToClick());
        adminPage.clickOnSaveLevelButton();
    }

    private List <String> generateCheckboxesLevelIdToClick() {
        return new ArrayList<>(Arrays.asList("1","2","3","4","5"));
    }

    @Test
    public void configDegreeForOwner() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("demoa1");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigDegreeButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnDegreeCheckboxes(generateCheckboxesDegreeIdToClick());
        adminPage.clickOnSaveDegreeButton();
    }

    private List <String> generateCheckboxesDegreeIdToClick() {
        return new ArrayList<>(Arrays.asList("1","2","3","4","5"));
    }


}
