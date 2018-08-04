package com.framework.api.model.discount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.framework.api.model.promotion.Promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "id" })
public class Discount extends Promotion{
    private String id;
    private String campaignId;
    private String start;
    private String end;
    private Boolean production = false;
    private Boolean test = true;
    private Boolean deleted = false;
}
