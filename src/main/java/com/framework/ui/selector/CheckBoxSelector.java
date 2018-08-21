package com.framework.ui.selector;

import com.framework.ui.model.Brand;
import com.framework.ui.model.promotion.Promotion;

import java.util.List;

public class CheckBoxSelector extends Selector {

    public void setBrands(Brand... brands){
        for (Brand brand : brands) {
            new CheckBoxElement(root, brand.displayName()).set();
        }
    }

    public void setBrands(List<Brand> brands){
        for (Brand brand : brands) {
            new CheckBoxElement(root, brand.displayName()).set();
        }
    }

    public void setDiscounts(List<Promotion> discounts) {
        for (Promotion promotion: discounts){
            new CheckBoxElement(root, promotion.getName()).set();
        }
    }
}
