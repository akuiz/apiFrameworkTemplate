package com.framework.ui.assertion;

import com.framework.ui.model.campaign.Campaign;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

public class CampaignAssert extends AbstractAssert<CampaignAssert, Campaign> {
    public CampaignAssert(Campaign actualCampaign) {
        super(actualCampaign, CampaignAssert.class);
    }

    public static CampaignAssert assertThat(Campaign actualCampaign) {
        return new CampaignAssert(actualCampaign);
    }

    @Step("Make sure campaigns are equal")
    public AbstractAssert isSameCampaignIgnoringDates(Campaign campaign) {
        isNotNull();
        if (!actual.getName().equals(campaign.getName())) {
            failWithMessage("Expected campaign's name to be <%s> but was <%s>", campaign.getName(), actual.getName());
        }
        for (int i = 0; i <campaign.getDiscounts().size() ; i++) {
            if (!actual.getDiscounts().get(i).getName().equals(campaign.getDiscounts().get(i).getName())) {
                failWithMessage("Expected campaign's discount name to be <%s> but was <%s>", campaign.getDiscounts().get(i).getName(), actual.getDiscounts().get(i).getName());
            }
        }
        return this;
    }

    @Step("Make sure campaigns are equal")
    public AbstractAssert isSameCampaignIgnoringPromotionDetails(Campaign campaign) {
        isNotNull();
        if (!actual.getName().equals(campaign.getName())) {
            failWithMessage("Expected campaign's name to be <%s> but was <%s>", campaign.getName(), actual.getName());
        }
        for (int i = 0; i <campaign.getDiscounts().size() ; i++) {
            if (!actual.getDiscounts().get(i).getName().equals(campaign.getDiscounts().get(i).getName())) {
                failWithMessage("Expected campaign's discount name to be <%s> but was <%s>", campaign.getDiscounts().get(i).getName(), actual.getDiscounts().get(i).getName());
            }
        }
        if(!actual.getStartDate().equals(campaign.getStartDate())){
            failWithMessage("Expected campaign's startDate to be <%s> but was <%s>", campaign.getStartDate(), actual.getStartDate());
        }
        if(!actual.getStartDate().equals(campaign.getStartDate())){
            failWithMessage("Expected campaign's endDate to be <%s> but was <%s>", campaign.getEndDate(), actual.getEndDate());
        }
        return this;
    }
}
