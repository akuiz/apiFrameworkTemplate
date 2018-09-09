package com.framework.ui.promotion;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.RemoveWindow;
import com.framework.ui.model.promotion.Brand;
import com.framework.ui.model.promotion.Promotion;
import com.framework.ui.model.promotion.PromotionType;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.framework.ui.model.promotion.PromotionType.BOGO;
import static com.framework.ui.model.promotion.PromotionType.OFF;

public class PromotionPO extends PageObject {

    private SelenideElement deleteButton = root.$$(".mat-icon-button").last();
    private SelenideElement editButton = root.$$(".mat-icon-button").first();
    private SelenideElement duplicateButton = root.$$(".mat-icon-button").get(1);

    private Double defaultBOGOValue = 0.01;

    private SelenideElement nameField = root.$(".name-column");
    private SelenideElement typeField = root.$(".type-column");
    private SelenideElement valueField = root.$(".value-column");
    private SelenideElement brandsField = root.$(".rule-column");

    public PromotionPO(SelenideElement root) {
        super(root);
    }

    public PromotionPO(String name) {
        super($(byText(name)).parent());
    }

    @Step("Delete promotion")
    public PromotionsPage delete() {
        logger.info("Delete promotion");
        deleteButton.click();
        new RemoveWindow().confirmRemove();
        return new PromotionsPage();
    }

    public PromotionsPage edit(Promotion promotion) {
        editButton.click();
        new PromotionWindow().setValues(promotion).confirm();
        return new PromotionsPage();
    }

    @Step("Duplicate promotion")
    public PromotionsPage duplicate() {
        logger.info("Duplicate promotion");
        duplicateButton.click();
        new PromotionWindow().confirm();
        return new PromotionsPage();
    }

    public Promotion getPromotionModel() {
        return new Promotion().toBuilder()
                .name(nameField.getText())
                .type(getType())
                .value(getValue())
                .brands(getBrands())
                .build();
    }

    private PromotionType getType(){
        if(typeField.getText().equals("Buy One Get One"))
            return BOGO;
        return OFF;
    }

    private Double getValue(){
        if (getType().equals(BOGO))
            return defaultBOGOValue;
        Integer percentage = Integer.valueOf(valueField.getText().substring(0, valueField.getText().length() - 1));
        return percentage/100.0;
    }

    private ArrayList<Brand> getBrands(){
        ArrayList<Brand> brands = new ArrayList<>();
        String[] brandValues = brandsField.getText().split(", ");
        for (String brandName : brandValues){
            brands.add(Brand.fromString(brandName));
        }
        return brands;
    }

    @Step("Edit promotion name")
    public PromotionsPage editPromotionName(String name) {
        logger.info("Edit promotion name");
        editButton.click();
        new PromotionWindow().setName(name).confirm();
        return new PromotionsPage();
    }

    @Step("Edit promotion value")
    public PromotionsPage editPromotionValue(Double value) {
        logger.info("Edit promotion value");
        editButton.click();
        new PromotionWindow().setValue(value).confirm();
        Selenide.sleep(500);
        return new PromotionsPage();
    }

    @Step("Edit promotion brands")
    public PromotionsPage editPromotionBrands(List<Brand> brands) {
        logger.info("Edit promotion brands");
        editButton.click();
        new PromotionWindow().setBrands(brands).confirm();
        Selenide.sleep(1000);
        return new PromotionsPage();
    }
}
