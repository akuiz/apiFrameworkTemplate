package com.framework.ui.promotion;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.TabPage;
import com.framework.ui.model.promotion.Promotion;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.framework.ui.assertion.PromotionAssert.assertThat;

public class PromotionsPage extends TabPage{

    private SelenideElement addPromotionButton = $(".btn-add-promo");

    private ElementsCollection promotions = $$(".table__row");

    public PromotionsPage() {
        super($("app-promotions-page"));
    }

    public PromotionWindow clickAddPromotionButton(){
        addPromotionButton.click();
        return new PromotionWindow();
    }

    @Step("Add promotion")
    public PromotionPO addPromotion(Promotion promotion) {
        logger.info("Add promotion " + promotion.getName());
        PromotionWindow addPromotionWindow = clickAddPromotionButton();
        addPromotionWindow.setValues(promotion).confirm();
        return new PromotionPO(promotion.getName());
    }

    public PromotionPO findPromotionByName(String name) {
        return new PromotionPO(name);
    }

    @Step("Check promotion exists")
    public void checkPromotionExists(Promotion promotion) {
        logger.info("Check promotion exists " + promotion.getName());
        PromotionPO promotionPO = new PromotionPO($(byText(promotion.getName())).parent());
        assertThat(promotionPO.getPromotionModel()).isSamePromotionAs(promotion);
    }

    @Step("Add promotion without required parameter")
    public void addBadPromotion(Promotion promotion) {
        logger.info("Add promotion " + promotion.getName());
        PromotionWindow addPromotionWindow = clickAddPromotionButton();
        addPromotionWindow.setValues(promotion).confirm();
        addPromotionWindow.confirmButtonShouldBeDisabled();
    }
    @Step("Check promotion doesn't exist")
    public void checkPromotionNotExists(Promotion promotion) {
        logger.info("Check promotion not exists" + promotion.getName());
        $(byText(promotion.getName())).shouldNot(exist);
    }

    public void checkNumberOfPromotions(int i) {
        promotions.shouldHaveSize(i);
    }

    public void checkPromotionExistsTwice(Promotion promotion) {
        logger.info("Check promotion exists twice" + promotion.getName());
        $$(byText(promotion.getName())).shouldHaveSize(2);
        PromotionPO promotionPO = new PromotionPO($$(byText(promotion.getName())).first().parent());
        assertThat(promotionPO.getPromotionModel()).isSamePromotionAs(promotion);
         promotionPO = new PromotionPO($$(byText(promotion.getName())).last().parent());
        assertThat(promotionPO.getPromotionModel()).isSamePromotionAs(promotion);
    }
}
