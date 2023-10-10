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

    public boolean isBillingAddressTabExpanded() {
        Log.allure("verify Billing Address tab is expanded");
        return driver.findElement(By.xpath(CheckoutPageUI.FIRSTNAME_LABEL_BILLING)).isDisplayed();
    }

    public boolean isPaymentMethodTabExpanded() {
        Log.allure("verify Payment Method tab is expanded");
        return driver.findElement(By.xpath(CheckoutPageUI.COD_LABEL)).isDisplayed();
    }

    public boolean isCodOptionSelected() {
        Log.allure("verify option COD is selected");
        return driver.findElement(By.xpath(CheckoutPageUI.COD_LABEL)).isSelected();
    }

    public boolean isPaymentInfoTabExpanded() {
        Log.allure("verify Payment Info tab is expanded");
        return driver.findElement(By.xpath(CheckoutPageUI.PAYMENT_INFO_TAB_EXPAND)).isDisplayed();
    }

    public boolean isConfirmOrderTabExpanded() {
        Log.allure("verify Confirm Order tab is expanded");
        return driver.findElement(By.xpath(CheckoutPageUI.CONFIRM_ORDER_TAB_EXPAND)).isDisplayed();
    }

    public boolean isNameCorrect(String firstName, String lastName) {
        Log.allure("verify name is correct");
        return driver.findElement(By.xpath(CheckoutPageUI.FIRSTNAME_LABEL_CONFIRM)).getText().equals(firstName + " " + lastName);
    }

    public boolean isEmailCorrect(String email) {
        Log.allure("verify email is correct");
        return driver.findElement(By.xpath(CheckoutPageUI.EMAIL_LABEL_CONFIRM)).getText().equals("Email: " + email);
    }

    public boolean isPhoneCorrect(String phoneNumber) {
        Log.allure("verify phone number is correct");
        return driver.findElement(By.xpath(CheckoutPageUI.PHONE_LABEL_CONFIRM)).getText().equals("Phone: " + phoneNumber);
    }

    public boolean isAddress1Correct(String address1) {
        Log.allure("verify address 1 is correct");
        return driver.findElement(By.xpath(CheckoutPageUI.ADDRESS1_LABEL_CONFIRM)).getText().equals(address1);
    }

    public boolean isCityZipCorrect(String city, String zip) {
        Log.allure("verify city and zip are correct");
        return driver.findElement(By.xpath(CheckoutPageUI.CITY_ZIP_LABEL_CONFIRM)).getText().equals(city + " , " + zip);
    }

    public boolean isCountryCorrect(String country) {
        Log.allure("verify country is correct");
        return driver.findElement(By.xpath(CheckoutPageUI.COUNTRY_LABEL_CONFIRM)).getText().equals(country);
    }

    public boolean isPaymentMethodCorrect(String paymentMethod) {
        Log.allure("verify Payment Method is correct");
        return driver.findElement(By.xpath(CheckoutPageUI.PAYMENT_METHOD_LABEL_CONFIRM)).getText().contains(paymentMethod);
    }
    public boolean isTotalCorrect(){
        Log.allure("verify total is correct");
        int subTotal = Integer.parseInt(driver.findElement(By.xpath(CheckoutPageUI.SUB_TOTAL)).getText().substring(0,1));
        int paymentFee = Integer.parseInt(driver.findElement(By.xpath(CheckoutPageUI.PAYMENT_FEE)).getText().substring(0,1));
        int total = subTotal + paymentFee;
        return driver.findElement(By.xpath(CheckoutPageUI.TOTAL)).getText().substring(0,1).equals(Integer.toString(total));
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

    public void clickContinueToPaymentMethod() {
        Log.allure("continue to Payment Method");
        clickToElement(driver, CheckoutPageUI.CONTINUE_BTN_BILLING);
    }

    public void clickContinueToPaymentInfo() {
        Log.allure("continue to Payment Info");
        clickToElement(driver, CheckoutPageUI.CONTINUE_BTN_PAYMENT_METHOD);
    }

    public void clickContinueToConfirmOrder() {
        Log.allure("continue to Confirm Order");
        clickToElement(driver, CheckoutPageUI.CONTINUE_BTN_PAYMENT_INFO);
    }

    public boolean isMsgPayByCodAppear() {
        Log.allure("verify msg pay by COD appear");
         return driver.findElement(By.xpath(CheckoutPageUI.PAY_COD_MSG)).getAttribute("innerHTML").equals("You will pay by COD");
    }

    public void clickConfirm() {
        Log.allure("click Confirm");
        clickToElement(driver,CheckoutPageUI.CONFIRM_BTN);
    }

    public boolean isOnCheckoutCompletedPage() {
        Log.allure("verify on Checkout Completed page");
        return driver.findElement(By.xpath(CheckoutPageUI.TITLE_CHECKOUT_COMPLETED_PAGE)).isDisplayed();
    }

    public boolean isMsgOrderSuccessfullyDisplayed() {
        Log.allure("verify msg order successfully is displayed");
        return driver.findElement(By.xpath(CheckoutPageUI.ORDER_SUCCESSFULLY_MSG)).isDisplayed();
    }
    public HomePageObject clickContinueToHomePage(){
        Log.allure("click Continue to Home page");
        clickToElement(driver,CheckoutPageUI.CONTINUE_TO_HOMEPAGE_BTN);
        return new HomePageObject(driver);
    }
}
