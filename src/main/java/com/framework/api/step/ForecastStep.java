package com.framework.api.step;

import com.framework.api.client.DMSClient;
import com.framework.api.client.ForecastClient;
import com.framework.api.model.forecast.ForecastRequest;
import feign.Response;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForecastStep {

    @Autowired
    ForecastClient forecastClient;

    @Autowired
    DMSClient dmsClient;

    @Step("Build forecast via main URL")
    public Response buildForecast(ForecastRequest forecastRequest){
        Response response = forecastClient.buildForecast(forecastRequest);
        return response;
    }

    @Step("Build forecast via dms URL")
    public Response buildForecastDMSWithFrames(ForecastRequest forecastRequest){
        Response response = dmsClient.buildForecast(forecastRequest);
        return response;
    }

}
