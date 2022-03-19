package com.thainguyen.pigeonhole.test;

import com.thainguyen.pigeonhole.pages.AgendaPage;
import com.thainguyen.pigeonhole.pages.HomePage;
import com.thainguyen.pigeonhole.pages.QandAPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class PigeonHoleTest {

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed()
    WebDriver driver;

    HomePage homePage;
    AgendaPage agendaPage;
    QandAPage qAndAPAge;

    private static final String EVENT_PASS_CODE = "QATESTERHOME";
    private static final String ATTENDEE_CODE = "RW6FAMQIK7ABYLN";

    @Test
    public void pigeonHoleFulLTest(){
        homePage.navigateToPigeonHoleHomePage();
        homePage.verifyAtPage("Pigeonhole Live");
        homePage.inputEventPasscode(EVENT_PASS_CODE);
        homePage.inputAttendeeCode(ATTENDEE_CODE);
        agendaPage.verifyNavigatedToPage(EVENT_PASS_CODE);
        agendaPage.clickOnQAButton();
        qAndAPAge.verifyAtPage("Q&A - Pigeonhole Live");



    }
}
