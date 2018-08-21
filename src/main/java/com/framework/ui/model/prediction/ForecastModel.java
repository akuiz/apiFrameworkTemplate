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

    public static ForecastModel firstHalfOctoberForecast(){
        return new ForecastModel().toBuilder()
                .startDate(firstOctober)
                .endDate(middleOctober)
                .campaigns(Arrays.asList(
                        Campaign.profitableCampaignWith20CKOFF()
                        ))
                .predictionValues(Prediction.firstHalfOctoberPredictions())
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
}
