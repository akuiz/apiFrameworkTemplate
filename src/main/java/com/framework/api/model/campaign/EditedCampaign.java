package com.framework.api.model.campaign;

import com.framework.api.model.other.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EditedCampaign {
    private String id;
    private String name;
    private Boolean test = true;
    private Boolean production = false;
    private String start;
    private String end;
    private List<Id> discounts;

    public void setDates(String startDate, String endDate){
        this.start = startDate;
        this.end = endDate;
    }
}
