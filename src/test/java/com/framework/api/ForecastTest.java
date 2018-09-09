package com.framework.api;

import com.framework.api.model.campaign.Campaign;
import com.framework.api.model.campaign.CreateCampaignResponse;
import com.framework.api.model.forecast.ForecastRequest;
import com.framework.api.model.forecast.Period;
import com.framework.api.model.forecast.Periods;
import com.framework.api.model.other.Id;
import com.framework.api.model.promotion.Promotion;
import com.framework.api.model.promotion.TemplateID;
import com.framework.api.step.CampaignStep;
import com.framework.api.step.ForecastStep;
import com.framework.api.step.PromotionStep;
import com.framework.configuration.TestConfigurationAPI;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Arrays;

@Feature("API tests")
@Story("Forecast test")
@ContextConfiguration(classes = TestConfigurationAPI.class)
public class ForecastTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private PromotionStep promotionStep;

    @Autowired
    private CampaignStep campaignStep;

    @Autowired
    private ForecastStep forecastStep;

    @Test(description = "ForecastTest")
    public void forecastTest(){
        Id promotionID = promotionStep.addPromotion(Promotion.testPromotion());
        TemplateID promotionTemplateID = new TemplateID(promotionID);
        Campaign campaign = Campaign.campaignWithPromotionIDS("testCampaignAPI",
                Arrays.asList(promotionTemplateID));
        CreateCampaignResponse createCampaignResponse = campaignStep.addCampaign(campaign);
        for (Period forecastPeriod : Periods.frames1_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(createCampaignResponse.getId().getId()))
                    .build();
            forecastStep.buildForecast(forecastRequest);
        }
    }
}
