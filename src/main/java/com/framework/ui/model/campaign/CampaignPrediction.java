package com.framework.ui.model.campaign;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.TabPage;
import com.framework.ui.constants.Dates;
import com.framework.ui.model.prediction.ForecastModel;
import com.framework.ui.model.prediction.Prediction;
import javafx.util.Pair;
import org.joda.time.DateTime;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CampaignPrediction extends TabPage implements Dates {

    private SelenideElement nameInput = $(".name__input");
    private SelenideElement startDate = $(".start-date__input");
    private SelenideElement endDate = $(".end-date__input");
    private SelenideElement closeButton = $(".close-dialog");

    private SelenideElement baselineRevenue = $$(".revenue").first();
    private SelenideElement campaignsRevenue = $$(".revenue").last();
    private SelenideElement baselineProfit = $$(".profit").first();
    private SelenideElement campaignsProfit = $$(".profit").last();
    private SelenideElement baselineQuantity = $$(".quantity").first();
    private SelenideElement campaignsQuantity = $$(".quantity").last();

    public CampaignPrediction() {
        super($(".mat-dialog-container"));
        waitForDownload();
    }

    public String getName(){
        return nameInput.getText();
    }

    public DateTime getStartDate(){
        return dtf.parseDateTime(startDate.getValue());
    }

    public DateTime getEndDate(){
        return dtf.parseDateTime(endDate.getValue());
    }

    public Prediction getPrediction(){
            return new Prediction(
                    new Pair<>(baselineRevenue.getText(), campaignsRevenue.getText()),
                    new Pair<>(baselineProfit.getText(), campaignsProfit.getText()),
                    new Pair<>(baselineQuantity.getText(), campaignsQuantity.getText()));
    }

    public ForecastModel getForecastModel() {
        ForecastModel prediction = new ForecastModel().toBuilder()
                .endDate(getEndDate())
                .startDate(getStartDate())
                .campaigns(Arrays.asList(new Campaign(getName())))
                .predictionValues(getPrediction())
                .build();
        closeButton.click();
        return prediction;
    }

    public void close(){
        closeButton.click();
    }
}
