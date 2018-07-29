package com.framework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    private String id;
    private String description;
    private int value;
    private PromotionType type;
    private PromotionCondition condition;
}