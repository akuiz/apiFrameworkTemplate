package com.framework.api.client;

import com.framework.api.model.forecast.ForecastRequest;
import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface ForecastClient {
    @RequestLine("POST /api/forecast/false/0")
    @Headers("Content-Type: application/json")
    Response buildForecast(ForecastRequest forecastRequest);
}
