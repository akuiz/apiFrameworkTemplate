package com.framework.ui.promotion;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.RemoveWindow;
import com.framework.ui.model.promotion.Promotion;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PromotionPO extends PageObject {

    private SelenideElement deleteButton = root.$$(".mat-icon-button").last();
    private SelenideElement editButton = root.$$(".mat-icon-button").first();
    private SelenideElement duplicateButton = root.$$(".mat-icon-button").get(1);

    public PromotionPO(SelenideElement root) {
        super(root);
    }

    public PromotionPO(String name) {
        super($(byText(name)).parent());
    }

    public PromotionsPage delete() {
        deleteButton.click();
        new RemoveWindow().confirmRemove();
        return new PromotionsPage();
    }

    public PromotionsPage edit(Promotion promotion) {
        editButton.click();
        new PromotionWindow().setValues(promotion).confirm();
        return new PromotionsPage();
    }

    public PromotionsPage duplicate() {
        duplicateButton.click();
        new PromotionWindow().confirm();
        return new PromotionsPage();
    }
}
