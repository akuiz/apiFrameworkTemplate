package com.framework.ui;

import com.codeborne.selenide.Selenide;
import com.framework.ui.campaign.CampaignPO;
import com.framework.ui.campaign.CampaignsPage;
import com.framework.ui.constants.Period;
import com.framework.ui.model.campaign.Campaign;
import com.framework.ui.model.prediction.ForecastModel;
import com.framework.ui.predictive.CampaignsComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.framework.ui.assertion.ForecastModelAssert.assertThat;

@Feature("UI tests")
@Story("Forecast test")
public class ForecastTest extends AbstractTest{

    @Test(description = "Check forecast values for one campaign", groups = {"forecast"})
    public void basicForecastTest(){
        CampaignsComponent forecastPage = new Navigation().navigateToForecastPage();
        ForecastModel forecastResult = forecastPage.forecast(ForecastModel.firstHalfOctoberForecast());
        assertThat(forecastResult).isSameForecastAs(ForecastModel.firstHalfOctoberForecast());
    }

    @Test(description = "Check forecast exists after 30 seconds", groups = {"forecast"})
    public void forecastRefreshResistantTest(){
        CampaignsComponent forecastPage = new Navigation().navigateToForecastPage();
        ForecastModel forecastResult = forecastPage.forecast(ForecastModel.firstHalfOctoberForecast());
        Selenide.sleep(5000);
        ForecastModel forecastAfterRefresh = forecastPage.getForecast();
        assertThat(forecastResult).isSameForecastAs(forecastAfterRefresh);
    }

    @Test(description = "Check forecast with 3 campaigns",  groups = {"forecast"})
    public void forecast3CampaignsTest(){
        CampaignsComponent forecastPage = new Navigation().navigateToForecastPage();
        ForecastModel forecastResult = forecastPage.forecast(ForecastModel.firstThreeWeeksOctoberForecast());
        assertThat(forecastResult).isSameForecastAs(ForecastModel.firstThreeWeeksOctoberForecast());
    }

    @Test(description = "Check forecast for the same campaign but with different dates", groups = {"forecast"})
    public void forecastDifferentDatesTest(){
        CampaignsComponent forecastPage = new Navigation().navigateToForecastPage();
        ForecastModel forecastResult = forecastPage.forecast(ForecastModel.firstHalfOctoberForecast());
        assertThat(forecastResult).isSameForecastAs(ForecastModel.firstHalfOctoberForecast());
        forecastPage.setDates(Period.firstOctoberWeek());
        ForecastModel secondForecast = forecastPage.forecast();
        assertThat(secondForecast).isSameForecastAs(ForecastModel.firstWeekOctoberForecast());
    }

    @Test(description = "Check startDate/endDate datePicker validation", groups={"forecast"})
    public void forecastDatePickerTest() {
        CampaignsComponent forecastPage = new Navigation().navigateToForecastPage();
        forecastPage.checkDatePicker();
    }

    @Test(description = "", groups={"forecast"})
    public void noCampaignsFoundTest() {
        CampaignsComponent forecastPage = new Navigation().navigateToForecastPage();
        forecastPage.setDates(Period.december());
        forecastPage.checkNoCampaignsFound();
    }

    @Test(description = "Forecast and prediction for the same campaign", groups={"forecast"})
    public void checkForecastAndPredictionCampaign() {
        Navigation navigation = new Navigation();
        CampaignsPage campaigns = navigation.navigateToCampaignsPage();
        CampaignPO campaign = campaigns.getCampaignByName(Campaign.profitableCampaignWith20CKOFF().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        CampaignsComponent forecastPage = navigation.navigateToForecastPage();
        ForecastModel forecastResult = forecastPage.forecast(ForecastModel.profitableCK20OFFForecast());
        assertThat(forecastResult).isSameForecastAs(predictionResult);
    }

}
