package com.cb.testing.test.cb.ts.TsVietnamModuleTest;

import com.cb.testing.model.AdminPageInputModel;
import com.cb.testing.model.CheckBoxInMenuPageModel;
import com.cb.testing.pages.cb.ts.TsVietnam.AdminPage;
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
        adminPage.setKeywordOwner("templatep411");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigMenuButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnAddNewMenuButton();
    }


    @Test
    public void createNewRegularTalentNetwork() throws InterruptedException{
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.hoverAndClickOnCreateNewTs();
        adminPage.insertEmloyerIDToCheck("95902");
        adminPage.createRegularTalentNetWork();
        adminPage.switchToTabById(1);
        adminPage.selectOwnerTemplate("A5");
        adminPage.inputDomainName("talentnetworkdev-dhktktbinhduong.vn");
        adminPage.inputOwnerName("dhktktbinhduong");
        adminPage.inputReOwnerName("dhktktbinhduong");
        adminPage.saveNewOwner();


    }

    @Test
    public void createNewAutoTalentNetwork() throws InterruptedException{
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("qchannguyen", "123456");
        adminPage.hoverAndClickOnCreateNewTs();
        adminPage.insertEmloyerIDToCheck("9600");
        adminPage.createAutoTalentNetwork();
        adminPage.switchToTabById(1);
        adminPage.selectOwnerTemplate("A5");
        adminPage.selectOwnerCopy("daihocktktcn");
        adminPage.inputDomainName("talentnetworkdev-daihocktktcn.vn");
        adminPage.inputOwnerName("daihocktktcn");
        adminPage.inputReOwnerName("daihocktktcn");
        adminPage.saveNewOwner();

    }

    @Test
    public void configTalentSolutionTab() throws InterruptedException{
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("dhktktbinhduong");
        adminPage.clickOnFilterButton();
        adminPage.clickOnOwnerName();
        adminPage.switchToTabById(1);
        adminPage.clickOnConfigTalentSolutionTab();
        adminPage.clickOnTheLanguageCheckBox(generateCheckboxesValue());
        adminPage.clickOnTheLanguageRadioButton();
        adminPage.clickOnSaveConfigTalentSolutionButton();

    }
    private List<String> generateCheckboxesValue() {
        return new ArrayList<>(Arrays.asList("en", "vi"));
    }

    @Test
    public void addOnConfigForOwnerTest() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("dhktktbinhduong");
        adminPage.clickOnFilterButton();
        adminPage.clickOnOwnerName();
        adminPage.switchToTabById(1);
        adminPage.configFunctionAddOn();
        adminPage.clickOnTheCheckBox(generateCheckboxesId());
        adminPage.clickOnSaveButtonAddOn();

        //TODO: add verification points
    }

    private List<String> generateCheckboxesId() {
        return new ArrayList<>(Arrays.asList("8", "9", "14", "36", "34"));
    }


    @Test
    public void configMenuForOwnerTest() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("dhktktbinhduong");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigMenuButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnAddNewMenuButton();
        adminPage.insertMenuItemForOwner(generateAdminPageInputModel());
        adminPage.clickOnDesiredMenuItemCheckbox(generateMenuCheckBoxItemToClick());
        adminPage.clickOnUpdateMenuCheckbox();
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
        adminPage.setKeywordOwner("dhktktbinhduong");
        adminPage.clickOnFilterButton();
        adminPage.clickOnConfigCateIndustryButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnDesiredIndustryItemCheckbox(generateCheckboxesIndustryIdToClick());
        adminPage.clickOnSaveIndustryButton();
    }
    private List<String> generateCheckboxesIndustryIdToClick() {
        List<String> numberList = new ArrayList<>();
        int[] excludedNumbers = {19, 40, 55, 56, 60, 62, 69, 70};

        for (int i = 1; i <= 71; i++) {
            boolean excluded = false;
            for (int j = 0; j < excludedNumbers.length; j++) {
                if (i == excludedNumbers[j]) {
                    excluded = true;
                    break;
                }
            }
                if (!excluded) {
                    numberList.add(String.valueOf(i));
                }
            }
            /*for (int h = 298; h <= 311; h++) {
                boolean excludedNum = false;
                for (int k = 0; k < excludedNumbers.length; k++) {
                    if (h == excludedNumbers[k]) {
                        excludedNum = true;
                        break;
                    }
                }
                if (!excludedNum) {
                    numberList.add(String.valueOf(h));
                }
            }*/
        return numberList;
    }


    @Test
    public void configLocationForOwner() throws InterruptedException{
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("dhktktbinhduong");
        adminPage.clickOnFilterButton();
        adminPage.clickOnLocationButton();
        adminPage.switchToTabById(1);
        adminPage.clickOnLocationCheckbox(generateCheckboxesLocationIdToClick());
        adminPage.clickOnSaveLocationButton();

    }

    private List<String> generateCheckboxesLocationIdToClick() {
        return new ArrayList<>(Arrays.asList("4","8","18","19","20","22","23","25","26","27","29","30","31","33","34","36","37","38","39","50","52","53","54","55","56","57","58","59","60","61","62","63","64","66","67","68","70","71","72","73","74","75","76","77","78","79","210","211","240","241","280","281","320","321","350","351","510","511","650","651","780","781","900","901","1042","1064","1065","1069","1070","1071","1072"));
    }

    @Test
    public void configLevelForOwner() throws InterruptedException {
        adminPage.navigateAdminLoginPage();
        adminPage.loginWithUsernameAndPassword("adminrws", "123456");
        adminPage.clickOnEmployerButton();
        adminPage.clickKeywordRadioButton();
        adminPage.setKeywordOwner("dhktktbinhduong");
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
        adminPage.setKeywordOwner("dhktktbinhduong");
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
