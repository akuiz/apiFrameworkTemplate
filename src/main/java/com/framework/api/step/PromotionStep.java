package com.framework.api.step;

import com.framework.api.client.PromotionsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionStep {

    @Autowired
    PromotionsClient promotionsClient;

}
