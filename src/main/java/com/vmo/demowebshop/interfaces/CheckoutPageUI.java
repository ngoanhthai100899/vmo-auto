package com.vmo.demowebshop.interfaces;

public class CheckoutPageUI {
    public static final String TITLE_CHECKOUT_PAGE = "//strong[text()='Checkout as a guest or register']";
    public static final String TITLE_ONE_PAGE_CHECKOUT_PAGE = "//h1[text()='Checkout']";
    public static final String BILLING_ADDRESS_TAG = "//h2[text()='Billing address']";
    public static final String BILLING_ADDRESS_TAG_EXPAND = "//li[@class='tab-section allow active']";
    public static final String GUEST_CHECKOUT_BTN = "//input[@class='button-1 checkout-as-guest-button']";
    public static final String FIRSTNAME_LABEL = "//label[text()='First name:']";
    public static final String FIRSTNAME_FIELD = "//input[@id='BillingNewAddress_FirstName']";
    public static final String LASTNAME_FIELD = "//input[@id='BillingNewAddress_LastName']";
    public static final String EMAIL_FIELD = "//input[@id='BillingNewAddress_Email']";
    public static final String COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
    public static final String CITY_FIELD = "//input[@id='BillingNewAddress_City']";
    public static final String ADDRESS_1_FIELD = "//input[@id='BillingNewAddress_Address1']";
    public static final String ZIP_POSTAL_FIELD = "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static final String PHONE_FIELD = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static final String CONTINUE_BTN_BILLING = "//input[@title='Continue']";
}
