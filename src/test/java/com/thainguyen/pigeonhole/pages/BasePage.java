package com.thainguyen.pigeonhole.pages;

import com.thainguyen.pigeonhole.constant.PageUrlConstant;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class BasePage extends UIInteractions {

    @Step("Then I verify that I'm at {0} page")
    public void verifyAtPage(String expectedPageTitle){
        String pageTitle = getTitle();
        Serenity.reportThat(String.format("Home page title should be %s'", expectedPageTitle),
                () -> assertThat(pageTitle).isEqualTo(expectedPageTitle)
        );
    }

    @Step("Then I verify I've navigated to {0} page")
    public void verifyNavigatedToPage(String expectedPageUrl){
        String pageUrl = getDriver().getCurrentUrl();
        Serenity.reportThat(String.format("Current url should be [%s]'", String.format(PageUrlConstant.AGENDA_PAGE,expectedPageUrl)),
                () -> assertThat(pageUrl).isEqualTo(String.format(PageUrlConstant.AGENDA_PAGE,expectedPageUrl))
        );

    }
}
