package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
import com.vmo.demowebshop.interfaces.HomePageUI;
import com.vmo.demowebshop.interfaces.HomeSauceDemoPageUI;
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
        clickToElement(driver, BooksPageUI.BOOKS_TAG);
        return new BooksPageObject(driver);
    }

    public void add1stItem() {
        clickToElement(driver, HomePageUI.ADDTOCART_1ST_ITEM);
    }

    public void add2ndItem() {
        clickToElement(driver, HomePageUI.ADDTOCART_2ND_ITEM);
    }

    public void add3rdItem() {
        clickToElement(driver, HomePageUI.ADDTOCART_3RD_ITEM);
    }
    public boolean isMsgAddProductDisplayed(String msg1, String msg2) {
        Log.allure("verify the 1st part of add product msg is displayed");
        return (driver.findElement(By.xpath(String.format(BooksPageUI.ADDPRODUCT_MSG1,msg1))).isDisplayed() && driver.findElement(By.xpath(String.format(BooksPageUI.ADDPRODUCT_MSG2,msg2))).isDisplayed());
    }

    public String Username(XSSFRow row) {
        Log.allure("Input username");
        return row.getCell(1).toString();
    }

    public void Password(XSSFRow row) {
        Log.allure("Input password");
        sendKeyToElement(driver, HomeSauceDemoPageUI.PW, row.getCell(2).toString());
    }
}
