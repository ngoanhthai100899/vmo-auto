package com.vmo.demowebshop.interfaces;

public class HomePageUI {
    public static final String TITLE_HOMEPAGE = "//h2[@class='topic-html-content-header']";
    public static final String BOOKS_TAG = "//div[@class='ajax-loading-block-window']/preceding-sibling::div[@class='header-menu']/child::ul[@class='top-menu']/descendant::a[contains(text(),'Books')]";
    public static final String DIGITAL_DOWNLOADS_TAG = "//div[@class='ajax-loading-block-window']/preceding-sibling::div[@class='header-menu']/child::ul[@class='top-menu']/descendant::a[contains(text(),'Digital downloads')]";
    public static final String LOGIN_BTN = "//a[@class='ico-login']";
    public static final String ADDTOCART_ITEM = "//div[@class='product-grid home-page-product-grid']/descendant::a[text()='%s']/following::input[@value='Add to cart'][1]";
    public static final String ADDTOCART_2ND_ITEM_BTN = "//input[@id='add-to-cart-button-72']";
    public static final String ADDTOCART_3RD_ITEM_BTN = "//input[@id='add-to-cart-button-16']";
    public static final String ADDPRODUCT_MSG1 = "//p[text()='%s']";
    public static final String ADDPRODUCT_MSG2 = "//a[text()='%s']";
    public static final String HDD_BTN = "//label[text()='%s']";
    public static final String SHOPPINGCART_QTY = "//span[text()='(%s)']";
    public static final String SHOPPINGCART_BTN = "//li[@id='topcartlink']//a";
}
