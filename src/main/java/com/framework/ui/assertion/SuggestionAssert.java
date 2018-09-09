package com.framework.ui.assertion;

import com.framework.ui.model.campaign.CampaignSuggestion;
import com.framework.ui.model.suggestions.Suggestion;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

public class SuggestionAssert extends AbstractAssert<SuggestionAssert, Suggestion> {

    public SuggestionAssert(Suggestion actualSuggestion) {
        super(actualSuggestion, SuggestionAssert.class);
    }

    public static SuggestionAssert assertThat(Suggestion actualSuggestion) {
        return new SuggestionAssert(actualSuggestion);
    }

    @Step("Make sure suggestions are equal")
    public AbstractAssert isSameSuggestionAs(Suggestion suggestion) {
        isNotNull();
        if (!actual.getStartDate().equals(suggestion.getStartDate())) {
            failWithMessage("Expected suggestion's start date to be <%s> but was <%s>", suggestion.getStartDate(), suggestion.getEndDate());
        }
        if (!actual.getEndDate().equals(suggestion.getEndDate())) {
            failWithMessage("Expected suggestion's end date to be <%s> but was <%s>", suggestion.getEndDate(), suggestion.getEndDate());
        }
        for (int i = 0; i <suggestion.getCampaigns().size(); i++) {
            CampaignSuggestionAssert.assertThat(actual.getCampaigns().get(i)).isSameSuggestionCampaignAs(suggestion.getCampaigns().get(i));
        }
        return this;
    }

    @Step("Make sure suggestion contains specific campaign")
    public AbstractAssert hasCampaign(CampaignSuggestion campaignSuggestion) {
        isNotNull();
        for (int i = 0; i <actual.getCampaigns().size(); i++) {
            if(actual.getCampaigns().get(i).getName().equals(campaignSuggestion.getName())){
                CampaignSuggestionAssert.assertThat(actual.getCampaigns().get(i)).isSameSuggestionCampaignAs(campaignSuggestion);
            }
        }
        return this;
    }

}
