package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.CheckoutPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObject extends BasePage {
    private WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnCheckoutPage() {
        Log.allure("verify on Checkout page");
        return driver.findElement(By.xpath(CheckoutPageUI.TITLE_CHECKOUT_PAGE)).isDisplayed();
    }

    public boolean isOnOnePageCheckoutPage() {
        Log.allure("verify on One Page Checkout page");
        return (driver.findElement(By.xpath(CheckoutPageUI.TITLE_ONE_PAGE_CHECKOUT_PAGE)).isDisplayed() && driver.findElement(By.xpath(CheckoutPageUI.BILLING_ADDRESS_TAG)).isDisplayed());
    }

    public boolean isBillingAddressTabExpand() {
        Log.allure("verify Billing Address tab is expanded");
        return (driver.findElement(By.xpath(CheckoutPageUI.BILLING_ADDRESS_TAG_EXPAND)).isDisplayed() && driver.findElement(By.xpath(CheckoutPageUI.FIRSTNAME_LABEL)).isDisplayed());
    }

    public void clickCheckoutAsGuest() {
        Log.allure("click checkout as guest");
        clickToElement(driver, CheckoutPageUI.GUEST_CHECKOUT_BTN);
    }

    public void inputFirstName(String firstName) {
        Log.allure("input First Name: " + firstName);
        sendKeyToElement(driver, CheckoutPageUI.FIRSTNAME_FIELD, firstName);
    }

    public void inputLastName(String lastName) {
        Log.allure("input Last Name: " + lastName);
        sendKeyToElement(driver, CheckoutPageUI.LASTNAME_FIELD, lastName);
    }

    public void inputEmail(String email) {
        Log.allure("input email: " + email);
        sendKeyToElement(driver, CheckoutPageUI.EMAIL_FIELD, email);
    }

    public void selectCountry(String country) {
        Log.allure("select country: " + country);
        selectItemInDefaultDropdownByText(driver, CheckoutPageUI.COUNTRY_DROPDOWN, country);
    }

    public void inputCity(String city) {
        Log.allure("input city: " + city);
        sendKeyToElement(driver, CheckoutPageUI.CITY_FIELD, city);
    }

    public void inputAddress1(String address1) {
        Log.allure("input address1: " + address1);
        sendKeyToElement(driver, CheckoutPageUI.ADDRESS_1_FIELD, address1);
    }

    public void inputZipPostal(String zipPostal) {
        Log.allure("input zip/postal code: " + zipPostal);
        sendKeyToElement(driver, CheckoutPageUI.ZIP_POSTAL_FIELD, zipPostal);
    }

    public void inputPhone(String phoneNumber) {
        Log.allure("input phone number: " + phoneNumber);
        sendKeyToElement(driver, CheckoutPageUI.PHONE_FIELD, phoneNumber);
    }
    public void clickContinueToPaymentMethod(){
        clickToElement(driver,CheckoutPageUI.CONTINUE_BTN_BILLING);
    }
}
