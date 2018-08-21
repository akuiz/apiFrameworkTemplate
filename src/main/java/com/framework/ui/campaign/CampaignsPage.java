package com.framework.ui.campaign;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.TabPage;
import com.framework.ui.model.campaign.Campaign;

import static com.codeborne.selenide.Selenide.$;

public class CampaignsPage extends TabPage{

    private SelenideElement addCampaignButton = root.$(".btn-add-promo");

    public CampaignsPage() {
        super($("app-campaigns-page"));
    }

    private CampaignWindow clickAddCampaignButton(){
        addCampaignButton.click();
        return new CampaignWindow();
    }

    public void addCampaign(Campaign campaign) {
        CampaignWindow campaignWindow = clickAddCampaignButton();
        campaignWindow.setValues(campaign).confirm();
    }
}
