package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.YopMailPageUI;
import org.openqa.selenium.WebDriver;

public class YopMailPageObject extends BasePage {
    public WebDriver driver;
    public YopMailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public YopMailPageObject goToYopMail() {
        driver.get("https://yopmail.com/");
        Log.allure("navigate to yopmail");
        return this;
    }
    public void inputEmail(String email){
        sendKeyToElement(driver,YopMailPageUI.EMAIL_INPUT,email);
        Log.allure("input email");
    }
    public void closeOtherTabs(){
        closeTabWithoutParent(driver,driver.getWindowHandle());
        Log.allure("close all other tabs except current");
    }
}
