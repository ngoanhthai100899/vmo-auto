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

    public boolean isItemPresent(String itemName) {
        Log.allure("verify item " + itemName + " is not present");
        try {
            driver.findElement(By.xpath(String.format(ShoppingCartPageUI.ITEM_CHECKBOX, itemName)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
