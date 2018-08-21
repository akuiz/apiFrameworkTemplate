package com.framework.ui;

import com.framework.ui.model.prediction.ForecastModel;
import com.framework.ui.predictive.CampaignsComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.framework.ui.assertion.ForecastModelAssert.assertThat;

@Feature("UI tests")
@Story("Optimize test")
public class OptimizeTest extends AbstractTest {

    @Test(description = "Basic Optimize test", groups = {"optimize"})
    public void basicOptimizeTest() {
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        ForecastModel optimizeResult = optimizePage.optimize(ForecastModel.firstHalfOctoberForecast());
        assertThat(optimizeResult).isSameForecastAs(ForecastModel.firstHalfOctoberForecast());
    }

    @Test(description = "Check optimize result twice", groups = {"optimize"})
    public void optimizeTwiceTest(){
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        ForecastModel firstOptimize = optimizePage.optimize(ForecastModel.firstHalfOctoberForecast());
        ForecastModel secondOptimize = optimizePage.optimize();
        assertThat(firstOptimize).isSameForecastAs(secondOptimize);
    }

    @Test(description = "Profitable one week campaign selected in optimize", groups = {"optimize"})
    public void optimizeWeekProfitableCampaign(){
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        ForecastModel oneProfitableCampaign = optimizePage.optimize(ForecastModel.oneProfitableWeekForecast());
        assertThat(oneProfitableCampaign).isSameForecastAs(ForecastModel.oneProfitableWeekForecast());
    }

    @Test(description = "Check optimize picks best campaigns via bruteforce forecast", groups = {"optimize"})
    public void optimizeBruteForceForecast(){
        Navigation navi = new Navigation();
       CampaignsComponent optimizePage = navi.navigateToOptimizePage();
       ForecastModel lastWeeksOctoberOptimize = optimizePage.optimize(ForecastModel.lastWeeksOctoberOptimize());
        CampaignsComponent forecastPage = navi.navigateToForecastPage();
        ForecastModel bestBruteForceforecast = forecastPage.getBestForecast();
        assertThat(lastWeeksOctoberOptimize).isSameForecastAs(bestBruteForceforecast);
    }





}
