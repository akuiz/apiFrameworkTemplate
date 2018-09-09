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

import java.util.ArrayList;
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

    public Campaign(String name) {
        this.name = name;
    }

    public Campaign(String name, ArrayList<Promotion> promotions) {
        this.name = name;
        discounts = promotions;
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
                .name("at_optimize Profitable Campaign with 10 CK OFF")
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF()))
                .build();
    }

    public static Campaign profitableCampaignWith20CKOFF(){
        return new Campaign().toBuilder()
                .name("at_optimize Profitable Campaign with 20 CK OFF")
                .startDate(dtf.parseDateTime("10/4/2018"))
                .endDate(dtf.parseDateTime("10/12/2018"))
                .discounts(Arrays.asList(Promotion.optimizeCK20OFF()))
                .build();
    }


    public static Campaign profitableCampaignWithCKBOGO() {
        return new Campaign().toBuilder()
                .name("at_optimize Profitable Campaign with CK BOGO")
                .discounts(Arrays.asList(Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign demoAdriannaPapellSpring2018() {
        return new Campaign().toBuilder()
                .name("Adrianna Papell Spring 2018")
                .startDate(dtf.parseDateTime("5/11/2018"))
                .endDate(dtf.parseDateTime("5/31/2018"))
                .discounts(Arrays.asList(Promotion.DemoAdriannaPapellOFF5()))
                .build();
    }

    public static Campaign demoAdriannaPapellSpringExtended2018() {
        return new Campaign().toBuilder()
                .name("Adrianna Papell Spring 2018 Extended")
                .startDate(dtf.parseDateTime("5/11/2018"))
                .endDate(dtf.parseDateTime("6/9/2018"))
                .discounts(Arrays.asList(Promotion.DemoAdriannaPapellOFF5()))
                .build();
    }

    public static Campaign demoCalvinKleinAutumn10() {
        return new Campaign().toBuilder()
                .name("Autumn Calvin Klein 10")
                .startDate(dtf.parseDateTime("10/1/2018"))
                .endDate(dtf.parseDateTime("10/31/2018"))
                .discounts(Arrays.asList(Promotion.DemoCalvinKleinOFF10()))
                .build();
    }

    public static Campaign demoCalvinKleinAutumn5() {
        return new Campaign().toBuilder()
                .name("Autumn Calvin Klein 5")
                .startDate(dtf.parseDateTime("10/1/2018"))
                .endDate(dtf.parseDateTime("10/31/2018"))
                .discounts(Arrays.asList(Promotion.DemoCalvinKleinOFF5()))
                .build();
    }

    public static Campaign demoFreePeopleAutumn10() {
        return new Campaign().toBuilder()
                .name("Autumn Free People 10% Off")
                .startDate(dtf.parseDateTime("9/1/2018"))
                .endDate(dtf.parseDateTime("9/30/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleOFF10()))
                .build();
    }

    public static Campaign demoFreePeopleAutumn10FirstWeeks() {
        return new Campaign().toBuilder()
                .name("Autumn Free People 10% Off First Weeks")
                .startDate(dtf.parseDateTime("9/1/2018"))
                .endDate(dtf.parseDateTime("9/14/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleOFF10()))
                .build();
    }

    public static Campaign demoFreePeopleAutumn10LastWeeks() {
        return new Campaign().toBuilder()
                .name("Autumn Free People 10% Off Last Weeks")
                .startDate(dtf.parseDateTime("9/17/2018"))
                .endDate(dtf.parseDateTime("9/30/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleOFF10()))
                .build();
    }

    public static Campaign demoFreePeopleAutumn20() {
        return new Campaign().toBuilder()
                .name("Autumn Free People 20")
                .startDate(dtf.parseDateTime("10/1/2018"))
                .endDate(dtf.parseDateTime("10/31/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleOFF20()))
                .build();
    }

    public static Campaign demoFreePeopleAutumnBOGO() {
        return new Campaign().toBuilder()
                .name("Autumn Free People BOGO")
                .startDate(dtf.parseDateTime("9/1/2018"))
                .endDate(dtf.parseDateTime("9/30/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleBOGO()))
                .build();
    }

    public static Campaign demoFreePeopleAutumnBOGOMiddle() {
        return new Campaign().toBuilder()
                .name("Autumn Free People BOGO Middle Weekend")
                .startDate(dtf.parseDateTime("9/15/2018"))
                .endDate(dtf.parseDateTime("9/16/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleBOGO()))
                .build();
    }

    public static Campaign demoCalvinKleinJune2018Dresses10() {
        return new Campaign().toBuilder()
                .name("Calvin Klein June 2018 Special Offer 10% All Dresses")
                .startDate(dtf.parseDateTime("6/1/2018"))
                .endDate(dtf.parseDateTime("6/30/2018"))
                .discounts(Arrays.asList(Promotion.DemoCalvinKleinOFF10()))
                .build();
    }

    public static Campaign demoCalvinKleinJune2018Dresses7() {
        return new Campaign().toBuilder()
                .name("Calvin Klein June 2018 Special Offer 7% All Dresses")
                .startDate(dtf.parseDateTime("6/1/2018"))
                .endDate(dtf.parseDateTime("6/30/2018"))
                .discounts(Arrays.asList(Promotion.DemoCalvinKleinOFF7()))
                .build();
    }

    public static Campaign demoCalvinKleinJune2018Dresses5() {
        return new Campaign().toBuilder()
                .name("Calvin Klein June 2018 Special Offer 5% All Dresses")
                .startDate(dtf.parseDateTime("6/1/2018"))
                .endDate(dtf.parseDateTime("6/30/2018"))
                .discounts(Arrays.asList(Promotion.DemoCalvinKleinOFF5()))
                .build();
    }

    public static Campaign demoFreePeopleJuly2018() {
        return new Campaign().toBuilder()
                .name("Free People 4th July 2018")
                .startDate(dtf.parseDateTime("6/30/2018"))
                .endDate(dtf.parseDateTime("7/4/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleOFF10()))
                .build();
    }

    public static Campaign demoFreePeopleJuly2018BOGO() {
        return new Campaign().toBuilder()
                .name("Free People 4th July 2018 BOGO")
                .startDate(dtf.parseDateTime("7/2/2018"))
                .endDate(dtf.parseDateTime("7/3/2018"))
                .discounts(Arrays.asList(Promotion.DemoFreePeopleBOGO()))
                .build();
    }

    public static Campaign campaignOFFBOGO() {
        return new Campaign().toBuilder()
                .name("at_campaign Campaign with OFF and BOGO promotions")
                .startDate(firstSeptember)
                .endDate(middleSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF(), Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign editCampaignName() {
        return new Campaign().toBuilder()
                .name("at_campaign Edit campaign name")
                .startDate(firstSeptember)
                .endDate(middleSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF(), Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign editedCampaignName() {
        return new Campaign().toBuilder()
                .name("at_campaign Edited campaign name")
                .startDate(firstSeptember)
                .endDate(middleSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF(), Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign editCampaignDates() {
        return new Campaign().toBuilder()
                .name("at_campaign Edit campaign dates")
                .startDate(firstSeptember)
                .endDate(middleSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF(), Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign editedCampaignDates() {
        return new Campaign().toBuilder()
                .name("at_campaign Edit campaign dates")
                .startDate(firstSeptember)
                .endDate(weekSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF(), Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign editCampaignDiscounts() {
        return new Campaign().toBuilder()
                .name("at_campaign Edit campaign discounts")
                .startDate(firstSeptember)
                .endDate(weekSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCK10OFF()))
                .build();
    }

    public static Campaign editedCampaignDiscounts() {
        return new Campaign().toBuilder()
                .name("at_campaign Edit campaign discounts")
                .startDate(firstSeptember)
                .endDate(weekSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCKBOGO()))
                .build();
    }

    public static Campaign removeCampaign() {
        return new Campaign().toBuilder()
                .name("at_campaign Remove campaign")
                .startDate(firstSeptember)
                .endDate(weekSeptember)
                .discounts(Arrays.asList(Promotion.optimizeCKBOGO()))
                .build();
    }
}
