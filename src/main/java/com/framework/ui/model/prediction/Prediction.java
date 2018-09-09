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

    public static Prediction firstHalfOctoberForecast() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$86,415.59","$123,790.76"))
                .profit(new Pair<>("$38,069.98","$41,889.08"))
                .quantity(new Pair<>("490","753"))
                .build();
    }

    public static Prediction firstThreeWeeksOctoberForecast() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$129,085.11","$8,095,117.43"))
                .profit(new Pair<>("$56,972.27","$903,436.72"))
                .quantity(new Pair<>("734","51798"))
                .build();
    }

    public static Prediction firstWeekOctoberForecast() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$42,630.69","$56,292.52"))
                .profit(new Pair<>("$18,910.1","$19,157.11"))
                .quantity(new Pair<>("245","351"))
                .build();
    }

    public static Prediction profitableCK20OFFPredictionValues() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$59,518.46","$97,357.84"))
                .profit(new Pair<>("$27,330.21","$31,613.52"))
                .quantity(new Pair<>("325","588"))
                .build();
    }

    public static Prediction demoAdriannaPapellSpring2018() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$493,843.1","$673,988.79"))
                .profit(new Pair<>("$201,607.05","$251,956.66"))
                .quantity(new Pair<>("2496","3624"))
                .build();
    }

    public static Prediction demoAdriannaPapellSpringExtended2018() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$710,125.67","$966,991.88"))
                .profit(new Pair<>("$293,543.86","$361,958.42"))
                .quantity(new Pair<>("3556","5196"))
                .build();
    }

    public static Prediction demoCalvinKleinAutumn10() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$184,058.61","$347,388.91"))
                .profit(new Pair<>("$79,347.81","$116,447.29"))
                .quantity(new Pair<>("1076","2082"))
                .build();
    }

    public static Prediction demoCalvinKleinAutumn5() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$184,058.61","$308,786.97"))
                .profit(new Pair<>("$79,347.81","$117,018.37"))
                .quantity(new Pair<>("1076","1726"))
                .build();
    }

    public static Prediction demoFreePeopleAutumn10() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$18,624.13","$72,383.16"))
                .profit(new Pair<>("$6,657.21","$30,967.04"))
                .quantity(new Pair<>("93","328"))
                .build();
    }

    public static Prediction demoFreePeopleAutumn10FirstWeeks() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$9,471.67","$34,022.03"))
                .profit(new Pair<>("$3,414.43","$14,703.51"))
                .quantity(new Pair<>("47","153"))
                .build();
    }

    public static Prediction demoFreePeopleAutumn10LastWeeks() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$7,857.12","$35,153.57"))
                .profit(new Pair<>("$2,724.96","$15,091.89"))
                .quantity(new Pair<>("40","159"))
                .build();
    }

    public static Prediction demoFreePeopleAutumn20() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$18,819.09","$72,316.34"))
                .profit(new Pair<>("$6,463.41","$30,646.06"))
                .quantity(new Pair<>("96","330"))
                .build();
    }

    public static Prediction demoFreePeopleAutumnBOGO() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$18,624.13","$3,285,648.13"))
                .profit(new Pair<>("$6,657.21","$320,797.03"))
                .quantity(new Pair<>("93","22739"))
                .build();
    }

    public static Prediction demoFreePeopleAutumnBOGOMiddle() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$1,295.34","$123,529.64"))
                .profit(new Pair<>("$517.82","$12,000.7"))
                .quantity(new Pair<>("6","857"))
                .build();
    }

    public static Prediction demoCalvinKleinJune2018Dresses10() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$167,694.59","$331,384.13"))
                .profit(new Pair<>("$76,582.15","$112,320.9"))
                .quantity(new Pair<>("942","1980"))
                .build();
    }

    public static Prediction demoCalvinKleinJune2018Dresses5() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$167,694.59","$293,966.63"))
                .profit(new Pair<>("$76,582.15","$112,655.74"))
                .quantity(new Pair<>("942","1631"))
                .build();
    }

    public static Prediction demoCalvinKleinJune2018Dresses7() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$167,694.59","$329,833.04"))
                .profit(new Pair<>("$76,582.15","$112,991.41"))
                .quantity(new Pair<>("942","1964"))
                .build();
    }

    public static Prediction demoFreePeopleJuly2018() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$2,833.45","$9,234.18"))
                .profit(new Pair<>("$909.41","$3,650.66"))
                .quantity(new Pair<>("15","44"))
                .build();
    }

    public static Prediction demoFreePeopleJuly2018BOGO() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$1,206.7","$291,407.38"))
                .profit(new Pair<>("$308.96","$40,575.24"))
                .quantity(new Pair<>("7","1924"))
                .build();
    }

    public static Prediction profitableCampaignWith20CKOFF() {
        return new Prediction().toBuilder()
                .revenue(new Pair<>("$59,518.46","$97,357.84"))
                .profit(new Pair<>("$27,330.21","$31,613.52"))
                .quantity(new Pair<>("325","588"))
                .build();
    }
}
