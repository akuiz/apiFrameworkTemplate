package com.framework.model;

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
                .brand(Arrays.asList(1))
                .build();
    }
}
