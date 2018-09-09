package com.framework.ui;

import com.framework.ui.assertion.CampaignAssert;
import com.framework.ui.campaign.CampaignPO;
import com.framework.ui.campaign.CampaignsPage;
import com.framework.ui.model.campaign.Campaign;
import com.framework.ui.model.prediction.ForecastModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.framework.ui.assertion.ForecastModelAssert.assertThat;

@Feature("UI tests")
@Story("Campaign test")
public class CampaignTest extends AbstractTest{

    @Test(description = "Add campaign test", groups = {"campaign"})
    public void addCampaignTest(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.addCampaign(Campaign.campaignOFFBOGO());
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.campaignOFFBOGO().getName());
        CampaignAssert.assertThat(campaign.getModel()).isSameCampaignIgnoringPromotionDetails(Campaign.campaignOFFBOGO());
    }

    @Test(description = "Edit campaign name test", groups = {"campaign"})
    public void editCampaignName(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.addCampaign(Campaign.editCampaignName());
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.editCampaignName().getName());
        campaign = campaign.editName(Campaign.editedCampaignName().getName());
        CampaignAssert.assertThat(campaign.getModel()).isSameCampaignIgnoringPromotionDetails(Campaign.editedCampaignName());
    }

    @Test(description = "Edit campaign name test", groups = {"campaign"})
    public void editCampaignDates(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.addCampaign(Campaign.editCampaignDates());
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.editCampaignDates().getName());
        campaign = campaign.editDates(Campaign.editedCampaignDates().getStartDate(),Campaign.editedCampaignDates().getEndDate());
        CampaignAssert.assertThat(campaign.getModel()).isSameCampaignIgnoringPromotionDetails(Campaign.editedCampaignDates());
    }

    @Test(description = "Edit campaign discounts test", groups = {"campaign"})
    public void editCampaignDiscounts(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.addCampaign(Campaign.editCampaignDiscounts());
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.editCampaignDiscounts().getName());
        campaign = campaign.editDiscounts(Campaign.editedCampaignDiscounts().getDiscounts());
        CampaignAssert.assertThat(campaign.getModel()).isSameCampaignIgnoringPromotionDetails(Campaign.editedCampaignDiscounts());
    }

    @Test(description = "Remove campaign  test", groups = {"campaign"})
    public void removeCampaignTest(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.addCampaign(Campaign.removeCampaign());
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.removeCampaign().getName());
        campaign.remove();
        campaignsPage.checkCampaignNotExists(Campaign.removeCampaign());
    }

    @Test(description = "Prediction campaign test", groups = {"campaign"})
    public void predictionCampaignTest(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.profitableCampaignWith20CKOFF().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.profitableCampaignWith20CKOFF());
    }

    @Test(description = "[DEMO]Check pre-created campaigns", groups = {"production_read_only", "demo"}, priority = 1)
    public void precreatedCampaignsTest(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        campaignsPage.checkNumberOfCampaigns(15);
        campaignsPage.checkCampaignExists(Campaign.demoAdriannaPapellSpring2018());
        campaignsPage.checkCampaignExists(Campaign.demoAdriannaPapellSpringExtended2018());
        campaignsPage.checkCampaignExists(Campaign.demoCalvinKleinAutumn10());
        campaignsPage.checkCampaignExists(Campaign.demoCalvinKleinAutumn5());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleAutumn10());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleAutumn10FirstWeeks());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleAutumn10LastWeeks());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleAutumn20());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleAutumnBOGO());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleAutumnBOGOMiddle());
        campaignsPage.checkCampaignExists(Campaign.demoCalvinKleinJune2018Dresses10());
        campaignsPage.checkCampaignExists(Campaign.demoCalvinKleinJune2018Dresses5());
        campaignsPage.checkCampaignExists(Campaign.demoCalvinKleinJune2018Dresses7());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleJuly2018());
        campaignsPage.checkCampaignExists(Campaign.demoFreePeopleJuly2018BOGO());
    }

    @Test(description = "Check campaign prediction Adrianna Papell Spring 2018", groups = {"production_read_only"})
    public void demoCampaignPredictionAdriannaPapell(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoAdriannaPapellSpring2018().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoAdriannaPapellSpring2018());
    }

    @Test(description = "Check campaign prediction Adrianna Papell Spring 2018 extended", groups = {"production_read_only"})
    public void demoCampaignPredictionAdriannaPapellExtended(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoAdriannaPapellSpringExtended2018().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoAdriannaPapellSpringExtended2018());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn 10", groups = {"production_read_only"})
    public void demoCampaignPredictionCalvinKleinAutumn10(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoCalvinKleinAutumn10().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoCalvinKleinAutumn10());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn 5", groups = {"production_read_only"})
    public void demoCampaignPredictionCalvinKleinAutumn5(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoCalvinKleinAutumn5().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoCalvinKleinAutumn5());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn 5", groups = {"production_read_only"})
    public void demoFreePeopleAutumn10Prediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleAutumn10().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleAutumn10());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn 10 First Weeks", groups = {"production_read_only"})
    public void demoFreePeopleAutumn10FirstWeeksPrediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleAutumn10FirstWeeks().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleAutumn10FirstWeeks());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn 10 Last Weeks", groups = {"production_read_only"})
    public void demoFreePeopleAutumn10LastWeeksPrediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleAutumn10LastWeeks().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleAutumn10LastWeeks());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn 20", groups = {"production_read_only"})
    public void demoFreePeopleAutumn20Prediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleAutumn20().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleAutumn20());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn BOGO", groups = {"production_read_only"})
    public void demoFreePeopleAutumnBOGOPrediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleAutumnBOGO().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleAutumnBOGO());
    }

    @Test(description = "Check campaign prediction Calvin Klein Autumn BOGO Middle", groups = {"production_read_only"})
    public void demoFreePeopleAutumnBOGOMiddlePrediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleAutumnBOGOMiddle().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleAutumnBOGOMiddle());
    }

    @Test(description = "Check campaign prediction Calvin Klein 10 Dresses", groups = {"production_read_only"})
    public void demoCalvinKleinJune2018Dresses10Prediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoCalvinKleinJune2018Dresses10().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoCalvinKleinJune2018Dresses10());
    }

    @Test(description = "Check campaign prediction Calvin Klein 5 Dresses", groups = {"production_read_only"})
    public void demoCalvinKleinJune2018Dresses5Prediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoCalvinKleinJune2018Dresses5().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoCalvinKleinJune2018Dresses5());
    }

    @Test(description = "Check campaign prediction Calvin Klein 7 Dresses", groups = {"production_read_only"})
    public void demoCalvinKleinJune2018Dresses7Prediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoCalvinKleinJune2018Dresses7().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoCalvinKleinJune2018Dresses7());
    }

    @Test(description = "Check campaign prediction Free People 4th July 2018", groups = {"production_read_only"})
    public void demoFreePeopleJuly2018Prediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleJuly2018().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleJuly2018());
    }

    @Test(description = "Check campaign prediction Free People 4th July 2018 BOGO", groups = {"production_read_only"})
    public void demoFreePeopleJuly2018BOGOPrediction(){
        CampaignsPage campaignsPage = new Navigation().navigateToCampaignsPage();
        CampaignPO campaign = campaignsPage.getCampaignByName(Campaign.demoFreePeopleJuly2018BOGO().getName());
        ForecastModel predictionResult = campaign.getPrediction();
        assertThat(predictionResult).isSameForecastAs(ForecastModel.demoFreePeopleJuly2018BOGO());
    }





}
