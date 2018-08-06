package com.framework.ui.promotion;

import com.framework.ui.TabPage;

import static com.codeborne.selenide.Selenide.$;

public class PromotionsPage extends TabPage{

    public PromotionsPage() {
        super($("app-promotions-page"));
    }


}
