package com.framework.ui;

import static com.codeborne.selenide.Selenide.$;

public class Selector extends PageObject{

    public Selector() {
        super($(".mat-select-content"));
    }

    public void setValues(String... values){

    }

}
