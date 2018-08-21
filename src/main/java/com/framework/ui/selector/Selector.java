package com.framework.ui.selector;

import com.codeborne.selenide.ElementsCollection;
import com.framework.ui.PageObject;

import static com.codeborne.selenide.Selenide.$;

public class Selector extends PageObject {

    public Selector() {
        super($(".mat-select-content"));
    }

    protected ElementsCollection values = root.$$(".mat-option-text");
}
