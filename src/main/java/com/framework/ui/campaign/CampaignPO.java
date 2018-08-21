package com.framework.ui.campaign;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.RemoveWindow;
import com.framework.ui.model.campaign.Campaign;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CampaignPO extends PageObject {

    private SelenideElement deleteButton = root.$$(".mat-icon-button").last();
    private SelenideElement editButton = root.$$(".mat-icon-button").first();

    public CampaignPO(SelenideElement root) {
        super(root);
    }

    public CampaignPO(String name) {
        super($(byText(name)).parent().parent());
    }

    public CampaignsPage delete() {
        deleteButton.click();
        new RemoveWindow().confirmRemove();
        return new CampaignsPage();
    }

    public CampaignsPage edit(Campaign campaign) {
        editButton.click();
        return new CampaignWindow().setValues(campaign).confirm();
    }


}
