package com.framework.ui.promotion;

import com.codeborne.selenide.SelenideElement;
import com.framework.ui.PageObject;

import static com.codeborne.selenide.Selenide.$;

public abstract class PromotionWindow<T> extends PageObject {

    protected SelenideElement closeWindowButton = $(".close-dialog");
    protected SelenideElement name = $(".name__input");
    protected SelenideElement brands = $(".rule__input");
    protected SelenideElement type = $(".type__input");
    protected SelenideElement value = $(".value__input");
    protected SelenideElement confirmAction = $(".btn__title");

    public PromotionWindow() {
        super($("app-dialog-add-edit-promo"));
    }

    protected PromotionsPage close(){
        closeWindowButton.click();
        return new PromotionsPage();
    }

    public T setName(String promotionName){
        name.setValue(promotionName);
        return (T)this;
    }

}
