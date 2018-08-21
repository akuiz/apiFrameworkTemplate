package com.framework.ui.predictive;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.DatePicker;
import com.framework.ui.TabPage;
import com.framework.ui.constants.Dates;
import com.framework.ui.model.campaign.Campaign;
import com.framework.ui.model.prediction.ForecastModel;
import com.framework.ui.model.prediction.Prediction;
import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CampaignsComponent extends TabPage implements Dates {

    private SelenideElement startDateInput = root.$(".start-date__input");
    private SelenideElement endDateInput = root.$(".end-date__input");

    private ElementsCollection toggles = root.$$(".mat-slide-toggle-thumb");
    private ElementsCollection activeToggles = root.$$(".mat-checked");

    private ElementsCollection optimizedCampaigns = root.$$(".optimized");

    private SelenideElement optimizeButton = root.$("button");
    private SelenideElement forecastButton = root.$(".btn__title");

    private long optimizeTimeout = 120000;

    public CampaignsComponent() {
        super($(".content__parts__left"));
        waitForDownload();
    }

    public CampaignsComponent setStartDate(DateTime startDate) {
        startDateInput.click();
        new DatePicker().setDate(startDate);
        return this;
    }

    public CampaignsComponent setEndDate(DateTime endDate) {
        endDateInput.click();
        new DatePicker().setDate(endDate);
        return this;
    }

    public CampaignsComponent setCampaignsForForecast(Campaign... campaigns) {
        for (Campaign campaign : campaigns) {
            new CampaignElementToggle(campaign.getName()).toggleCampaign();
        }
        return this;
    }

    public ForecastModel optimize() {
        optimizeButton.click();
        new OptimizeProgress().checkOptimizeProgressHasBeenStarted();
        waitForOptimize();
        Prediction predictionValues = new ChartComponent().getPredictionValues();
        return new ForecastModel(predictionValues, getPickedCampaigns(), getDates());
    }

    public ForecastModel forecast() {
        forecastButton.click();
        Prediction predictionValues = new ChartComponent().waitForForecast().getPredictionValues();
        return new ForecastModel(predictionValues, getToggledCampaigns(),getDates());
    }

    private List<Campaign> getToggledCampaigns() {
        List<Campaign> toggledCampaigns = new ArrayList<Campaign>();
        for (SelenideElement toggle : activeToggles) {
            CampaignElementToggle forecastCampaignElement = new CampaignElementToggle(toggle.parent().parent().parent());
            toggledCampaigns.add(new Campaign(forecastCampaignElement));
        }
        return toggledCampaigns;
    }

    public void waitForOptimize() {
        loader.waitUntil(not(visible), optimizeTimeout);
    }

    public void checkElementsDisabled() {
        startDateInput.shouldBe(disabled);
        endDateInput.shouldBe(disabled);
        for (SelenideElement toggle : toggles) {
            toggle.shouldBe(disabled);
        }
    }

    public List<Campaign> getPickedCampaigns() {
        List<Campaign> pickedCampaigns = new ArrayList<Campaign>();
        for (SelenideElement optimizedCampaign : optimizedCampaigns) {
            CampaignElement optimizedCampaignElement = new CampaignElement(optimizedCampaign);
            pickedCampaigns.add(new Campaign(optimizedCampaignElement));
        }
        return pickedCampaigns;
    }

    public ForecastModel optimize(ForecastModel forecastModel) {
        setEndDate(forecastModel.getEndDate());
        setStartDate(forecastModel.getStartDate());
        optimizeButton.click();
        new OptimizeProgress().checkOptimizeProgressHasBeenStarted();
        waitForOptimize();
        ChartComponent cc = new ChartComponent();
        Prediction predictionValues = cc.getPredictionValues();
        return new ForecastModel(predictionValues, getPickedCampaigns(), getDates());
    }

    public Pair<DateTime, DateTime> getDates() {
        String start = startDateInput.getValue();
        String end = endDateInput.getValue();
        return new Pair<>(dtf.parseDateTime(startDateInput.getValue()), dtf.parseDateTime(endDateInput.getValue()));
    }

    public ForecastModel getBestForecast() {
        int amountOfCampaigns = toggles.size();
        double amountOfPermutations = Math.pow(2, amountOfCampaigns);
        Prediction bestPrediction = Prediction.zeroPredtiction();
        ForecastModel bestForecast = ForecastModel.zeroForecast();
        for (int i = 1; i < amountOfPermutations; i++) {
            String permutation = Integer.toBinaryString(i);
            String finalPermutation = StringUtils.repeat("0", amountOfCampaigns - permutation.length()) + permutation;
            ForecastModel forecastModel = buildForecastBasedOnPermutations(finalPermutation);
            if(forecastModel.profitMoreThan(bestPrediction.getProfit().getValue())){
                bestForecast = forecastModel;
                bestPrediction = bestForecast.getPredictionValues();
            }
        }
        return bestForecast;
    }

    private ForecastModel buildForecastBasedOnPermutations(String permutation) {
        System.out.println(permutation);
        for (int i = 0; i <permutation.length(); i++) {
            CampaignElementToggle campaignElement = new CampaignElementToggle(toggles.get(i).parent().parent().parent());
            if (permutation.charAt(i) == '0') {
                campaignElement.setDisabled();
            } else {
                campaignElement.setEnabled();
            }
        }
        return forecast();
    }

    public CampaignsComponent setDates(ForecastModel forecastModel) {
        setEndDate(forecastModel.getEndDate());
        setStartDate(forecastModel.getStartDate());
        return this;
    }
}
