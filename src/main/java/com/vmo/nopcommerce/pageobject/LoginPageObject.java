package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    public WebDriver driver;

    public boolean verifyIsOnLoginPage() {
        Log.allure("verify is on Login page");
        return driver.findElement(By.xpath(LoginPageUI.TITLE_LOGINPAGE)).isDisplayed();
    }

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PasswordRecoveryPageObject goToPasswordRecovery() {
        clickToElement(driver, LoginPageUI.FORGOTPW_BTN);
        Log.allure("navigate to Password Recovery page");
        return new PasswordRecoveryPageObject(driver);
    }
}
