package com.framework.api;

import com.framework.api.step.CampaignStep;
import com.framework.api.step.PromotionStep;
import com.framework.configuration.TestConfigurationAPI;
import com.framework.model.Id;
import com.framework.model.campaign.Campaign;
import com.framework.model.campaign.CreateCampaignResponse;
import com.framework.model.promotion.Promotion;
import com.framework.model.promotion.TemplateID;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Arrays;

@Feature("API tests")
@Story("Campaign test")
@ContextConfiguration(classes = TestConfigurationAPI.class)
public class CampaignTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private PromotionStep promotionStep;

    @Autowired
    private CampaignStep campaignStep;

    @Test(description = "Add campaign test")
    public void addCampaign(){
        Id promotionID = promotionStep.addPromotion(Promotion.testPromotion());
        TemplateID promotionTemplateID = new TemplateID(promotionID);
        Campaign campaign = Campaign.campaignWithPromotionIDS("testCampaignAPI",
                Arrays.asList(promotionTemplateID));
        CreateCampaignResponse createCampaignResponse = campaignStep.addCampaign(campaign);
    }
}
