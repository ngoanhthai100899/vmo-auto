package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.ShoppingCartPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnShoppingCartPage() {
        Log.allure("verify on Shopping Cart page");
        return driver.findElement(By.xpath(ShoppingCartPageUI.TITLE_SHOPPINGCARTPAGE)).isDisplayed();
    }

    public void selectItem(String itemName) {
        Log.allure("select item: " + itemName);
        clickToElement(driver, String.format(ShoppingCartPageUI.ITEM_CHECKBOX, itemName));
    }

    public void clickUpdateCart() {
        Log.allure("click button update cart");
        clickToElement(driver, ShoppingCartPageUI.UPDATECART_BTN);
    }

    public boolean isItemUndisplayed(String itemName) {
        Log.allure("verify item " + itemName + " is not displayed");
        return isElementUndisplayed(driver, String.format(ShoppingCartPageUI.ITEM_CHECKBOX, itemName));
    }
    public void agreeTermsOfService() {
        Log.allure("agree with the terms of service");
        checkToDefaultCheckboxOrDefaultRadio(driver,ShoppingCartPageUI.TERMS_CHECKBOX);
    }
    public boolean verifyTermsOfServiceIsChecked(){
        return isElementSelected(driver,ShoppingCartPageUI.TERMS_CHECKBOX);
    }
    public CheckoutPageObject clickCheckout(){
        clickToElement(driver,ShoppingCartPageUI.CHECKOUT_BTN);
        return new CheckoutPageObject(driver);
    }
}
