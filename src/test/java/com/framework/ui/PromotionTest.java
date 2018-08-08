package com.framework.ui;

import com.framework.ui.promotion.CreatePromotion;
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
        CreatePromotion s = p.clickAddPromotionButton();
        s.setName("sd");
    }

}
