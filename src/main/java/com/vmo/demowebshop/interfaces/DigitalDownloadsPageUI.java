package com.vmo.demowebshop.interfaces;

public class DigitalDownloadsPageUI {
    public static final String TITLE_DIGITAL_DOWNLOADS_PAGE = "//h1[contains(text(),'Digital downloads')]";
    public static final String ADDTOCART_ITEM = "//a[text()='%s']/following::input[1]";
    public static final String ADDPRODUCT_MSG1 = "//p[text()='%s']";
    public static final String ADDPRODUCT_MSG2 = "//a[text()='%s']";
}
