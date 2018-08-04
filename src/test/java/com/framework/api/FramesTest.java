package com.framework.api;

import com.framework.api.step.CampaignStep;
import com.framework.api.step.ForecastStep;
import com.framework.api.step.PromotionStep;
import com.framework.configuration.TestConfigurationAPI;
import com.framework.api.model.campaign.Campaign;
import com.framework.api.model.campaign.CreateCampaignResponse;
import com.framework.api.model.campaign.EditedCampaign;
import com.framework.api.model.forecast.ForecastRequest;
import com.framework.api.model.forecast.Period;
import com.framework.api.model.forecast.Periods;
import com.framework.api.model.promotion.Promotion;
import com.framework.api.model.promotion.TemplateID;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

@Feature("API tests")
@Story("Frames test")
@ContextConfiguration(classes = TestConfigurationAPI.class)
public class FramesTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PromotionStep promotionStep;

    @Autowired
    private CampaignStep campaignStep;

    @Autowired
    private ForecastStep forecastStep;

    private EditedCampaign calvinKlein5Off;
    private EditedCampaign calvinKleinBogo;
    private EditedCampaign adidas10Off;
    private EditedCampaign adidasBogo;
    private EditedCampaign freePeople5Off;
    private EditedCampaign freePeopleBogo;
    private EditedCampaign ckAdidasOFF;
    private EditedCampaign ckFreePeopleBOGO;
    private EditedCampaign freePeopleOFFBOGO;

    @BeforeClass
    public void prepareCampaigns(){
        TemplateID calvinKleinOFF = new TemplateID(promotionStep.addPromotion(Promotion.calvinKlein5OFF()));
        TemplateID calvinKleinBOGO = new TemplateID(promotionStep.addPromotion(Promotion.calvinKleinBOGO()));
        TemplateID adidasOFF = new TemplateID(promotionStep.addPromotion(Promotion.adidas10OFF()));
        TemplateID adidasBOGO = new TemplateID(promotionStep.addPromotion(Promotion.adidasBOGO()));
        TemplateID freePeopleOFF = new TemplateID(promotionStep.addPromotion(Promotion.freePeople5OFF()));
        TemplateID freePeopleBOGO = new TemplateID(promotionStep.addPromotion(Promotion.freePeopleBOGO()));

        Campaign campaign = Campaign.campaignWithPromotionIDS("Calvin Klein 5% OFF", Arrays.asList(calvinKleinOFF));
        CreateCampaignResponse createCampaignResponse = campaignStep.addCampaign(campaign);
        calvinKlein5Off = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("Calvin Klein BOGO", Arrays.asList(calvinKleinBOGO));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        calvinKleinBogo = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("Adidas 10% OFF", Arrays.asList(adidasOFF));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        adidas10Off = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("Adidas BOGO", Arrays.asList(adidasBOGO));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        adidasBogo = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("Free People 5% OFF", Arrays.asList(freePeopleOFF));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        freePeople5Off = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign
                .campaignWithPromotionIDS("Free People BOGO", Arrays.asList(freePeopleBOGO));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        freePeopleBogo = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("CK&Adidas OFF", Arrays.asList(calvinKleinOFF, adidasOFF));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        ckAdidasOFF = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("CK&FP BOGO", Arrays.asList(calvinKleinBOGO, freePeopleBOGO));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        ckFreePeopleBOGO = campaign.prepareCampaignToEditRequest(createCampaignResponse);

        campaign = Campaign.campaignWithPromotionIDS("FreePeople OFF&BOGO", Arrays.asList(freePeopleOFF, freePeopleBOGO));
        createCampaignResponse = campaignStep.addCampaign(campaign);
        freePeopleOFFBOGO = campaign.prepareCampaignToEditRequest(createCampaignResponse);
    }

    @Test(description = "Frames test 1#1")
    public void framesTest1_1(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames1_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }


    @Test(description = "Frames test 1#2")
    public void framesTest1_2(){
        calvinKlein5Off.setDates("2018-10-05", "2018-10-05");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-05", "2018-10-05");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames1_2().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 2#1")
    public void framesTest2_1(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-10", "2018-10-10");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames2_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 2#2")
    public void framesTest2_2(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-10", "2018-10-20");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames2_2().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 3#1")
    public void framesTest3_1(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-05", "2018-10-10");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames3_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 4#1")
    public void framesTest4_1(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-01", "2018-10-05");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames4_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 4#2")
    public void framesTest4_2(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-01", "2018-10-01");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames4_2().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 5#1")
    public void framesTest5_1(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-20");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-05", "2018-10-15");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames5_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 5#2")
    public void framesTest5_2(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-15", "2018-10-25");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames5_2().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 5#3")
    public void framesTest5_3(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-55", "2018-10-15");
        campaignStep.editCampaign(freePeopleBogo);
        for (Period forecastPeriod : Periods.frames5_3().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 6#1")
    public void framesTest6_1(){
        ckAdidasOFF.setDates("2018-10-01", "2018-10-10");
        campaignStep.editCampaign(ckAdidasOFF);
        ckFreePeopleBOGO.setDates("2018-10-01", "2018-10-05");
        campaignStep.editCampaign(ckFreePeopleBOGO);
        freePeopleOFFBOGO.setDates("2018-10-05", "2018-10-10");
        campaignStep.editCampaign(freePeopleOFFBOGO);
        for (Period forecastPeriod : Periods.frames6_1().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(ckAdidasOFF.getId(), ckFreePeopleBOGO.getId(), freePeopleOFFBOGO.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 6#2")
    public void framesTest6_2(){
        ckFreePeopleBOGO.setDates("2018-10-01", "2018-10-20");
        campaignStep.editCampaign(ckFreePeopleBOGO);
        freePeopleBogo.setDates("2018-10-01", "2018-10-07");
        campaignStep.editCampaign(freePeopleBogo);
        adidas10Off.setDates("2018-10-13", "2018-10-20");
        campaignStep.editCampaign(adidas10Off);
        for (Period forecastPeriod : Periods.frames6_2().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(ckFreePeopleBOGO.getId(), freePeopleBogo.getId(), adidas10Off.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }

    @Test(description = "Frames test 6#3")
    public void framesTest6_3(){
        calvinKlein5Off.setDates("2018-10-01", "2018-10-20");
        campaignStep.editCampaign(calvinKlein5Off);
        freePeopleBogo.setDates("2018-10-05", "2018-10-12");
        campaignStep.editCampaign(freePeopleBogo);
        adidas10Off.setDates("2018-10-08", "2018-10-16");
        campaignStep.editCampaign(adidas10Off);
        for (Period forecastPeriod : Periods.frames6_3().getPeriods()){
            ForecastRequest forecastRequest = ForecastRequest.builder()
                    .start(forecastPeriod.getStart())
                    .end(forecastPeriod.getEnd())
                    .campaigns(Arrays.asList(calvinKlein5Off.getId(), freePeopleBogo.getId(), adidas10Off.getId()))
                    .build();
            forecastStep.buildForecastDMSWithFrames(forecastRequest);
        }
    }
}
