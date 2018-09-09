package com.framework.ui;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;

public abstract class PageObject {

    protected SelenideElement root;

    public PageObject(SelenideElement root) {
        this.root = root;
    }

    protected SelenideElement background = $(".cdk-overlay-container");

    protected Logger logger = Logger.getLogger("new logger");


}
