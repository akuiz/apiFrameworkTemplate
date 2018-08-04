package com.framework.api.client;

import com.framework.api.model.forecast.ForecastRequest;
import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface DMSClient {
    @RequestLine("POST /api/forecast/false/0?frames=true")
    @Headers("Content-Type: application/json")
    Response buildForecast(ForecastRequest forecastRequest);
}
