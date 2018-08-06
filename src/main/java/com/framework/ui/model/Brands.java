package com.framework.ui.model;

public enum Brands {
    Adidas("adidas"),
    Free_People("Free people"),
    Calvin_Klein("Calvin Klein");

    private String displayName;

    Brands(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    @Override public String toString() { return displayName; }

}
