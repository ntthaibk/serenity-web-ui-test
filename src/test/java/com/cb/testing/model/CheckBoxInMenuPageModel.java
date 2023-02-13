package com.cb.testing.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckBoxInMenuPageModel {

    private String menuName;
    private Boolean menuCrossType;
    private Boolean menuColumnType;
    private Boolean menuFooterType;
}
