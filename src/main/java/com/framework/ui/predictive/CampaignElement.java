package com.framework.ui.predictive;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.model.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

public class CampaignElement extends PageObject{

    private SelenideElement name = root.$(".name-column__title");
    private ElementsCollection discounts = root.$$(".ng-star-inserted");

    public CampaignElement(SelenideElement root) {
        super(root);
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

}
