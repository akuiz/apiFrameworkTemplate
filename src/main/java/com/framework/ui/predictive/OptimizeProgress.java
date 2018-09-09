package com.framework.ui.predictive;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OptimizeProgress extends PageObject{

    private static final int optimizeTimeout = 40000;

    private SelenideElement percentage = $(".optimize-forecast__progress-parts__percent");
    private SelenideElement progressBar = $(".optimize-forecast__progress-parts__prog");

    public OptimizeProgress() {
        super($(".optimize-forecast__progress"));
    }

    public OptimizeProgress checkOptimizeProgressHasBeenStarted(){
        percentage.shouldBe(Condition.visible);
        progressBar.shouldBe(Condition.visible);
        return this;
    }

    String regex = "\\d\\d%";

    public void waitForFirstProgress() {
        percentage.waitUntil(Condition.matchesText(regex),10000);
    }

    public Integer getPercentage() {
       return new Integer(percentage.getText().substring(0,percentage.getText().length()-1));
    }

    public void waitForOptimizeFinish() {
        progressBar.waitUntil(not(visible), optimizeTimeout);
    }
}
