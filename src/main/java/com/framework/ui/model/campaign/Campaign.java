package com.framework.ui.model.campaign;

import com.framework.ui.constants.Dates;
import com.framework.ui.model.promotion.Promotion;
import com.framework.ui.predictive.CampaignElement;
import com.framework.ui.predictive.CampaignElementToggle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Campaign implements Dates {

    private String name;
    private DateTime startDate;
    private DateTime endDate;
    private List<Promotion> discounts;

    public Campaign(CampaignElementToggle forecastCampaignElement) {
        this.name = forecastCampaignElement.getName();
        this.discounts = forecastCampaignElement.getDiscounts();
    }

    public Campaign(CampaignElement optimizedCampaignElement) {
        this.name = optimizedCampaignElement.getName();
        this.discounts = optimizedCampaignElement.getDiscounts();
    }

    public static Campaign testCampaign(){
        return new Campaign().toBuilder()
                .name("TestUICampaign")
                .startDate(currentDate)
                .endDate(currentDatePlusMonth)
                .discounts(Arrays.asList(Promotion.testPromotion()))
                .build();
    }

    public static Campaign profitableCampaignWith10CKOFF(){
        return new Campaign().toBuilder()
                .name("[at_optimize] Profitable Campaign with 10 CK OFF")
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF()))
                .build();
    }

    public static Campaign profitableCampaignWith20CKOFF(){
        return new Campaign().toBuilder()
                .name("[at_optimize] Profitable Campaign with 20 CK OFF")
                .discounts(Arrays.asList(Promotion.optimizeCK20OFF()))
                .build();
    }


    public static Campaign profitableCampaignWithCKBOGO() {
        return new Campaign().toBuilder()
                .name("[at_optimize] Profitable Campaign with 20 CK BOGO")
                .discounts(Arrays.asList(Promotion.optimizeCKBOGO()))
                .build();
    }
}
