package com.framework.ui.promotion;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.TabPage;
import com.framework.ui.model.promotion.Promotion;

import static com.codeborne.selenide.Selenide.$;

public class PromotionsPage extends TabPage{

    private SelenideElement addPromotionButton = $(".btn-add-promo");

    public PromotionsPage() {
        super($("app-promotions-page"));
    }

    public PromotionWindow clickAddPromotionButton(){
        addPromotionButton.click();
        return new PromotionWindow();
    }

    public PromotionPO addPromotion(Promotion promotion) {
        PromotionWindow addPromotionWindow = clickAddPromotionButton();
        addPromotionWindow.setValues(promotion).confirm();
        return new PromotionPO(promotion.getName());
    }

    public PromotionPO findPromotionByName(String name) {
        return new PromotionPO(name);
    }


}
