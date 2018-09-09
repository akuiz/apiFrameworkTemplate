package com.framework.ui.model.promotion;

public enum Brand {
    Adidas("adidas"),
    Free_People("Free People"),
    Calvin_Klein("Calvin Klein"),
    Adrianna_Papell("Adrianna Papell"), six("6");

    private String displayName;

     Brand(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    @Override public String toString() { return displayName; }

    public static Brand fromString(String text) {
        for (Brand b : Brand.values()) {
            if (b.displayName.equals(text)) {
                return b;
            }
        }
        return null;
    }

}
