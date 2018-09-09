package com.framework.ui.model.prediction;

import com.framework.ui.constants.Dates;
import com.framework.ui.model.campaign.Campaign;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ForecastModel implements Dates {
    private Prediction predictionValues;
    private List<Campaign> campaigns;
    private DateTime startDate;
    private DateTime endDate;

    public ForecastModel(Prediction predictionValues, List<Campaign> pickedCampaigns) {
        this.predictionValues = predictionValues;
        this.campaigns = pickedCampaigns;
    }

    public ForecastModel(Prediction predictionValues, List<Campaign> pickedCampaigns, Pair<DateTime, DateTime> dates) {
        this.predictionValues = predictionValues;
        this.campaigns = pickedCampaigns;
        this.startDate = dates.getKey();
        this.endDate = dates.getValue();
    }

    public static ForecastModel testForecast(){
        return new ForecastModel().toBuilder()
                .startDate(currentDate)
                .endDate(currentDatePlusMonth)
                .campaigns(Arrays.asList(Campaign.testCampaign()))
                .predictionValues(Prediction.testPrediction())
                .build();
    }

    public static ForecastModel testOctoberForecast(){
        return new ForecastModel().toBuilder()
                .startDate(firstOctober)
                .endDate(endOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF(),
                        Campaign.profitableCampaignWithCKBOGO(),
                        Campaign.profitableCampaignWith10CKOFF()
                        ))
                .predictionValues(Prediction.fullOctoberPredictions())
                .build();
    }

    public static ForecastModel firstHalfOctoberOptimize(){
        return new ForecastModel().toBuilder()
                .startDate(firstOctober)
                .endDate(middleOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                        ))
                .predictionValues(Prediction.firstHalfOctoberPredictions())
                .build();
    }

    public static ForecastModel firstHalfOctoberForecast(){
        return new ForecastModel().toBuilder()
                .startDate(firstOctober)
                .endDate(middleOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                        ))
                .predictionValues(Prediction.firstHalfOctoberForecast())
                .build();
    }

    public static ForecastModel firstWeekOctoberForecast(){
        return new ForecastModel().toBuilder()
                .startDate(firstOctober)
                .endDate(seventhOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                        ))
                .predictionValues(Prediction.firstWeekOctoberForecast())
                .build();
    }

    public static ForecastModel firstThreeWeeksOctoberForecast(){
        return new ForecastModel().toBuilder()
                .startDate(firstOctober)
                .endDate(twentyOneOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith10CKOFF(),
                        Campaign.profitableCampaignWith20CKOFF(),
                        Campaign.profitableCampaignWithCKBOGO()
                        ))
                .predictionValues(Prediction.firstThreeWeeksOctoberForecast())
                .build();
    }

    public static ForecastModel oneProfitableWeekForecast() {
        return new ForecastModel().toBuilder()
                .startDate(forthOctober)
                .endDate(eleventhOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                ))
                .predictionValues(Prediction.oneProfitableWeekPrediction())
                .build();
    }

    public static ForecastModel lastWeeksOctoberOptimize() {
        return new ForecastModel().toBuilder()
                .startDate(middleOctober)
                .endDate(endOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWithCKBOGO(),
                        Campaign.profitableCampaignWith10CKOFF()
                ))
                .predictionValues(Prediction.lastWeeksOctoberPrediction())
                .build();
    }


    public static ForecastModel zeroForecast() {
        return new ForecastModel().toBuilder()
                .predictionValues(Prediction.zeroPredtiction())
                .build();
    }

    public boolean profitMoreThan(String value) {
        String doubleString = this.getPredictionValues().getProfit().getValue().replace(",", "").substring(1);
        double doubleValue = Double.parseDouble(doubleString);
        BigDecimal currentProfit = BigDecimal.valueOf(doubleValue);
        BigDecimal comparedProfit = BigDecimal.valueOf(Double.parseDouble(value.replace(",", "").substring(1)));
        if (currentProfit.compareTo(comparedProfit) == 1) {
            return true;
        }
        return false;
    }

    public static ForecastModel ForecastWithoutCampaigns() {
        return new ForecastModel().toBuilder()
                .startDate(firstDecember)
                .endDate(endDecember)
                .build();
    }

    public static ForecastModel ForecastWithManyCampaigns() {
        return new ForecastModel().toBuilder()
                .startDate(twentyThreeSeptember)
                .endDate(endSeptember)
                .build();
    }

    public static ForecastModel profitableCK20OFFForecast() {
        return new ForecastModel().toBuilder()
                .startDate(forthOctober)
                .endDate(twelveOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                ))
                .predictionValues(Prediction.profitableCK20OFFPredictionValues())
                .build();
    }

    public static ForecastModel demoAdriannaPapellSpring2018() {
        return new ForecastModel().toBuilder()
                .startDate( Campaign.demoAdriannaPapellSpring2018().getStartDate())
                .endDate( Campaign.demoAdriannaPapellSpring2018().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoAdriannaPapellSpring2018()
                ))
                .predictionValues(Prediction.demoAdriannaPapellSpring2018())
                .build();
    }

    public static ForecastModel demoAdriannaPapellSpringExtended2018() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoAdriannaPapellSpringExtended2018().getStartDate())
                .endDate(Campaign.demoAdriannaPapellSpringExtended2018().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoAdriannaPapellSpringExtended2018()
                ))
                .predictionValues(Prediction.demoAdriannaPapellSpringExtended2018())
                .build();
    }

    public static ForecastModel demoCalvinKleinAutumn10() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoCalvinKleinAutumn10().getStartDate())
                .endDate(Campaign.demoCalvinKleinAutumn10().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoCalvinKleinAutumn10()
                ))
                .predictionValues(Prediction.demoCalvinKleinAutumn10())
                .build();
    }

    public static ForecastModel demoCalvinKleinAutumn5() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoCalvinKleinAutumn5().getStartDate())
                .endDate(Campaign.demoCalvinKleinAutumn5().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoCalvinKleinAutumn5()
                ))
                .predictionValues(Prediction.demoCalvinKleinAutumn5())
                .build();
    }

    public static ForecastModel demoFreePeopleAutumn10() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleAutumn10().getStartDate())
                .endDate(Campaign.demoFreePeopleAutumn10().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleAutumn10()
                ))
                .predictionValues(Prediction.demoFreePeopleAutumn10())
                .build();
    }

    public static ForecastModel demoFreePeopleAutumn10FirstWeeks() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleAutumn10FirstWeeks().getStartDate())
                .endDate(Campaign.demoFreePeopleAutumn10FirstWeeks().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleAutumn10FirstWeeks()
                ))
                .predictionValues(Prediction.demoFreePeopleAutumn10FirstWeeks())
                .build();
    }

    public static ForecastModel demoFreePeopleAutumn10LastWeeks() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleAutumn10LastWeeks().getStartDate())
                .endDate(Campaign.demoFreePeopleAutumn10LastWeeks().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleAutumn10LastWeeks()
                ))
                .predictionValues(Prediction.demoFreePeopleAutumn10LastWeeks())
                .build();
    }

    public static ForecastModel demoFreePeopleAutumn20() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleAutumn20().getStartDate())
                .endDate(Campaign.demoFreePeopleAutumn20().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleAutumn20()
                ))
                .predictionValues(Prediction.demoFreePeopleAutumn20())
                .build();
    }

    public static ForecastModel demoFreePeopleAutumnBOGO() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleAutumnBOGO().getStartDate())
                .endDate(Campaign.demoFreePeopleAutumnBOGO().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleAutumnBOGO()
                ))
                .predictionValues(Prediction.demoFreePeopleAutumnBOGO())
                .build();
    }

    public static ForecastModel demoFreePeopleAutumnBOGOMiddle() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleAutumnBOGOMiddle().getStartDate())
                .endDate(Campaign.demoFreePeopleAutumnBOGOMiddle().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleAutumnBOGOMiddle()
                ))
                .predictionValues(Prediction.demoFreePeopleAutumnBOGOMiddle())
                .build();
    }

    public static ForecastModel demoCalvinKleinJune2018Dresses10() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoCalvinKleinJune2018Dresses10().getStartDate())
                .endDate(Campaign.demoCalvinKleinJune2018Dresses10().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoCalvinKleinJune2018Dresses10()
                ))
                .predictionValues(Prediction.demoCalvinKleinJune2018Dresses10())
                .build();
    }

    public static ForecastModel demoCalvinKleinJune2018Dresses5() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoCalvinKleinJune2018Dresses5().getStartDate())
                .endDate(Campaign.demoCalvinKleinJune2018Dresses5().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoCalvinKleinJune2018Dresses5()
                ))
                .predictionValues(Prediction.demoCalvinKleinJune2018Dresses5())
                .build();
    }

    public static ForecastModel demoCalvinKleinJune2018Dresses7() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoCalvinKleinJune2018Dresses7().getStartDate())
                .endDate(Campaign.demoCalvinKleinJune2018Dresses7().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoCalvinKleinJune2018Dresses7()
                ))
                .predictionValues(Prediction.demoCalvinKleinJune2018Dresses7())
                .build();
    }

    public static ForecastModel demoFreePeopleJuly2018() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleJuly2018().getStartDate())
                .endDate(Campaign.demoFreePeopleJuly2018().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleJuly2018()
                ))
                .predictionValues(Prediction.demoFreePeopleJuly2018())
                .build();
    }

    public static ForecastModel demoFreePeopleJuly2018BOGO() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.demoFreePeopleJuly2018BOGO().getStartDate())
                .endDate(Campaign.demoFreePeopleJuly2018BOGO().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.demoFreePeopleJuly2018BOGO()
                ))
                .predictionValues(Prediction.demoFreePeopleJuly2018BOGO())
                .build();
    }

    public static ForecastModel profitableCampaignWith20CKOFF() {
        return new ForecastModel().toBuilder()
                .startDate(Campaign.profitableCampaignWith20CKOFF().getStartDate())
                .endDate(Campaign.profitableCampaignWith20CKOFF().getEndDate())
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                ))
                .predictionValues(Prediction.profitableCampaignWith20CKOFF())
                .build();
    }
}
