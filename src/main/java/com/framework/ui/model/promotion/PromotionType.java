package com.framework.ui.model.promotion;

public enum PromotionType {

    BOGO("Buy One Get One"),
    OFF("% OFF");

    private String displayName;

    PromotionType(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    @Override public String toString() { return displayName; }

}
