package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BasePage {
    public WebDriver driver;
    public boolean isLoginMessageCorrect(String expectedMessage){
        Boolean isMessageDisplayed = isElementDisplay(driver, LoginPageUI.ERROR_MESSAGE);
        if (isMessageDisplayed) {
            String actualMessage = getTextElement(driver, LoginPageUI.ERROR_MESSAGE);
            Log.allure("Expected Message: " + expectedMessage + "Actual Message: " + actualMessage);
            return expectedMessage.equals(actualMessage);
        } else if (!isMessageDisplayed) {
            Log.allure("Login successfully");
            return true;
        } else {
            String validatedMessage = getTextElement(driver, LoginPageUI.VALIDATED_MESSAGE);
            Log.allure("Expected Message: " + expectedMessage + "Validated Message: " + validatedMessage);
            return expectedMessage.equals(validatedMessage);
        }
    };

    public boolean verifyIsOnLoginPage() {
        Log.allure("verify is on Login page");
        return driver.findElement(By.xpath(LoginPageUI.TITLE_LOGINPAGE)).isDisplayed();
    }

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        Log.allure("input email: " + email);
        sendKeyToElement(driver, LoginPageUI.EMAIL_FIELD, email);
    }

    public void inputPassword(String password) {
        Log.allure("input password: " + password);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_FIELD, password);
    }

    public void clickLogin() {
        clickToElement(driver,LoginPageUI.LOGIN_BTN);
    }
}
