package com.framework.ui;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.promotion.PromotionsPage;

import static com.codeborne.selenide.Selenide.$;

public class Navigation extends PageObject{

    public Navigation() {
        super($(".navigation"));
    }

    private SelenideElement promotionsLink = root.$$(".navigation__tab").first();
    private SelenideElement campaignsLink = root.$$(".navigation__tab").get(1);
    private SelenideElement forecastLink = root.$$(".navigation__tab").get(2);
    private SelenideElement optimizeLink = root.$$(".navigation__tab").last();

    public PromotionsPage navigateToPromotionsPage(){
        promotionsLink.click();
        return new PromotionsPage();
    }

}
