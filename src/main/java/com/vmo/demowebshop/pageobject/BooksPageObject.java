package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPageObject extends BasePage {
    private WebDriver driver;

    public BooksPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isOnBooksPage() {
        Log.allure("verify on Books page");
        return driver.findElement(By.xpath(BooksPageUI.TITLE_BOOKSPAGE)).isDisplayed();
    }
    public boolean isShoppingCartIncreaseTheAmount(String value) {
        Log.allure("verify shopping cart increases the amount");
        return driver.findElement(By.xpath(String.format(BooksPageUI.SHOPPINGCART_QTY,value))).isDisplayed();
    }
    public boolean isMsgAddProductDisplayed(String msg1, String msg2) {
        Log.allure("verify the 1st part of add product msg is displayed");
        return (driver.findElement(By.xpath(String.format(BooksPageUI.ADDPRODUCT_MSG1,msg1))).isDisplayed() && driver.findElement(By.xpath(String.format(BooksPageUI.ADDPRODUCT_MSG2,msg2))).isDisplayed());
    }
    public void addThe1stHighestRatingProduct(){
        Log.allure("add the 1st highest rating product");
        clickToElement(driver,BooksPageUI.ADDTOCART_BTN_1STHIGHESTRATING);
    }
    public void addThe2ndHighestRatingProduct(){
        Log.allure("add the 2nd highest rating product");
        clickToElement(driver,BooksPageUI.ADDTOCART_BTN_2NDHIGHESTRATING);
    }
    public void hoverToShoppingCart(){
        hoverMouseToElement(driver,BooksPageUI.SHOPPINGCART);
    }
}
