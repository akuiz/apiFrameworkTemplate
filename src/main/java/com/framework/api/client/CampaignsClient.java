package com.framework.api.client;

import com.framework.model.campaign.Campaign;
import com.framework.model.campaign.CreateCampaignResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface CampaignsClient {

    @RequestLine("POST /api/campaigns")
    @Headers("Content-Type: application/json")
    CreateCampaignResponse addCampaign(Campaign campaign);

    @RequestLine("DELETE /api/campaigns")
    @Headers("Content-Type: application/json")
    Response deleteCampaign();

    @RequestLine("POST /api/campaigns/{campaignID}")
    @Headers("Content-Type: application/json")
    Response updateCampaign(@Param("campaignID") String campaignID);

}
