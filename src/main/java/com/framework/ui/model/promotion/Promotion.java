package com.framework.ui.model.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static com.framework.ui.model.promotion.Brand.*;
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

    public static Promotion promotionOFFTest() {
        return new Promotion().toBuilder()
                .name("at_% OFF promotion")
                .value(0.02)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion promotionWithNoBrands() {
        return new Promotion().toBuilder()
                .name("at_Promotion with no brands")
                .value(0.2)
                .type(OFF)
                .build();
    }

    public static Promotion promotionWithEmptyName() {
        return new Promotion().toBuilder()
                .name("")
                .value(0.2)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion promotionBOGOTest() {
        return new Promotion().toBuilder()
                .name("at_BOGO promotion")
                .value(0.01)
                .type(BOGO)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion promotionWithTwoBrands() {
        return new Promotion().toBuilder()
                .name("at_% OFF promotion with 2 brands")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Adidas,Calvin_Klein))
                .build();
    }

    public static Promotion deletedPromotion() {
        return new Promotion().toBuilder()
                .name("at_Promotion to be deleted")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion duplicatePromotion() {
        return new Promotion().toBuilder()
                .name("at_Promotion duplicate")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion editPromotion() {
        return new Promotion().toBuilder()
                .name("at_Edit promotion")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion editedPromotionValue() {
        return new Promotion().toBuilder()
                .name("at_Edit promotion value")
                .value(0.2)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion editPromotionValue() {
        return new Promotion().toBuilder()
                .name("at_Edit promotion value")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion editPromotionName() {
        return new Promotion().toBuilder()
                .name("at_Edited name promotion")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }



    public static Promotion editPromotionBrands() {
        return new Promotion().toBuilder()
                .name("at_Edit promotion brands")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Adidas))
                .build();
    }

    public static Promotion editedPromotionBrands() {
        return new Promotion().toBuilder()
                .name("at_Edit promotion brands")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion DemoCalvinKleinOFF5() {
        return new Promotion().toBuilder()
                .name("Calvin Klein Special Offer 5%")
                .value(0.05)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion DemoCalvinKleinOFF7() {
        return new Promotion().toBuilder()
                .name("Calvin Klein Special Offer 7%")
                .value(0.07)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion DemoCalvinKleinOFF10() {
        return new Promotion().toBuilder()
                .name("Calvin Klein Special Offer 10%")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Calvin_Klein))
                .build();
    }

    public static Promotion DemoAdriannaPapellOFF5() {
        return new Promotion().toBuilder()
                .name("Adrianna Papell 5% OFF")
                .value(0.05)
                .type(OFF)
                .brands(Arrays.asList(Adrianna_Papell))
                .build();
    }

    public static Promotion DemoFreePeopleOFF10() {
        return new Promotion().toBuilder()
                .name("Free People 10% OFF")
                .value(0.1)
                .type(OFF)
                .brands(Arrays.asList(Free_People))
                .build();
    }

    public static Promotion DemoFreePeopleBOGO() {
        return new Promotion().toBuilder()
                .name("Free People BOGO")
                .value(0.01)
                .type(BOGO)
                .brands(Arrays.asList(Free_People))
                .build();
    }

    public static Promotion DemoFreePeopleOFF20() {
        return new Promotion().toBuilder()
                .name("Free People 20% OFF")
                .value(0.2)
                .type(OFF)
                .brands(Arrays.asList(Free_People))
                .build();
    }
}
