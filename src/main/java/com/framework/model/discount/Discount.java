package com.framework.model.discount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.framework.model.promotion.Promotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
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
