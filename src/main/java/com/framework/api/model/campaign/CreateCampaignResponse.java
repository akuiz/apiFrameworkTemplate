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
public class CreateCampaignResponse {
    private Id id;
    private List<String> discountIDs;

    public String getIdValue(){
        return id.getId();
    }
}
