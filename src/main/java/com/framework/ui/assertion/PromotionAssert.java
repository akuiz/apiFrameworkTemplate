package com.framework.ui.assertion;

import com.framework.ui.model.promotion.Promotion;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

public class PromotionAssert extends AbstractAssert<PromotionAssert, Promotion> {

    public PromotionAssert(Promotion actualPromotion) {
        super(actualPromotion, PromotionAssert.class);
    }

    public static PromotionAssert assertThat(Promotion actualPromotion) {
        return new PromotionAssert(actualPromotion);
    }

    @Step("Make sure promotions are equal")
    public AbstractAssert isSamePromotionAs(Promotion promotion) {
        isNotNull();
        if (!actual.getName().equals(promotion.getName())) {
            failWithMessage("Expected promotion's name to be <%s> but was <%s>", promotion.getName(), actual.getName());
        }
        if (!actual.getValue().equals(promotion.getValue())) {
            failWithMessage("Expected promotion's value to be <%s> but was <%s>", promotion.getValue(), actual.getValue());
        }
        if (!actual.getType().equals(promotion.getType())) {
            failWithMessage("Expected promotion's type to be <%s> but was <%s>", promotion.getType(), actual.getType());
        }
        if (!actual.getBrands().equals(promotion.getBrands())) {
            failWithMessage("Expected promotion's brands to be <%s> but was <%s>", promotion.getBrands(), actual.getBrands());
        }
        return this;
    }

}
