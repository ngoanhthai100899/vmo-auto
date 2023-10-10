package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
import com.vmo.demowebshop.interfaces.DigitalDownloadsPageUI;
import com.vmo.demowebshop.interfaces.HomePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalDownloadsPageObject extends BasePage {
    private WebDriver driver;

    public DigitalDownloadsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnDigitalDownloadsPage() {
        Log.allure("verify on Digital Downloads page");
        return driver.findElement(By.xpath(DigitalDownloadsPageUI.TITLE_DIGITAL_DOWNLOADS_PAGE)).isDisplayed();
    }

    public void clickAddToCart(String itemName) {
        Log.allure("click add to cart: " + itemName);
        clickToElement(driver, String.format(DigitalDownloadsPageUI.ADDTOCART_ITEM, itemName));
    }

    public boolean isMsgAddProductDisplayed(String msg1, String msg2) {
        Log.allure("verify the msg add product is displayed: " + msg1 + msg2);
        return (driver.findElement(By.xpath(String.format(DigitalDownloadsPageUI.ADDPRODUCT_MSG1, msg1))).isDisplayed() && driver.findElement(By.xpath(String.format(DigitalDownloadsPageUI.ADDPRODUCT_MSG2, msg2))).isDisplayed());
    }

    public boolean verifyShoppingCartAmount(String amount) {
        Log.allure("verify shopping cart amount: " + amount);
        return driver.findElement(By.xpath(String.format(DigitalDownloadsPageUI.SHOPPINGCART_QTY, amount))).isDisplayed();
    }

    public ShoppingCartPageObject goToShoppingCart() {
        Log.allure("navigate to Shopping Cart page");
        clickToElement(driver, DigitalDownloadsPageUI.SHOPPINGCART_BTN);
        return new ShoppingCartPageObject(driver);
    }
}
