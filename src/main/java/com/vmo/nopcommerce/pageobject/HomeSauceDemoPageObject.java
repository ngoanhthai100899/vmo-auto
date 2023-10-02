package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.HomeSauceDemoPageUI;
import com.vmo.nopcommerce.utils.excelutils.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class HomeSauceDemoPageObject extends BasePage {
    public boolean isLoginFail(){
        Log.allure("verify login successful");
        return driver.findElement(By.xpath(HomeSauceDemoPageUI.ERROR_LOGIN_BTN)).isDisplayed();
    };
    private WebDriver driver;

    public HomeSauceDemoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomeSauceDemoPageObject goToHomePage() {
        Log.allure("navigate to Home page");
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    public boolean isOnHomePage() {
        Log.allure("verify on Home page");
        return driver.findElement(By.xpath(HomeSauceDemoPageUI.TITLE_HOMEPAGE)).isDisplayed();
    }
    public void inputUsername(XSSFRow row) {
        Log.allure("Input username");
        sendKeyToElement(driver, HomeSauceDemoPageUI.USERNAME, row.getCell(1).toString());
    }

    public void inputPassword(XSSFRow row) {
        Log.allure("Input password");
        sendKeyToElement(driver, HomeSauceDemoPageUI.PW, row.getCell(2).toString());
    }

    public void clickLogin() {
        Log.allure("click Login");
        clickToElement(driver, HomeSauceDemoPageUI.LOGIN_BTN);
    }
}
