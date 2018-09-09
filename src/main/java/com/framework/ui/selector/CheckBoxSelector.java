package com.framework.ui.selector;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.model.promotion.Brand;
import com.framework.ui.model.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class CheckBoxSelector extends Selector {

    private ElementsCollection checkedElements = $$(".mat-pseudo-checkbox-checked");

    public void setBrands(Brand... brands){
        for (Brand brand : brands) {
            new CheckBoxElement(root, brand.displayName()).set();
        }
    }

    public void setBrands(List<Brand> brands){
        if (brands != null) {
            ArrayList<Brand> activeBrands = getActiveBrands();
            for (Brand brand : activeBrands) {
               if(!brands.contains(brand)){
                   new CheckBoxElement(root, brand.displayName()).click();
               }
            }
            for (Brand brand : brands) {
                new CheckBoxElement(root, brand.displayName()).set();
            }
        }
    }

    public void setDiscounts(List<Promotion> discounts) {
        if (discounts != null) {
            ArrayList<Promotion> activePromotions = getActivePromotions();
            for (Promotion promotion : activePromotions) {
                if(!discounts.contains(promotion)){
                    new CheckBoxElement(root, promotion.getName()).click();
                }
            }
            for (Promotion promotion : discounts) {
                new CheckBoxElement(root, promotion.getName()).set();
            }
        }
        for (Promotion promotion: discounts){
            new CheckBoxElement(root, promotion.getName()).set();
        }
    }

    public ArrayList<Brand> getActiveBrands() {
        ArrayList<Brand> activeBrands = new ArrayList<Brand>();
        for (SelenideElement checkedBrand : checkedElements){
            activeBrands.add(Brand.fromString(checkedBrand.parent().$("span").getText()));
        }
        return activeBrands;
    }

    public ArrayList<Promotion> getActivePromotions() {
        ArrayList<Promotion> activePromotions = new ArrayList<Promotion>();
        for (SelenideElement checkedBrand : checkedElements){
            activePromotions.add(new Promotion(checkedBrand.parent().$("span").getText()));
        }
        return activePromotions;
    }
}
