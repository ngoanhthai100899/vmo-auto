package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.ComputersPageUI;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.HomeSauceDemoPageUI;
import com.vmo.nopcommerce.interfaces.SoftwarePageUI;
import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;

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
    public String Username(XSSFRow row) {
        Log.allure("Input username");
        return row.getCell(1).toString();
    }

    public void Password(XSSFRow row) {
        Log.allure("Input password");
        sendKeyToElement(driver, HomeSauceDemoPageUI.PW, row.getCell(2).toString());
    }
}
