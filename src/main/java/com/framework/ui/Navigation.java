package com.framework.ui;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.campaign.CampaignsPage;
import com.framework.ui.predictive.CampaignsComponent;
import com.framework.ui.promotion.PromotionsPage;
import com.framework.ui.suggestions.SuggestionsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Navigation extends PageObject{

    public Navigation() {
        super($(".navigation"));
    }

    private SelenideElement promotionsLink = root.$$(".navigation__tab").first();
    private SelenideElement campaignsLink = root.$$(".navigation__tab").get(1);
    private SelenideElement forecastLink = root.$$(".navigation__tab").get(2);
    private SelenideElement optimizeLink = root.$$(".navigation__tab").get(3);
    private SelenideElement suggestionsLink = root.$$(".navigation__tab").last();

    @Step("Navigate to promotions page")
    public PromotionsPage navigateToPromotionsPage(){
        logger.info("Navigate to promotions page");
        promotionsLink.click();
        return new PromotionsPage();
    }

    @Step("Navigate to campaigns page")
    public CampaignsPage navigateToCampaignsPage(){
        logger.info("Navigate to campaigns page");
        campaignsLink.click();
        return new CampaignsPage();
    }

    @Step("Navigate to optimize page")
    public CampaignsComponent navigateToOptimizePage() {
        logger.info("Navigate to optimize page");
        optimizeLink.click();
        return new CampaignsComponent();
    }

    @Step("Navigate to forecast page")
    public CampaignsComponent navigateToForecastPage() {
        logger.info("Navigate to forecast page");
        forecastLink.scrollIntoView(false).click();
        return new CampaignsComponent();
    }

    @Step("Navigate to suggestions page")
    public SuggestionsPage navigateToSuggestionsPage() {
        logger.info("Navigate to suggestions page");
        suggestionsLink.click();
        return new SuggestionsPage();
    }
}
