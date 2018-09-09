package com.framework.ui;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.promotion.PromotionsPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RemoveWindow extends PageObject{
    public RemoveWindow() {
        super($(".mat-dialog-container"));
    }

    protected SelenideElement deleteButton = root.$(".btn__title");

    public PromotionsPage confirmRemove(){
        $(byText("REMOVE")).click();
        return new PromotionsPage();
    }
}
