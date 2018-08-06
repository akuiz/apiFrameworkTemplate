package com.framework.ui.promotion;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.TabPage;

import static com.codeborne.selenide.Selenide.$;

public class PromotionsPage extends TabPage{

    private SelenideElement addPromotionButton = $(".btn-add-promo");

    public PromotionsPage() {
        super($("app-promotions-page"));
    }

    public CreatePromotion clickAddPromotionButton(){
        addPromotionButton.click();
        return new CreatePromotion();
    }

}
