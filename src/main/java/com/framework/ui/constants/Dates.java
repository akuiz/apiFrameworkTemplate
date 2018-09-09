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
     DateTime seventhOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(7).withTimeAtStartOfDay();
     DateTime middleOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(14).withTimeAtStartOfDay();
     DateTime twentyOneOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(21).withTimeAtStartOfDay();
     DateTime endOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(31).withTimeAtStartOfDay();
     DateTime forthOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(4).withTimeAtStartOfDay();
     DateTime eleventhOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(11).withTimeAtStartOfDay();
     DateTime twelveOctober = new DateTime().withMonthOfYear(10).withYear(2018).withDayOfMonth(12).withTimeAtStartOfDay();

     DateTime firstSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(1).withTimeAtStartOfDay();
     DateTime secondSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(2).withTimeAtStartOfDay();
     DateTime middleSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(14).withTimeAtStartOfDay();
     DateTime weekSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(7).withTimeAtStartOfDay();

    DateTime firstDecember = new DateTime().withMonthOfYear(12).withYear(2018).withDayOfMonth(1).withTimeAtStartOfDay();
    DateTime endDecember = new DateTime().withMonthOfYear(12).withYear(2018).withDayOfMonth(31).withTimeAtStartOfDay();

    DateTime firstAugust = new DateTime().withMonthOfYear(8).withYear(2018).withDayOfMonth(1).withTimeAtStartOfDay();

    DateTime twentySeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(20).withTimeAtStartOfDay();
    DateTime twentyFourSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(24).withTimeAtStartOfDay();
    DateTime twentyThreeSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(23).withTimeAtStartOfDay();
    DateTime endSeptember = new DateTime().withMonthOfYear(9).withYear(2018).withDayOfMonth(30).withTimeAtStartOfDay();

}
