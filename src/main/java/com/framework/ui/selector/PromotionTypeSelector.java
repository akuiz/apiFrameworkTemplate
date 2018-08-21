package com.framework.ui.selector;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.model.promotion.PromotionType;

import static com.codeborne.selenide.Selectors.byText;
import static com.framework.ui.model.promotion.PromotionType.BOGO;
import static com.framework.ui.model.promotion.PromotionType.OFF;

public class PromotionTypeSelector extends Selector {

    private SelenideElement bogo = root.$(byText(BOGO.displayName()));
    private SelenideElement off = root.$(byText(OFF.displayName()));

    public void selectType(PromotionType type) {
        if (type.equals(BOGO)) {
            bogo.click();
        } else {
            off.click();
        }
    }

}
