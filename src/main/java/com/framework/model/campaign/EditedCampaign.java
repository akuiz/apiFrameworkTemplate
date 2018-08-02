package com.framework.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.framework.model.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "id" })
public class EditCampaign {
    private String name;
    private Boolean test = true;
    private Boolean production = false;
    private String start;
    private String end;
    private List<Id> discounts;

    public EditCampaign(Campaign campaign, List<Id> discountIDs){

    }
}
