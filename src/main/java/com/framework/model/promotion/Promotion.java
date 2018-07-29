package com.framework.model.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static com.framework.model.promotion.PromotionType.promo_pct_off;

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



}