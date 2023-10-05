package com.vmo.demowebshop.interfaces;

public class BooksPageUI {
    public static final String BOOKS_TAG = "//div[@class='ajax-loading-block-window']/preceding-sibling::div[@class='header-menu']/child::ul[@class='top-menu']/descendant::a[contains(text(),'Books')]";
    public static final String TITLE_BOOKSPAGE = "//h1[contains(text(),'Books')]";
    public static final String ADDPRODUCT_MSG1 = "//p[text()='%s']";
    public static final String ADDPRODUCT_MSG2 = "//a[text()='%s']";
    public static final String SHOPPINGCART_QTY = "//span[text()='(%s)']";
    public static final String ADDTOCART_BTN_1STHIGHESTRATING = "(//input[@value='Add to cart'])[1]";
    public static final String ADDTOCART_BTN_2NDHIGHESTRATING = "(//input[@value='Add to cart'])[2]";
    public static final String SHOPPINGCART = "//a[@class='ico-cart']//span[@class='cart-label']";
}
