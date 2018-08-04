package com.framework.api.step;

import com.framework.api.client.PromotionsClient;
import com.framework.api.model.other.Id;
import com.framework.api.model.promotion.Promotion;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionStep {

    @Autowired
    PromotionsClient promotionsClient;

    @Step("Add promotion")
    public Id addPromotion(Promotion promotion){
        Id id = promotionsClient.createTemplate(promotion);
        return id;
    }

}
