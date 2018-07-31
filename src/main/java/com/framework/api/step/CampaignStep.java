package com.framework.api.step;

import com.framework.api.client.CampaignsClient;
import com.framework.model.campaign.Campaign;
import com.framework.model.campaign.CreateCampaignResponse;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignStep {

    @Autowired
    CampaignsClient campaignsClient;

    @Step("Add campaign")
    public CreateCampaignResponse addCampaign(Campaign campaign){
        CreateCampaignResponse response = campaignsClient.addCampaign(campaign);
        return response;
    }
}
