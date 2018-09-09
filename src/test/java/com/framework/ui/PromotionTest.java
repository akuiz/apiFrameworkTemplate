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

    @Test(description = "Add promotion % off test", groups = {"promotion"})
    public void addPromotionOFFTest(){
        PromotionsPage promotionsPage = new PromotionsPage();
        promotionsPage.addPromotion(Promotion.promotionOFFTest());
        promotionsPage.checkPromotionExists(Promotion.promotionOFFTest());
    }

    @Test(description = "Add promotion bogo  test", groups = {"promotion"})
    public void addPromotionBOGOTest(){
        PromotionsPage promotionsPage = new PromotionsPage();
        promotionsPage.addPromotion(Promotion.promotionBOGOTest());
        promotionsPage.checkPromotionExists(Promotion.promotionBOGOTest());
    }

    @Test(description = "Add promotion with no brands", groups = {"promotion"})
    public void addPromotionWithNoBrands() {
        PromotionsPage promotionsPage = new PromotionsPage();
        promotionsPage.addBadPromotion(Promotion.promotionWithNoBrands());
    }

    @Test(description = "Add promotion with empty name", groups = {"promotion"})
    public void addPromotionWithEmptyName() {
        PromotionsPage promotionsPage = new PromotionsPage();
        promotionsPage.addBadPromotion(Promotion.promotionWithEmptyName());
    }

    @Test(description = "Add promotion with multiple brands", groups = {"promotion"})
    public void addPromotionWithMultipleBrands() {
        PromotionsPage promotionsPage = new PromotionsPage();
        promotionsPage.addPromotion(Promotion.promotionWithTwoBrands());
        promotionsPage.checkPromotionExists(Promotion.promotionWithTwoBrands());
    }

    @Test(description = "Delete recently created promotion test", groups = {"promotion"})
    public void deletePromotionTest() {
        PromotionsPage promotionsPage = new PromotionsPage();
        PromotionPO promotionPO = promotionsPage.addPromotion(Promotion.deletedPromotion());
        promotionPO.delete();
        promotionsPage.checkPromotionNotExists(Promotion.deletedPromotion());
    }

    @Test(description = "Duplicate promotion test", groups = {"promotion"})
    public void duplicatePromotionTest() {
        PromotionsPage promotionsPage = new PromotionsPage();
        PromotionPO promotionPO = promotionsPage.addPromotion(Promotion.duplicatePromotion());
        promotionPO.duplicate();
        promotionsPage.checkPromotionExistsTwice(Promotion.duplicatePromotion());
    }

    @Test(description = "Edit promotion name test", groups = {"promotion"})
    public void editPromotionNameTest() {
        PromotionsPage promotionsPage = new PromotionsPage();
        PromotionPO promotionPO = promotionsPage.addPromotion(Promotion.editPromotion());
        promotionPO.editPromotionName(Promotion.editPromotionName().getName());
        promotionsPage.checkPromotionExists(Promotion.editPromotionName());
    }

    @Test(description = "Edit promotion value test", groups = {"promotion"})
    public void editPromotionValue() {
        PromotionsPage promotionsPage = new PromotionsPage();
        PromotionPO promotionPO = promotionsPage.addPromotion(Promotion.editPromotionValue());
        promotionPO.editPromotionValue(Promotion.editedPromotionValue().getValue());
        promotionsPage.checkPromotionExists(Promotion.editedPromotionValue());
    }

    @Test(description = "Edit promotion brands test", groups = {"promotion"})
    public void editPromotionBrands() {
        PromotionsPage promotionsPage = new PromotionsPage();
        PromotionPO promotionPO = promotionsPage.addPromotion(Promotion.editPromotionBrands());
        promotionsPage = promotionPO.editPromotionBrands(Promotion.editedPromotionBrands().getBrands());
        promotionsPage.checkPromotionExists(Promotion.editedPromotionBrands());
    }

    @Test(description = "Check pre-created promotions", groups = {"production_read_only", "demo"})
    public void preCreatedPromotionsTest(){
        PromotionsPage promotionsPage = new PromotionsPage();
        promotionsPage.checkNumberOfPromotions(7);
        promotionsPage.checkPromotionExists(Promotion.DemoCalvinKleinOFF5());
        promotionsPage.checkPromotionExists(Promotion.DemoCalvinKleinOFF7());
        promotionsPage.checkPromotionExists(Promotion.DemoCalvinKleinOFF10());
        promotionsPage.checkPromotionExists(Promotion.DemoAdriannaPapellOFF5());
        promotionsPage.checkPromotionExists(Promotion.DemoFreePeopleOFF10());
        promotionsPage.checkPromotionExists(Promotion.DemoFreePeopleBOGO());
        promotionsPage.checkPromotionExists(Promotion.DemoFreePeopleOFF20());
    }
}
