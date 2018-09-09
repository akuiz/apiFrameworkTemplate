package com.framework.ui.campaign;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.model.campaign.CampaignSuggestion;
import com.framework.ui.model.promotion.Brand;
import com.framework.ui.model.promotion.PromotionType;

import static com.framework.ui.model.promotion.PromotionType.BOGO;
import static com.framework.ui.model.promotion.PromotionType.OFF;

public class CampaignSuggestionPO extends PageObject{

    private SelenideElement descriptionField = root.$(".description");
    private SelenideElement discountValueField = root.$(".discount__type").$(".value");
    private SelenideElement discountTypeField = root.$(".discount__value").$(".value");
    private SelenideElement assortmentBrand = root.$(".assortment__brand").$(".value");
    private SelenideElement assortmentProducts = root.$(".products");
    private SelenideElement nameField = root.$(".name-column__title");

    public CampaignSuggestionPO(SelenideElement root) {
        super(root);
    }

    public CampaignSuggestion getModel(){
        nameField.click();
        Selenide.sleep(500);
        return new CampaignSuggestion().toBuilder()
                .brand(getBrand())
                .name(nameField.getText())
                .description(descriptionField.getText())
                .products(assortmentProducts.getText())
                .type(getType())
                .value(getValue())
                .amountOfProducts(getAmountOfProducts())
                .build();
    }

    public Brand getBrand(){
        return Brand.fromString(assortmentBrand.getText());
    }

    public String getProducts(){
        return assortmentProducts.getText();
    }

    public Integer getAmountOfProducts(){
        return assortmentProducts.getText().split(", ").length;
    }

    public PromotionType getType(){
        if(discountTypeField.getText().equals("Buy One Get One"))
            return BOGO;
        return OFF;
    }

    public Double getValue(){
        String valueString = discountValueField.getText().substring(0,discountValueField.getText().length()-1);
        return Integer.valueOf(valueString)/ 100.0;
    }

}
