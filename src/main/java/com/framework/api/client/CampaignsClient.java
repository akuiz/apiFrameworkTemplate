package com.framework.api.client;

import com.framework.api.model.campaign.Campaign;
import com.framework.api.model.campaign.CreateCampaignResponse;
import com.framework.api.model.campaign.EditedCampaign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface CampaignsClient {

    @RequestLine("POST /api/campaigns")
    @Headers("Content-Type: application/json")
    CreateCampaignResponse addCampaign(Campaign campaign);

    @RequestLine("DELETE /api/campaigns/{campaignID}")
    @Headers("Content-Type: application/json")
    Response deleteCampaign(@Param("campaignID") String campaignID);

    @RequestLine("POST /api/campaigns/{campaignID}")
    @Headers("Content-Type: application/json")
    Response updateCampaign(EditedCampaign campaign, @Param("campaignID") String campaignID);

}
