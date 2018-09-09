package com.framework.data;

import com.framework.api.model.campaign.Campaign;
import com.framework.api.model.promotion.Promotion;
import com.framework.api.model.promotion.TemplateID;
import com.framework.api.step.CampaignStep;
import com.framework.api.step.PromotionStep;
import com.framework.configuration.TestConfigurationAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = TestConfigurationAPI.class)
public class Data extends AbstractTestNGSpringContextTests{

    @Autowired
    private PromotionStep promotionStep;

    @Autowired
    private CampaignStep campaignStep;

    @Test(description = "data_loader", groups = {"data_generate"})
    public void prepareData(){
        TemplateID ck10OFFID = new TemplateID(promotionStep.addPromotion(Promotion.ck10OFF()));
        TemplateID ckBOGOID = new TemplateID(promotionStep.addPromotion(Promotion.ckBOGO()));
        TemplateID adidas10OFFID = new TemplateID(promotionStep.addPromotion(Promotion.adidas10OFF()));
        TemplateID vans10OFFID = new TemplateID(promotionStep.addPromotion(Promotion.vans10OFF()));
        TemplateID ck20OFFID = new TemplateID(promotionStep.addPromotion(Promotion.ck20OFF()));

        Campaign campaign = Campaign.campaignWithPromotionIDS("at_optimize Profitable Campaign with 10 CK OFF",
                "2018-10-20",
                "2018-10-27",
                Arrays.asList(ck10OFFID));
        campaignStep.addCampaign(campaign);

        campaign = Campaign.campaignWithPromotionIDS("at_optimize Profitable Campaign with CK BOGO",
                "2018-10-18",
                "2018-10-24",
                Arrays.asList(ckBOGOID));
        campaignStep.addCampaign(campaign);

        campaign = Campaign.campaignWithPromotionIDS("at_optimize UnProfitable Campaign with Adidas OFF",
                "2018-10-15",
                "2018-10-19",
                Arrays.asList(adidas10OFFID));
        campaignStep.addCampaign(campaign);

        campaign = Campaign.campaignWithPromotionIDS("at_optimize UnProfitable Campaign with Vans OFF",
                "2018-10-01",
                "2018-10-03",
                Arrays.asList(vans10OFFID));
        campaignStep.addCampaign(campaign);

        campaign = Campaign.campaignWithPromotionIDS("at_optimize Profitable Campaign with 20 CK OFF",
                "2018-10-04",
                "2018-10-12",
                Arrays.asList(ck20OFFID));
        campaignStep.addCampaign(campaign);
    }

    @Test(description = "data_cleaner", groups = {"data_clean"})
    public void deleteTestData(){
        List<Promotion> promotions = promotionStep.getPromotions();
        for (Promotion promotion : promotions){
            if(promotion.getDescription().startsWith("at_"))
                promotionStep.deletePromotion(promotion);
        }
        List<Campaign> campaigns = campaignStep.getCampaigns();
        System.out.println(campaigns.size());
        for (Campaign campaign : campaigns){
            if(campaign.getName().startsWith("at_") && !campaign.getDeleted())
                campaignStep.deleteCampaign(campaign);
        }
    }
}
