package com.framework.ui;

import com.framework.ui.model.promotion.Promotion;
import com.framework.ui.promotion.PromotionPO;
import com.framework.ui.promotion.PromotionsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("UI tests")
@Story("Promotion test")
public class PromotionTest extends AbstractTest{

    @Test(description = "Basic test", groups = {"ui"})
    public void basicPromotionTest(){
        PromotionsPage p = new PromotionsPage();
        PromotionPO promotion = p.addPromotion(Promotion.testPromotion());
        promotion = p.findPromotionByName(Promotion.testPromotion().getName());
        promotion.edit(Promotion.testPromotion1());
        promotion.duplicate();
    }

}
