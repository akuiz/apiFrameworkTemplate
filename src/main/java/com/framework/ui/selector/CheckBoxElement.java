package com.framework.ui.selector;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.byText;

public class CheckBoxElement extends PageObject{

    private SelenideElement checkBox = root.$("mat-pseudo-checkbox");

    CheckBoxElement(SelenideElement selectorRoot, String value){
        super(selectorRoot.$(byText(value)).parent());
    }

    void set(){
        if(!checkBox.has(cssClass("mat-pseudo-checkbox-checked"))){
           checkBox.click();
        }
    }

    void click(){
           checkBox.click();
    }

    public boolean isEnabled() {
        return checkBox.has(cssClass("mat-pseudo-checkbox-checked"));
    }
}
