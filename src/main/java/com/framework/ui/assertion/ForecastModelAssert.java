package com.framework.ui.assertion;

import com.framework.ui.model.prediction.ForecastModel;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

public class ForecastModelAssert extends AbstractAssert<ForecastModelAssert, ForecastModel> {
    public ForecastModelAssert(ForecastModel actualForecast) {
        super(actualForecast, ForecastModelAssert.class);
    }

    public static ForecastModelAssert assertThat(ForecastModel actualForecast) {
        return new ForecastModelAssert(actualForecast);
    }

    @Step("Make sure forecasts are equal")
    public AbstractAssert isSameForecastAs(ForecastModel expectedForecast) {
        isNotNull();
        assertThat(actual).hasSamePredictionValues(expectedForecast);
        assertThat(actual).hasSameDates(expectedForecast);
        assertThat(actual).hasSameCampaigns(expectedForecast);
        return this;
    }

    private void hasSameDates(ForecastModel expectedForecast) {
        isNotNull();
        if (!actual.getStartDate().equals(expectedForecast.getStartDate())) {
            failWithMessage("Expected forecast's start date  to be <%s> but was <%s>", expectedForecast.getStartDate(), actual.getStartDate());
        }
        if (!actual.getEndDate().equals(expectedForecast.getEndDate())) {
            failWithMessage("Expected forecast's end date  to be <%s> but was <%s>", expectedForecast.getEndDate(), actual.getEndDate());
        }
    }

    private void hasSamePredictionValues(ForecastModel expectedForecast) {
        isNotNull();
        if (!actual.getPredictionValues().equals(expectedForecast.getPredictionValues())) {
            failWithMessage("Expected forecast's prediction values to be <%s> but was <%s>", expectedForecast.getPredictionValues(), actual.getPredictionValues());
        }
    }

    private void hasSameCampaigns(ForecastModel expectedForecast) {
        isNotNull();
        for (int i = 0; i < expectedForecast.getCampaigns().size(); i++) {
           CampaignAssert.assertThat(actual.getCampaigns().get(i)).isSameCampaignIgnoringDates(expectedForecast.getCampaigns().get(i));
        }
    }

}
