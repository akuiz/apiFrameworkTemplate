package com.framework.ui.campaign;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.DatePicker;
import com.framework.ui.PageObject;
import com.framework.ui.constants.Dates;
import com.framework.ui.model.campaign.Campaign;
import com.framework.ui.model.promotion.Promotion;
import com.framework.ui.selector.CheckBoxSelector;
import org.joda.time.DateTime;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CampaignWindow extends PageObject implements Dates {

    protected SelenideElement closeWindowButton = root.$(".close-dialog");
    protected SelenideElement name = root.$(".name__input");
    protected SelenideElement confirmAction = root.$(".btn__title");
    protected SelenideElement startDateInput = root.$(".start-date__input");
    protected SelenideElement endDateInput = root.$(".end-date__input");
    protected SelenideElement discountsSelector = root.$(".promotions");

    private DateTime startDate = dtf.parseDateTime(startDateInput.getValue());
    private DateTime endDate = dtf.parseDateTime(startDateInput.getValue());

    public CampaignWindow() {
        super($("app-dialog-add-edit-campaign"));
    }

    public CampaignWindow setName(String name){
        this.name.setValue(name);
        return this;
    }

    public CampaignWindow setValues(Campaign campaign) {
        if(campaign.getStartDate().isBefore(startDate)){
            setStartDate(campaign.getStartDate())
                    .setEndDate(campaign.getEndDate());
        }
        else{
            setEndDate(campaign.getEndDate())
                    .setStartDate(campaign.getStartDate());
        }
        setName(campaign.getName())
                .setDiscounts(campaign.getDiscounts());
        return this;
    }

    protected CampaignWindow setStartDate(DateTime startDate) {
        clickStartDateInput().setDate(startDate);
        return this;
    }

    protected CampaignWindow setEndDate(DateTime endDate) {
        clickEndDateInput().setDate(endDate);
        return this;
    }

    private DatePicker clickStartDateInput(){
        startDateInput.click();
        return new DatePicker();
    }

    private DatePicker clickEndDateInput(){
        endDateInput.click();
        return new DatePicker();
    }

    public CampaignWindow setDiscounts(List<Promotion> discounts) {
        discountsSelector.click();
        new CheckBoxSelector().setDiscounts(discounts);
        background.click();
        return this;
    }

    public CampaignsPage confirm() {
        confirmAction.click();
        return new CampaignsPage();
    }
}
