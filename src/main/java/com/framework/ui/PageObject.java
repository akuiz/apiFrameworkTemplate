package com.framework.ui;

import com.codeborne.selenide.SelenideElement;

public abstract class PageObject {

    protected SelenideElement root;

    public PageObject(SelenideElement root) {
        this.root = root;
    }
}
