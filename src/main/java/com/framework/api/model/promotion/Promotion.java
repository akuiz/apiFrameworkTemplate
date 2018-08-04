package com.framework.api.model.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static com.framework.api.model.promotion.PromotionType.promo_bg;
import static com.framework.api.model.promotion.PromotionType.promo_pct_off;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    private String id = "";
    private String description;
    private double value;
    private PromotionType type;
    private List<PromotionCondition> condition;

    public static Promotion testPromotion(){
        return new Promotion().toBuilder()
                .description("TestAPIPromotion")
                .value(0.01)
                .type(promo_pct_off)
                .condition(Arrays.asList(PromotionCondition.adidas()))
                .build();
    }

    public static Promotion calvinKlein5OFF(){
        return new Promotion().toBuilder()
                .description("Calvin Klein 5% OFF")
                .value(0.05)
                .type(promo_pct_off)
                .condition(Arrays.asList(PromotionCondition.calvinKlein()))
                .build();
    }

    public static Promotion calvinKleinBOGO(){
        return new Promotion().toBuilder()
                .description("Calvin Klein BOGO")
                .value(0.01)
                .type(promo_bg)
                .condition(Arrays.asList(PromotionCondition.calvinKlein()))
                .build();
    }

    public static Promotion adidas10OFF(){
        return new Promotion().toBuilder()
                .description("adidas 10% OFF")
                .value(0.1)
                .type(promo_pct_off)
                .condition(Arrays.asList(PromotionCondition.adidas()))
                .build();
    }

    public static Promotion adidasBOGO(){
        return new Promotion().toBuilder()
                .description("adidas BOGO")
                .value(0.01)
                .type(promo_bg)
                .condition(Arrays.asList(PromotionCondition.adidas()))
                .build();
    }

    public static Promotion freePeople5OFF(){
        return new Promotion().toBuilder()
                .description("Free People 5% OFF")
                .value(0.05)
                .type(promo_pct_off)
                .condition(Arrays.asList(PromotionCondition.freePeople()))
                .build();
    }

    public static Promotion freePeopleBOGO(){
        return new Promotion().toBuilder()
                .description("Free People BOGO")
                .value(0.01)
                .type(promo_bg)
                .condition(Arrays.asList(PromotionCondition.freePeople()))
                .build();
    }



}