package com.framework.ui.predictive;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OptimizeProgress extends PageObject{

    private SelenideElement percentage = $(".optimize-forecast__progress-parts__percent");
    private SelenideElement progressBar = $(".optimize-forecast__progress-parts__prog");

    public OptimizeProgress() {
        super($(".optimize-forecast__progress"));
    }

    public void checkOptimizeProgressHasBeenStarted(){
        percentage.shouldBe(visible);
        progressBar.shouldBe(visible);
    }
}
