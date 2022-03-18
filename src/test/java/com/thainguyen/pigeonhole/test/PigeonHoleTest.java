package com.thainguyen.pigeonhole.test;

import com.thainguyen.pigeonhole.pages.CommonPage;
import com.thainguyen.pigeonhole.pages.HomePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.wikipedia.DisplayedArticle;
import starter.wikipedia.NavigateActions;
import starter.wikipedia.SearchActions;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class PigeonHoleTest {

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed()
    WebDriver driver;

    HomePage homePage;

    @Test
    public void pigeonHoleFulLTest(){
        homePage.navigateToPigeonHoleHomePage();
        homePage.verifyAtPage("Pigeonhole Live");
        homePage.inputEventPasscode("QATESTERHOME");
        homePage.inputAttendeeCode("RW6FAMQIK7ABYLN");


    }
}
