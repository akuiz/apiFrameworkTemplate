package com.framework.ui.predictive;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;

import static com.codeborne.selenide.Selenide.$;

public class OptimizeDialog extends PageObject{

    private SelenideElement no = root.$$(".mat-button").first();
    private SelenideElement yes = root.$$(".mat-button").last();

    public OptimizeDialog() {
        super($(".confirm-optimize-dialog"));
    }

    public CampaignsComponent decline(){
        no.click();
        return new CampaignsComponent();
    }

    public CampaignsComponent accept(){
        yes.click();
        return new CampaignsComponent();
    }

}
