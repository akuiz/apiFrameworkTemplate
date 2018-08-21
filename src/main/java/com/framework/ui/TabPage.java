package com.framework.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;

public class TabPage extends PageObject{

    protected SelenideElement loader = root.$(".mat-progress-spinner");
    private long downloadTimeout = 5000;

    public TabPage(SelenideElement root) {
        super(root);
        waitForDownload();
    }

    protected void waitForDownload(){
        loader.waitUntil(not(visible), downloadTimeout);
    }

}
