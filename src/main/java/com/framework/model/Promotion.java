package com.framework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.framework.model.PromotionType.promo_pct_off;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    private String id = "";
    private String description;
    private double value;
    private PromotionType type;
    private PromotionCondition condition;

    public static Promotion testPromotion(){
        return new Promotion().builder()
                .description("TestAPIPromotion")
                .value(0.01)
                .type(promo_pct_off)
                .condition(PromotionCondition.adidas())
                .build();
    }



}