package com.framework.ui.constants;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public interface Dates {

    DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy").withLocale(Locale.ENGLISH);
    DateTimeFormatter datePickerFormatter = DateTimeFormat.forPattern("MMM d, yyyy").withLocale(Locale.ENGLISH);

     DateTime currentDate = DateTime.now();
     DateTime currentDatePlusMonth = DateTime.now().plusMonths(1);

     DateTime firstOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(1).withTimeAtStartOfDay();
     DateTime middleOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(14).withTimeAtStartOfDay();
     DateTime endOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(31).withTimeAtStartOfDay();
     DateTime forthOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(4).withTimeAtStartOfDay();
     DateTime eleventhOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(11).withTimeAtStartOfDay();

}
