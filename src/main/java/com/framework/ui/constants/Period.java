package com.framework.ui.constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Period implements Dates{

    private DateTime startDate;
    private DateTime endDate;

    public static Period firstOctoberWeek() {
        return new Period().toBuilder()
                .startDate(firstOctober)
                .endDate(seventhOctober)
                .build();
    }

    public static Period december() {
        return new Period().toBuilder()
                .startDate(firstDecember)
                .endDate(endDecember)
                .build();
    }


}
