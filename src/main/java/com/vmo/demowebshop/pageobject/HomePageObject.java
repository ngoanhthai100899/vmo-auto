package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.HomePageUI;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject goToHomePage() {
        Log.allure("navigate to Home page");
        driver.get("https://demowebshop.tricentis.com/");
        return this;
    }

    public boolean isOnHomePage() {
        Log.allure("verify on Home page");
        return driver.findElement(By.xpath(HomePageUI.TITLE_HOMEPAGE)).isDisplayed();
    }

    public LoginPageObject goToLogin() {
        Log.allure("navigate to Login page");
        clickToElement(driver, HomePageUI.LOGIN_BTN);
        return new LoginPageObject(driver);
    }

    public BooksPageObject goToBooksPage() {
        Log.allure("navigate to Books page");
        clickToElement(driver, HomePageUI.BOOKS_TAG);
        return new BooksPageObject(driver);
    }
    public DigitalDownloadsPageObject goToDigitalDownloadsPage() {
        Log.allure("navigate to Digital Downloads page");
        clickToElement(driver, HomePageUI.DIGITAL_DOWNLOADS_TAG);
        return new DigitalDownloadsPageObject(driver);
    }

    public void addItem(String itemName) {
        Log.allure("add item: " + itemName);
        clickToElement(driver, String.format(HomePageUI.ADDTOCART_ITEM, itemName));
    }

    public void clickAddToCart2ndItem() {
        Log.allure("click button add to cart when in 2nd item details");
        clickToElement(driver, HomePageUI.ADDTOCART_2ND_ITEM_BTN);
    }

    public void clickAddToCart3rdItem() {
        Log.allure("click button add to cart when in 3rd item details");
        clickToElement(driver, HomePageUI.ADDTOCART_3RD_ITEM_BTN);
    }

    public boolean isMsgAddProductDisplayed(String msg1, String msg2) {
        Log.allure("verify the msg add product is displayed: " + msg1 + msg2);
        return (driver.findElement(By.xpath(String.format(HomePageUI.ADDPRODUCT_MSG1, msg1))).isDisplayed() && driver.findElement(By.xpath(String.format(HomePageUI.ADDPRODUCT_MSG2, msg2))).isDisplayed());
    }

    public String Username(XSSFRow row) {
        Log.allure("Input username");
        return row.getCell(1).toString();
    }


    public void selectHDDOption(String HddOption) {
        Log.allure("select HDD Option: " + HddOption);
        clickToElement(driver, String.format(HomePageUI.HDD_BTN, HddOption));
    }

    public boolean verifyShoppingCartAmount(String amount) {
        Log.allure("verify shopping cart increases the amount");
        return driver.findElement(By.xpath(String.format(HomePageUI.SHOPPINGCART_QTY, amount))).isDisplayed();
    }

    public ShoppingCartPageObject goToShoppingCart() {
        Log.allure("navigate to Shopping Cart page");
        clickToElement(driver, HomePageUI.SHOPPINGCART_BTN);
        return new ShoppingCartPageObject(driver);
    }

    public void scrollToTop() {
        scrollToTopPage(driver);
    }
}
