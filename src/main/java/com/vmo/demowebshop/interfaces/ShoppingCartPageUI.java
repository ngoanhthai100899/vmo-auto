package com.vmo.demowebshop.interfaces;

public class ShoppingCartPageUI {
    public static final String TITLE_SHOPPINGCARTPAGE = "//h1[text()='Shopping cart']";
    public static final String ITEM_CHECKBOX = "//a[text()='%s']/preceding::input[@name='removefromcart']";
    public static final String UPDATECART_BTN = "//input[@value='Update shopping cart']";
}
