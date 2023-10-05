package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.LoginPageUI;
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
}
