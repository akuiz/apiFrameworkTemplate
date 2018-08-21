package com.framework.ui.predictive;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.model.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CampaignElementToggle extends CampaignElement{

    private SelenideElement toggle = root.$(".mat-slide-toggle-bar");

    private SelenideElement name = root.$(".name-column__title");
    private ElementsCollection discounts = root.$$(".ng-star-inserted");

    public CampaignElementToggle(SelenideElement root) {
        super(root);
    }

    public CampaignElementToggle(String name) {
        super($(byText(name)).parent().parent());
    }

    public void toggleCampaign(){
        toggle.click();
    }

    public String getName() {
        return name.getText();
    }

    public List<Promotion> getDiscounts(){
        List<Promotion> promotions = new ArrayList<>();
        for (String discountName : discounts.texts()){
            promotions.add(new Promotion(discountName));
        }
        return promotions;
    }

    public CampaignElementToggle setDisabled() {
        if(toggle.parent().parent().has(cssClass("mat-checked"))){
            toggle.click();
        }
        return this;
    }

    public CampaignElementToggle setEnabled() {
        if(!toggle.parent().parent().has(cssClass("mat-checked"))){
            toggle.click();
        }
        return this;
    }
}
