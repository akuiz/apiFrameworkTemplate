package com.framework.ui.model.promotion;

import com.framework.ui.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static com.framework.ui.model.Brand.Adidas;
import static com.framework.ui.model.Brand.Calvin_Klein;
import static com.framework.ui.model.promotion.PromotionType.BOGO;
import static com.framework.ui.model.promotion.PromotionType.OFF;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    private String name;
    private Double value;
    private PromotionType type;
    private List<Brand> brands;

    public Promotion(String discountName) {
        this.name = discountName;
    }

    public static Promotion testPromotion(){
        return new Promotion().toBuilder()
                .name("TestUIPromotion")
                .value(0.01)
                .type(BOGO)
                .brands(Arrays.asList(Adidas))
                .build();
    }

    public static Promotion testPromotion1(){
        return new Promotion().toBuilder()
                .name("TestUIPromotion1")
                .value(0.01)
                .type(BOGO)
                .brands(Arrays.asList(Adidas))
                .build();
    }

    public static Promotion optimizeCK10OFF(){
        return new Promotion().toBuilder()
                .name("at_CK 10 OFF")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion optimizeCK20OFF() {
        return new Promotion().toBuilder()
                .name("at_CK 20 OFF")
                .value(0.2)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion optimizeCKBOGO() {
        return new Promotion().toBuilder()
                .name("at_CK BOGO")
                .value(0.2)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }
}
