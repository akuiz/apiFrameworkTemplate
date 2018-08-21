package com.framework.ui.model.prediction;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Prediction {

    private Pair<String, String> revenue;
    private Pair<String, String> profit;
    private Pair<String, String> quantity;

    public static Prediction testPrediction() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("",""))
                .profit(new Pair<>("",""))
                .quantity(new Pair<>("",""))
                .build();
    }

    public static Prediction fullOctoberPredictions() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$184,058.61","$15,162,511.65"))
                .profit(new Pair<>("$79,347.81","$1,659,225.12"))
                .quantity(new Pair<>("1076","99370"))
                .build();
    }

    public static Prediction firstHalfOctoberPredictions() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$86,415.59","$123,790.76"))
                .profit(new Pair<>("$38,069.98","$41,889.08"))
                .quantity(new Pair<>("490","753"))
                .build();
    }

    public static Prediction oneProfitableWeekPrediction() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$49,177.24","$84,652.44"))
                .profit(new Pair<>("$21,205.7","$26,955.54"))
                .quantity(new Pair<>("283","515"))
                .build();
    }

    public static Prediction lastWeeksOctoberPrediction() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$104,222.48","$15,045,136.64"))
                .profit(new Pair<>("$44,550.03","$1,620,718.2"))
                .quantity(new Pair<>("617","98646"))
                .build();
    }

    public static Prediction zeroPredtiction() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$0","$0"))
                .profit(new Pair<>("$0","$0"))
                .quantity(new Pair<>("0","0"))
                .build();
    }
}
