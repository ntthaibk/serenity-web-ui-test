package com.cb.testing.model;

import com.cb.testing.pages.cb.ts.AdminPage;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Iterator;

@Data
@NoArgsConstructor
public class AdminPageInputModel {
    private String enValue;
    private String vieValue;
    private WebElementFacade buttonToClick;
    private String priority;
}