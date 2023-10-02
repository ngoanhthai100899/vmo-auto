package com.vmo.nopcommerce.interfaces;

public class SoftwarePageUI {
    public static final String TITLE_SOFTWARE = "//div[@class='page-title']/h1[text()='Software']";
    public static final String SORT_DROPDOWN = "//select[@name='products-orderby']";
    public static final String SORT_OPTIONZTOA = "//select[@name='products-orderby']/child::option[@value='6']";
    public static final String PRODUCTNAME_LIST = "//h2[@class='product-title']/child::a";
    public static final String LOADING_ICON = "//div[@style='display: block;']";
    public static final String LOADING_ICON_NONE = "//div[@style='display: none;']";
}
