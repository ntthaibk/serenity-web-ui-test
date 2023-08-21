package com.cb.testing.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;

@Data
@NoArgsConstructor

public class EmailSignInInputModel {
    private String userName;
    private String passWord;
    private String phoneNumber;
    private String courseURL;
    private WebElementFacade signInButton;
}
