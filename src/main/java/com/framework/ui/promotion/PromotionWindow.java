package com.framework.ui.promotion;

import com.framework.ui.PageObject;

import static com.codeborne.selenide.Selenide.$;

public abstract class PromotionWindow extends PageObject {

    public PromotionWindow() {
        super($("app-dialog-add-edit-promo"));
    }

}
