package com.framework.ui.campaign;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;
import com.framework.ui.RemoveWindow;
import com.framework.ui.constants.Dates;
import com.framework.ui.model.campaign.Campaign;
import com.framework.ui.model.campaign.CampaignPrediction;
import com.framework.ui.model.prediction.ForecastModel;
import com.framework.ui.model.prediction.Prediction;
import com.framework.ui.model.promotion.Promotion;
import io.qameta.allure.Step;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CampaignPO extends PageObject implements Dates {

    private SelenideElement deleteButton = root.$$(".mat-icon-button").last();
    private SelenideElement editButton = root.$$(".mat-icon-button").first();
    private SelenideElement name = root.$(".name-column__title");
    private SelenideElement predictionButton = root.$(".show-prediction-btn");

    private ElementsCollection promotions = root.$$(".name-column__promos__element");

    private SelenideElement startDateField = root.$(".start-column").$(".cell-date");
    private SelenideElement endDateField = root.$(".end-column").$(".cell-date");

    public CampaignPO(SelenideElement root) {
        super(root);
    }

    public CampaignPO(String name) {
        super($(byText(name)).parent().parent());
    }

    public CampaignsPage delete() {
        deleteButton.click();
        new RemoveWindow().confirmRemove();
        return new CampaignsPage();
    }

    public CampaignsPage edit(Campaign campaign) {
        editButton.click();
        return new CampaignWindow().setValues(campaign).confirm();
    }

    @Step("Get campaign prediction")
    public ForecastModel getPrediction() {
        logger.info("Get campaign prediction");
        expand();
        predictionButton.click();
        CampaignPrediction predictionWindow = new CampaignPrediction();
        Prediction predictionValues = predictionWindow.getPrediction();
        predictionWindow.close();
        return new ForecastModel().toBuilder().startDate(getStartDate()).endDate(getEndDate()).predictionValues(predictionValues).campaigns(Arrays.asList(getCampaign())).build();
    }

    public CampaignPO expand(){
        name.click();
        return this;
    }

    public DateTime getStartDate() {
        return dtf.parseDateTime(startDateField.getText());
    }

    public DateTime getEndDate() {
        return dtf.parseDateTime(endDateField.getText());
    }

    private Campaign getCampaign(){
        ArrayList<Promotion> campaignPromotions = new ArrayList<>();
        for (int i = 0; i <this.promotions.size(); i++) {
            campaignPromotions.add(new Promotion(promotions.get(i).getText()));
        }
        return new Campaign(name.getText(), campaignPromotions);
    }

    public Campaign getModel() {
        expand();
        return new Campaign().toBuilder()
                .name(getName())
                .endDate(dtf.parseDateTime(endDateField.getText()))
                .startDate(dtf.parseDateTime(startDateField.getText()))
                .discounts(getDiscounts())
                .build();
    }

    private String getName(){
        return name.getText();
    }

    private ArrayList<Promotion> getDiscounts(){
        ArrayList<Promotion> discounts  = new ArrayList<>();
        for(SelenideElement promotionName : promotions){
            discounts.add(new Promotion(promotionName.getText()));
        }
        return discounts;
    }

    @Step("Edit campaign's name")
    public CampaignPO editName(String name) {
        logger.info("Edit campaign's name");
        editButton.click();
        new CampaignWindow().setName(name).confirm();
        return new CampaignPO(name);
    }

    @Step("Edit campaign's dates")
    public CampaignPO editDates(DateTime startDate, DateTime endDate) {
        logger.info("Edit campaign's dates");
        editButton.click();
        new CampaignWindow().setStartDate(startDate).setEndDate(endDate).confirm();
        return this;
    }

    @Step("Edit campaign's discounts")
    public CampaignPO editDiscounts(List<Promotion> discounts) {
        logger.info("Edit campaign's discounts");
        editButton.click();
        new CampaignWindow().setDiscounts(discounts).confirm();
        return this;
    }

    @Step("Remove campaign")
    public void remove() {
        logger.info("Remove campaign");
        deleteButton.click();
        new RemoveWindow().confirmRemove();
    }
}
