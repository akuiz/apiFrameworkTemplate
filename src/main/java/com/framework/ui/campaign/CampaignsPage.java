package com.framework.ui.campaign;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.TabPage;
import com.framework.ui.model.campaign.Campaign;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.framework.ui.assertion.CampaignAssert.assertThat;

public class CampaignsPage extends TabPage{

    private SelenideElement addCampaignButton = root.$(".btn-add-promo");
    private ElementsCollection campaignElements = root.$$(".table__row");

    public CampaignsPage() {
        super($("app-campaigns-page"));
    }

    @Step("Click add campaign button")
    private CampaignWindow clickAddCampaignButton(){
        addCampaignButton.click();
        return new CampaignWindow();
    }

    @Step("Add campaign")
    public void addCampaign(Campaign campaign) {
        logger.info("Add campaign " + campaign.getName());
        CampaignWindow campaignWindow = clickAddCampaignButton();
        campaignWindow.setValues(campaign).confirm();
    }

    @Step("Get campaign by name")
    public CampaignPO getCampaignByName(String name) {
        logger.info("Get campaign by name " + name);
        return new CampaignPO($(byText(name)).parent().parent());
    }

    @Step("Check number of campaigns")
    public void checkNumberOfCampaigns(int i) {
        logger.info("Check number of campaigns " + i);
        campaignElements.shouldHaveSize(i);
    }

    @Step("Check campaign exists")
    public void checkCampaignExists(Campaign campaign) {
        logger.info("Check campaign exists " + campaign.getName());
        Campaign campaignModel = getCampaignByName(campaign.getName()).getModel();
        assertThat(campaignModel).isSameCampaignIgnoringPromotionDetails(campaign);
    }

    @Step("Check campaign not exists")
    public void checkCampaignNotExists(Campaign campaign) {
        logger.info("Check campaign not exists " + campaign.getName());
        $(byText(campaign.getName())).shouldNot(visible);
    }
}
