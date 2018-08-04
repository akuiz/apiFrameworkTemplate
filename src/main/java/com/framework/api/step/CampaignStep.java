package com.framework.api.step;

import com.framework.api.client.CampaignsClient;
import com.framework.api.model.campaign.Campaign;
import com.framework.api.model.campaign.CreateCampaignResponse;
import com.framework.api.model.campaign.EditedCampaign;
import feign.Response;
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

    @Step("Edit campaign")
    public Response editCampaign(EditedCampaign campaign){
        Response response = campaignsClient.updateCampaign(campaign, campaign.getId());
        return response;
    }

    public Response deleteCampaign(String id) {
        Response response = campaignsClient.deleteCampaign(id);
        return response;
    }

    public void changeCampaignsDates(EditedCampaign editedCampaign, String startDate, String endDate) {

    }
}
