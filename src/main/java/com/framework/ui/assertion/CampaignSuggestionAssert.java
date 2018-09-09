package com.framework.ui.assertion;

import com.framework.ui.model.campaign.CampaignSuggestion;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

public class CampaignSuggestionAssert extends AbstractAssert<CampaignSuggestionAssert, CampaignSuggestion> {

    public CampaignSuggestionAssert(CampaignSuggestion actualCampaign) {
        super(actualCampaign, CampaignSuggestionAssert.class);
    }

    public static CampaignSuggestionAssert assertThat(CampaignSuggestion actualCampaign) {
        return new CampaignSuggestionAssert(actualCampaign);
    }

    @Step("Make sure campaign suggestions are equal")
    public AbstractAssert isSameSuggestionCampaignAs(CampaignSuggestion suggestion) {
        isNotNull();
        if (!actual.getName().equals(suggestion.getName())) {
            failWithMessage("Expected campaign suggestion's name to be <%s> but was <%s>", suggestion.getName(), actual.getName());
        }
        if (!actual.getDescription().equals(suggestion.getDescription())) {
            failWithMessage("Expected campaign suggestion's description to be <%s> but was <%s>", suggestion.getDescription(), actual.getDescription());
        }
        if (!actual.getProducts().equals(suggestion.getProducts())) {
            failWithMessage("Expected campaign suggestion's products to be <%s> but was <%s>", suggestion.getProducts(), actual.getProducts());
        }
        if (!actual.getBrand().equals(suggestion.getBrand())) {
            failWithMessage("Expected campaign suggestion's brand to be <%s> but was <%s>", suggestion.getBrand(), actual.getBrand());
        }
        if (!actual.getValue().equals(suggestion.getValue())) {
            failWithMessage("Expected campaign suggestion's value to be <%s> but was <%s>", suggestion.getValue(), actual.getValue());
        }
        if (!actual.getAmountOfProducts().equals(suggestion.getAmountOfProducts())) {
            failWithMessage("Expected campaign suggestion's amount of products to be <%s> but was <%s>", suggestion.getAmountOfProducts(), actual.getAmountOfProducts());
        }
        if (!actual.getType().equals(suggestion.getType())) {
            failWithMessage("Expected campaign suggestion's type of products to be <%s> but was <%s>", suggestion.getType(), actual.getType());
        }
        return this;
    }

}
