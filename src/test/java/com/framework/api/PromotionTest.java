package com.framework.api;

import com.framework.api.step.PromotionStep;
import com.framework.configuration.TestConfigurationAPI;
import com.framework.api.model.other.Id;
import com.framework.api.model.promotion.Promotion;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Feature("API tests")
@Story("Promotion test")
@ContextConfiguration(classes = TestConfigurationAPI.class)
public class PromotionTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PromotionStep promotionStep;

    @Test
    public void addPromotionTest(){
        Id createdPromotionID = promotionStep.addPromotion(Promotion.testPromotion());
    }
}
