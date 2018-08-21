package com.framework.ui.predictive;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.model.prediction.Prediction;
import javafx.util.Pair;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChartComponent extends PageObject {

    private SelenideElement revenueChart = $(".left__chart");
    private SelenideElement profitChart = $(".middle__chart");
    private SelenideElement quantityChart = $(".right__chart");

    private SelenideElement downloadSpinner = $(".mat-progress-spinner");

    private SelenideElement baselineRevenue = $$(".revenue").first();
    private SelenideElement campaignsRevenue = $$(".revenue").last();
    private SelenideElement baselineProfit = $$(".profit").first();
    private SelenideElement campaignsProfit = $$(".profit").last();
    private SelenideElement baselineQuantity = $$(".quantity").first();
    private SelenideElement campaignsQuantity = $$(".quantity").last();

    public ChartComponent() {
        super($(".content__parts__right"));
    }

    public void chartComponentCheck() {
        predictionChartsCheck();
        predictionValuesCheck();
    }

    private void predictionChartsCheck() {
        revenueChart.shouldBe(visible);
        profitChart.shouldBe(visible);
        quantityChart.shouldBe(visible);
    }

    private void predictionValuesCheck() {
        baselineRevenue.shouldBe(visible);
        campaignsRevenue.shouldBe(visible);
        baselineProfit.shouldBe(visible);
        campaignsProfit.shouldBe(visible);
        baselineQuantity.shouldBe(visible);
        campaignsQuantity.shouldBe(visible);
    }

    public Prediction getPredictionValues() {
        return new Prediction(
                new Pair<>(baselineRevenue.getText(), campaignsRevenue.getText()),
                new Pair<>(baselineProfit.getText(), campaignsProfit.getText()),
                new Pair<>(baselineQuantity.getText(), campaignsQuantity.getText()));
    }

    public ChartComponent waitForForecast() {
        downloadSpinner.waitUntil(not(visible), 30000);
        return this;
    }
}
