package com.thainguyen.pigeonhole.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonPage extends UIInteractions {

    @Step("And I verify that I'm at {0} page")
    public void verifyAtPage(String expectedPageTitle){
        String pageTitle = getTitle();
        Serenity.reportThat("Home page title should be {0}'",
                () -> assertThat(pageTitle).isEqualTo(expectedPageTitle)
        );
    }
}
