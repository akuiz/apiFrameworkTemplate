package com.framework.api.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface CampaignsClient {

    @RequestLine("[POST] /api/campaigns")
    @Headers("Content-Type: application/json")
    Response addCampaign();

    @RequestLine("[DELETE] /api/campaigns")
    @Headers("Content-Type: application/json")
    Response deleteCampaign();

    @RequestLine("[POST] /api/campaigns/{campaignID}")
    @Headers("Content-Type: application/json")
    Response updateCampaign(@Param("campaignID") String campaignID);

}
