package com.vmo.demowebshop.interfaces;

public class CheckoutPageUI {
    public static final String TITLE_CHECKOUT_PAGE = "//strong[text()='Checkout as a guest or register']";
    public static final String TITLE_ONE_PAGE_CHECKOUT_PAGE = "//h1[text()='Checkout']";
    public static final String BILLING_ADDRESS_TAG = "//h2[text()='Billing address']";
    public static final String GUEST_CHECKOUT_BTN = "//input[@class='button-1 checkout-as-guest-button']";
    public static final String FIRSTNAME_LABEL_BILLING = "//label[text()='First name:']";
    public static final String FIRSTNAME_LABEL_CONFIRM = "//li[@class='name']";
    public static final String FIRSTNAME_FIELD = "//input[@id='BillingNewAddress_FirstName']";
    public static final String LASTNAME_FIELD = "//input[@id='BillingNewAddress_LastName']";
    public static final String EMAIL_FIELD = "//input[@id='BillingNewAddress_Email']";
    public static final String COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
    public static final String CITY_FIELD = "//input[@id='BillingNewAddress_City']";
    public static final String ADDRESS_1_FIELD = "//input[@id='BillingNewAddress_Address1']";
    public static final String ZIP_POSTAL_FIELD = "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static final String PHONE_FIELD = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static final String CONTINUE_BTN_BILLING = "//input[@title='Continue']";
    public static final String CONTINUE_BTN_PAYMENT_METHOD = "//input[@class='button-1 payment-method-next-step-button']";
    public static final String COD_LABEL = "//input[@value='Payments.CashOnDelivery']";
    public static final String PAYMENT_INFO_TAB_EXPAND = "//li[@id='opc-payment_info'and@class='tab-section allow active']";
    public static final String CONTINUE_BTN_PAYMENT_INFO = "//input[@class='button-1 payment-info-next-step-button']";
    public static final String CONFIRM_ORDER_TAB_EXPAND = "//li[@id='opc-confirm_order'and@class='tab-section allow active']";
    public static final String EMAIL_LABEL_CONFIRM = "//li[@class='email']";
    public static final String PHONE_LABEL_CONFIRM = "//li[@class='phone']";
    public static final String ADDRESS1_LABEL_CONFIRM = "//li[@class='address1']";
    public static final String CITY_ZIP_LABEL_CONFIRM = "//li[@class='city-state-zip']";
    public static final String COUNTRY_LABEL_CONFIRM = "//li[@class='country']";
    public static final String PAYMENT_METHOD_LABEL_CONFIRM = "//li[@class='payment-method']";
    public static final String PAY_COD_MSG = "//p[text()='You will pay by COD']";
    public static final String SUB_TOTAL = "(//span[@class='product-price'])[1]";
    public static final String PAYMENT_FEE = "(//span[@class='product-price'])[2]";
    public static final String TOTAL = "//span[@class='product-price order-total']";
    public static final String CONFIRM_BTN = "//input[@class='button-1 confirm-order-next-step-button']";
    public static final String TITLE_CHECKOUT_COMPLETED_PAGE = "//div[@class='page-title']/h1";
    public static final String ORDER_SUCCESSFULLY_MSG = "//strong[text()='Your order has been successfully processed!']";
    public static final String CONTINUE_TO_HOMEPAGE_BTN = "//input[@class='button-2 order-completed-continue-button']";
}
