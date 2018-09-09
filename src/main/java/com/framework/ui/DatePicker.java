package com.framework.ui;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.constants.Dates;
import org.joda.time.DateTime;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DatePicker extends PageObject implements Dates {

    private SelenideElement previousMonthButton = root.$(".mat-calendar-previous-button");
    private SelenideElement nextMonthButton = root.$(".mat-calendar-next-button");

    private SelenideElement pickedDate = root.$(".mat-calendar-body-active");
    private DateTime date;

    private DateTime currentDate;

    public DatePicker() {
        super($("mat-datepicker-content"));
        date = datePickerFormatter.parseDateTime(pickedDate.getAttribute("aria-label"));
    }

    public void setDate(DateTime date) {
        this.setYear(date.getYear())
                .setMonth(date.getMonthOfYear())
                .setDay(date.getDayOfMonth());
    }

    public DatePicker setDay(int dayToSet) {
        $(byText(String.valueOf(dayToSet))).click();
        return this;
    }

    private DatePicker setMonth(int monthToSet) {
        int monthDifference = monthToSet - date.getMonthOfYear();
        if (monthDifference == 0) return this;
        if (monthDifference > 0) {
            for (int i = 0; i < monthDifference; i++) {
                nextMonthButton.click();
            }
        } else {
            for (int i = 0; i < monthDifference * (-1); i++) {
                previousMonthButton.click();
            }
        }
        return this;
    }

    private DatePicker setYear(int yearToSet) {
        int yearDifference = yearToSet - date.getYear();
        if (yearDifference == 0) return this;
        if (yearDifference > 0) {
            for (int i = 0; i < yearDifference * 12; i++) {
                nextMonthButton.click();
            }
        } else {
            for (int i = 0; i < yearDifference * (-12); i++) {
                previousMonthButton.click();
            }
        }
        return this;
    }

    public void checkNextMonthButtonDisabled() {
        nextMonthButton.shouldBe(disabled);
    }


    public void checkPreviousMonthButtonDisabled() {
        previousMonthButton.shouldBe(disabled);
    }

    public void cantPickDay(int day) {
        root.$(byText(String.valueOf(day))).parent().shouldHave(attribute("aria-disabled", "true"));
    }
}
