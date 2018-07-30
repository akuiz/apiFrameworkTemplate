package com.framework.model.campaign;

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
public class CreateCampaignResponse {
    private Id id;
    private List<String> discountIDs;
}
