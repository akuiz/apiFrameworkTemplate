package com.framework.ui.model.campaign;

import com.framework.ui.model.promotion.Brand;
import com.framework.ui.model.promotion.PromotionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.framework.ui.model.promotion.PromotionType.OFF;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampaignSuggestion {

    private String description;
    private String name;
    private PromotionType type;
    private Double value;
    private Brand brand;
    private String products;
    private Integer amountOfProducts;

    public static CampaignSuggestion testCampaignSuggestion(){
        return new CampaignSuggestion().toBuilder()
                .name("Opportunity: 5.00 % off from 2018-07-19 to 2018-07-30 inclusive on brand Adrianna Papell and assortment cd3dd2b1b840a79202ebb9d1cc757aa1")
                .description("Opportunity: 5.00 % off from 2018-07-19 to 2018-07-30 inclusive on brand Adrianna Papell and assortment cd3dd2b1b840a79202ebb9d1cc757aa1")
                .products("293496, 268385, 262580, 251304, 239923, 238488, 238076, 228477, 227627, 213941, 184005, 177474, 142346, 141691")
                .amountOfProducts(14)
                .value(0.05)
                .type(OFF)
                .brand(Brand.six)
                .build();
    }

}
