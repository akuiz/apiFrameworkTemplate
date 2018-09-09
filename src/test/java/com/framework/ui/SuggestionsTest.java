package com.framework.ui;

import com.framework.ui.model.campaign.CampaignSuggestion;
import com.framework.ui.model.suggestions.Suggestion;
import com.framework.ui.suggestions.SuggestionsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.framework.ui.assertion.SuggestionAssert.assertThat;

@Feature("UI tests")
@Story("Suggestions test")
public class SuggestionsTest extends AbstractTest{

    @Test(description = "Basic suggestions test")
    public void basicSuggestionsTest(){
        SuggestionsPage suggestionsPage = new Navigation().navigateToSuggestionsPage();
        Suggestion firstSeptemberWeekSuggestion = suggestionsPage.generateSuggestions(Suggestion.firstSeptemberWeekSuggestion());
        assertThat(firstSeptemberWeekSuggestion).hasCampaign(CampaignSuggestion.testCampaignSuggestion());
    }

    @Test(description = "Date picker test")
    public void datePickerSuggestionsTest(){
        SuggestionsPage suggestionsPage = new Navigation().navigateToSuggestionsPage();
        suggestionsPage.checkDatePicker();
    }

    @Test(description = "Check no suggestions found")
    public void noCampaignsFoundTest() {
        SuggestionsPage suggestionsPage = new Navigation().navigateToSuggestionsPage();
        suggestionsPage.generateSuggestions(Suggestion.noCampaignsSuggestion());
        suggestionsPage.checkNoSuggestions();
    }

}
