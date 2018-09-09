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
        ForecastModel optimizeResult = optimizePage.optimize(ForecastModel.firstHalfOctoberOptimize());
        assertThat(optimizeResult).isSameForecastAs(ForecastModel.firstHalfOctoberOptimize());
    }

    @Test(description = "Profitable one week campaign selected in optimize", groups = {"optimize"})
    public void optimizeWeekProfitableCampaign() {
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        ForecastModel oneProfitableCampaign = optimizePage.optimize(ForecastModel.oneProfitableWeekForecast());
        assertThat(oneProfitableCampaign).isSameForecastAs(ForecastModel.oneProfitableWeekForecast());
    }

    @Test(description = "Check optimize picks best campaigns via bruteforce forecast", groups = {"optimize"})
    public void optimizeBruteForceForecast() {
        Navigation navi = new Navigation();
        CampaignsComponent optimizePage = navi.navigateToOptimizePage();
        ForecastModel lastWeeksOctoberOptimize = optimizePage.optimize(ForecastModel.firstWeekOctoberForecast());
        CampaignsComponent forecastPage = navi.navigateToForecastPage();
        ForecastModel bestBruteForceforecast = forecastPage.getBestForecast();
        assertThat(lastWeeksOctoberOptimize).isSameForecastAs(bestBruteForceforecast);
    }

    @Test(description = "Optimize without campaigns should be disabled", groups = {"optimize"})
    public void checkOptimizeWithoutCampaigns(){
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        optimizePage.setDates(ForecastModel.ForecastWithoutCampaigns());
        optimizePage.optimizeDisabled();
        optimizePage.checkNoCampaignsFound();
    }

    @Test(description = "Optimize test confirmation alert", groups = {"optimize"})
    public void optimizeConfirmationAlertDecline(){
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        optimizePage.setDates(ForecastModel.ForecastWithManyCampaigns());
        optimizePage.declineLongOptimize();
        optimizePage.checkOptimizeProgressNotStarted();
    }

   @Test(description = "Optimize with many campaigns", groups = {"optimize"})
        public void optimizeConfirmationAlertAccept(){
        CampaignsComponent optimizePage = new Navigation().navigateToOptimizePage();
        optimizePage.longOptimize(ForecastModel.ForecastWithManyCampaigns());
    }

    @Test(description = "Check startDate/endDate datePicker validation", groups={"optimize"})
    public void optimizeDatePickerTest() {
        CampaignsComponent optimizePage = new Navigation().navigateToForecastPage();
        optimizePage.checkDatePicker();
    }

    @Test(description = "Check optimize process saves state")
    public void optimizeSaveState(){
        Navigation navigation = new Navigation();
        CampaignsComponent optimizePage = navigation.navigateToOptimizePage();
        Integer currentPercentage =  optimizePage.startOptmize(ForecastModel.firstWeekOctoberForecast());
        navigation.navigateToCampaignsPage();
        optimizePage = navigation.navigateToOptimizePage();
        optimizePage.checkOptimizeProgress(currentPercentage);
        optimizePage.waitForOptimize();
        assertThat(optimizePage.getForecast()).isSameForecastAs(ForecastModel.firstWeekOctoberForecast());
        navigation.navigateToForecastPage();
        optimizePage = navigation.navigateToOptimizePage();
        assertThat(optimizePage.getForecast()).isSameForecastAs(ForecastModel.firstWeekOctoberForecast());
    }


}
