package com.framework.ui;

import com.framework.ui.campaign.CampaignPO;
import com.framework.ui.campaign.CampaignsPage;
import com.framework.ui.model.campaign.Campaign;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("UI tests")
@Story("Campaign test")
public class CampaignTest extends AbstractTest{
    @Test(description = "Basic campaign test", groups = {"ui"})
    public void basicCampaignTest(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.addCampaign(Campaign.testCampaign());
        new CampaignPO(Campaign.testCampaign().getName()).delete();
    }
}
