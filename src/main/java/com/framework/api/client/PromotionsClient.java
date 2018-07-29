package com.framework.api.client;

import com.framework.model.Id;
import com.framework.model.Promotion;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface PromotionsClient {

    @RequestLine("POST /api/templates")
    @Headers("Content-Type: application/json")
    Id createTemplate(Promotion promotion);

    @RequestLine("DELETE /api/templates/{templateID}")
    @Headers("Content-Type: application/json")
    Response deleteTemplate(@Param("templateID") String templateID);

    @RequestLine("PUT /api/templates}")
    @Headers("Content-Type: application/json")
    Response updateTemplate();

}
