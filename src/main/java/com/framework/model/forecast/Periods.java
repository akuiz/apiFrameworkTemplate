package com.framework.model.forecast;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Periods {
    private List<Pair<String, String>> periods;

    public static Periods test(){
        return new Periods().toBuilder()
                .periods(Arrays.asList(
                        new Pair<>("2018-08-01", "2018-08-31"),
                        new Pair<>("2018-09-01", "2018-09-20")
                ))
                .build();
    }
}
