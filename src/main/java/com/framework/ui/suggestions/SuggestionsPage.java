package com.framework.ui.suggestions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.DatePicker;
import com.framework.ui.TabPage;
import com.framework.ui.campaign.CampaignSuggestionPO;
import com.framework.ui.model.campaign.CampaignSuggestion;
import com.framework.ui.model.suggestions.Suggestion;
import io.qameta.allure.Step;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.framework.ui.constants.Dates.dtf;

public class SuggestionsPage extends TabPage{

    private SelenideElement startDateInput = root.$(".start-date__input");
    private SelenideElement endDateInput = root.$(".end-date__input");
    private SelenideElement generateSuggestionsButton = root.$(".show-suggestions__btn").$(".btn");

    private SelenideElement noSuggestions = root.$(".no-data-message");

    private ElementsCollection campaigns = root.$$(".table__row");

    public SuggestionsPage() {
        super($("app-suggestions-page"));
    }

    public SuggestionsPage setStartDate(DateTime startDate){
        startDateInput.click();
        new DatePicker().setDate(startDate);
        return this;
    }

    public SuggestionsPage setEndDate(DateTime endDate){
        endDateInput.click();
        new DatePicker().setDate(endDate);
        return this;
    }

    public SuggestionsPage generateSuggestions(){
        generateSuggestionsButton.click();
        return new SuggestionsPage();
    }

    private DateTime getStartDate(){
        return dtf.parseDateTime(startDateInput.getValue());
    }

    private DateTime getEndDate(){
        return dtf.parseDateTime(endDateInput.getValue());

    }

    @Step("Generate suggestions")
    public Suggestion generateSuggestions(Suggestion suggestion) {
        logger.info("Generate suggestions");
        if(suggestion.getStartDate().isBefore(getStartDate())){
            setStartDate(suggestion.getStartDate());
            setEndDate(suggestion.getEndDate());
        }
        else{
            setEndDate(suggestion.getEndDate());
            setStartDate(suggestion.getStartDate());
        }
        generateSuggestionsButton.click();
        waitForDownload();
        return getSuggestionModel();
    }

    public Suggestion getSuggestionModel(){
        return new Suggestion().toBuilder()
                .startDate(getStartDate())
                .endDate(getEndDate())
                .campaigns(getCampaigns())
                .build();
    }

    public ArrayList<CampaignSuggestion> getCampaigns(){
        ArrayList<CampaignSuggestion> campaignSuggestions = new ArrayList<>();
        for(SelenideElement campaignRoot : campaigns){
            campaignSuggestions.add(new CampaignSuggestionPO(campaignRoot).getModel());
        }
        return campaignSuggestions;
    }

    public void checkDatePicker() {
        startDateInput.click();
        DatePicker dp = new DatePicker();
        dp.checkNextMonthButtonDisabled();
        dp.setDay(2);
        endDateInput.click();
        dp = new DatePicker();
        dp.checkPreviousMonthButtonDisabled();
        dp.cantPickDay(1);
        dp.setDay(29);
        startDateInput.click();
        dp = new DatePicker();
        dp.cantPickDay(30);
    }

    public void checkNoSuggestions() {
        noSuggestions.shouldBe(visible).has(text("No suggestions"));
    }
}
