package com.framework.api.step;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.api.client.PromotionsClient;
import com.framework.api.model.other.Id;
import com.framework.api.model.promotion.Promotion;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionStep {

    @Autowired
    PromotionsClient promotionsClient;

    @Step("Add promotion")
    public Id addPromotion(Promotion promotion){
        Id id = promotionsClient.createTemplate(promotion);
        return id;
    }

    @Step("Delete promotion")
    public void deletePromotion(Promotion promotion){
        promotionsClient.deleteTemplate(promotion.getId());
    }

    public List<Promotion> getPromotions() {
        ObjectMapper mapper = new ObjectMapper();
        List<Promotion> promotions = promotionsClient.getPromotions(100);
        return promotions;
    }
}
