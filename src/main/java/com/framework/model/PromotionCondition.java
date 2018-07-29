package com.framework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionCondition {
    private String type = "direct";
    private List<Integer> brands;

    public static PromotionCondition adidas(){
        return new PromotionCondition().builder()
                .brands(Arrays.asList(1))
                .build();
    }
}
