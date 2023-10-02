package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.ComputersPageUI;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.SoftwarePageUI;
import io.qameta.allure.Step;
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
        driver.get("https://demo.nopcommerce.com/");
        return this;
    }

    public RegisterPageObject goToRegisterPage() {
        Log.allure("navigate to Register page");
        clickToElement(driver, HomePageUI.REGISTER_BTN);
        return new RegisterPageObject(driver);
    }

    public boolean isOnHomePage() {
        Log.allure("verify on Home page");
        return driver.findElement(By.xpath(HomePageUI.TITLE_HOMEPAGE)).isDisplayed();
    }

    public void inputSearchProduct(String productName) {
        Log.allure("input product name in Search bar: " + productName);
        sendKeyToElement(driver, HomePageUI.SEARCH_BAR, productName);
    }

    public SearchPageObject clickSearchButton() {
        Log.allure("click Search button");
        clickToElement(driver, HomePageUI.SEARCH_BTN);
        return new SearchPageObject(driver);
    }

    public ComputersPageObject goToComputers() {
        Log.allure("navigate to Computers page");
        clickToElement(driver, HomePageUI.COMPUTERS_BTN);
        return new ComputersPageObject(driver);
    }

    public LoginPageObject goToLogin() {
        Log.allure("navigate to Login page");
        clickToElement(driver, HomePageUI.LOGIN_BTN);
        return new LoginPageObject(driver);
    }

    public void waitUntilLogin() {
        Log.allure("wait until button Login clickable");
        waitForElementClickable(driver, HomePageUI.LOGIN_BTN);
    }

    public NewsPageObject clickOnNews(String title) {
        Log.allure("click on News title: " + title);
        clickToElement(driver, HomePageUI.DYNAMIC_NEWS_TITLE, title);
        return new NewsPageObject(driver);
    }

    public String selectCurrency() {
        if (getSelectedItemInDefaultDropdown(driver, HomePageUI.CURRENCY_DROPDOWN).equals("US Dollar")) {
            selectItemInDefaultDropdownByText(driver, HomePageUI.CURRENCY_DROPDOWN, "Euro");
            Log.allure("select currency: Euro");
            return "Euro";
        } else {
            selectItemInDefaultDropdownByText(driver, HomePageUI.CURRENCY_DROPDOWN, "US Dollar");
            Log.allure("select currency: US Dollar");
            return "US Dollar";
        }
    }

    public boolean isCurrentCurrencyCorrect(String expectCurrency) {
        String actualCurrency = getSelectedItemInDefaultDropdown(driver, HomePageUI.CURRENCY_DROPDOWN);
        Log.allure("verify current currency is: " + expectCurrency);
        return actualCurrency.equals(expectCurrency);
    }

    public boolean isCurrencySymbolCorrect() {
        ArrayList<String> actualList = getFirstCharFromTextList(driver, HomePageUI.PRODUCT_CURRENCY_SYMBOL);
        ArrayList<String> expectList = new ArrayList<>();
        if (getSelectedItemInDefaultDropdown(driver, HomePageUI.CURRENCY_DROPDOWN).equals("Euro")) {
            Log.allure("verify currency symbol is correct: €");
            for (int i = 0; i <= 3; i++) {
                expectList.add("€");
            }
        } else {
            Log.allure("verify currency symbol is correct: $");
            for (int i = 0; i <= 3; i++) {
                expectList.add("$");
            }
        }
        return expectList.equals(actualList);
    }

    public void clickFacebook() {
        clickToElement(driver, HomePageUI.FACEBOOK_BTN);
        Log.allure("click Facebook icon");
    }

    public FacebookPageObject switchToFacebookTab() {
        switchWindowByID(driver, driver.getWindowHandle());
        Log.allure("switch to tab Facebook");
        return new FacebookPageObject(driver);
    }
}
