package com.thainguyen.serenitypic.test;

import com.thainguyen.serenitypic.pages.AgendaPage;
import com.thainguyen.serenitypic.pages.HomePage;
import com.thainguyen.serenitypic.pages.QandAPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
class DemoTest {

    @Managed()
    WebDriver driver;

    HomePage homePage;
    AgendaPage agendaPage;
    QandAPage qAndAPAge;

    private static final String EVENT_PASS_CODE = "1";
    private static final String ATTENDEE_CODE = "2";

    @Test
    public void fullTest(){
        homePage.navigateToPigeonHoleHomePage();
        homePage.verifyAtPage("Pigeonhole Live");
        homePage.inputEventPasscode(EVENT_PASS_CODE);
        homePage.inputAttendeeCode(ATTENDEE_CODE);
        agendaPage.verifyNavigatedToPage(EVENT_PASS_CODE);
        agendaPage.clickOnQAButton();
        qAndAPAge.verifyAtPage("Q&A - Pigeonhole Live");
        qAndAPAge.askQuestionUsingCode(EVENT_PASS_CODE);
        qAndAPAge.verifyModalBoxAppeared();
        qAndAPAge.finishAskingQuestionInModalBox();
        qAndAPAge.verifyQuestionListUpdated();
        qAndAPAge.addCommentToLastQuestion(EVENT_PASS_CODE);
        qAndAPAge.verifyCommentAppeared(EVENT_PASS_CODE);
        qAndAPAge.upvoteComment(EVENT_PASS_CODE);
        qAndAPAge.verifyCommentUpVoted();
    }
}
