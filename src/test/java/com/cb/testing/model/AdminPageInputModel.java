package com.cb.testing.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;

@Data
@NoArgsConstructor
public class AdminPageInputModel {
    private String enValue;
    private String vieValue;
    private WebElementFacade buttonToClick;
    private String priority;
}
