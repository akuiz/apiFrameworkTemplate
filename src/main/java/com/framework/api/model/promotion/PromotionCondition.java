package com.framework.api.model.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PromotionCondition {
    private String type = "direct";
    private List<Integer> brand;

    public static PromotionCondition adidas(){
        return new PromotionCondition().toBuilder()
                .brand(Arrays.asList(211))
                .build();
    }

    public static PromotionCondition calvinKlein(){
        return new PromotionCondition().toBuilder()
                .brand(Arrays.asList(28))
                .build();
    }

    public static PromotionCondition freePeople(){
        return new PromotionCondition().toBuilder()
                .brand(Arrays.asList(60))
                .build();
    }

    public static PromotionCondition vans() {
        return new PromotionCondition().toBuilder()
                .brand(Arrays.asList(195))
                .build();
    }
}
