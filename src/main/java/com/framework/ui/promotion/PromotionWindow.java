package com.framework.ui.promotion;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.model.Brand;
import com.framework.ui.model.promotion.Promotion;
import com.framework.ui.model.promotion.PromotionType;
import com.framework.ui.selector.CheckBoxSelector;
import com.framework.ui.selector.PromotionTypeSelector;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.framework.ui.model.promotion.PromotionType.BOGO;
import static com.framework.ui.model.promotion.PromotionType.OFF;

public class PromotionWindow extends PageObject {

    protected SelenideElement closeWindowButton = root.$(".close-dialog");
    protected SelenideElement name = root.$(".name__input");
    protected SelenideElement brandSelector = root.$(".rule__input");
    protected SelenideElement typeSelector = root.$(".type__input");
    protected SelenideElement value = root.$(".value__input");
    protected SelenideElement confirmAction = root.$(".btn__title");

    public PromotionWindow() {
        super($("app-dialog-add-edit-promo"));
    }

    protected PromotionsPage close() {
        closeWindowButton.click();
        return new PromotionsPage();
    }

    public PromotionWindow setName(String promotionName) {
        name.setValue(promotionName);
        return this;
    }

    public PromotionWindow setBrands(Brand... brands) {
        brandSelector.click();
        new CheckBoxSelector().setBrands(brands);
        background.click();
        return this;
    }

    public PromotionWindow setBrands(List<Brand> brands) {
        brandSelector.click();
        new CheckBoxSelector().setBrands(brands);
        background.click();
        return this;
    }

    public PromotionsPage confirm() {
        confirmAction.click();
        return new PromotionsPage();
    }

    protected PromotionWindow setValue(Double value) {
        if (!getPromotionType().equals(BOGO)) {
            this.value.setValue(value.toString());
        }
        return this;
    }

    public PromotionWindow setValues(Promotion promotion) {
        this.setName(promotion.getName())
                .setBrands(promotion.getBrands())
                .setType(promotion.getType())
                .setValue(promotion.getValue());
        return this;
    }

    public PromotionWindow setType(PromotionType type) {
        this.typeSelector.click();
        new PromotionTypeSelector().selectType(type);
        return this;
    }

    private PromotionType getPromotionType() {
        if (BOGO.displayName().equals(typeSelector.getText())) {
            return BOGO;
        } else return OFF;
    }

}
