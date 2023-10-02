package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.ComputersPageUI;
import com.vmo.nopcommerce.interfaces.FacebookPageUI;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class FacebookPageObject extends BasePage {
    public WebDriver driver;
    public FacebookPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isTitleCorrect(String title){
        Log.allure("verify Facebook title is correct");
        return getTitle(driver).equals(title);
    }
    public void waitForTitle(){
        Log.allure("wait until Facebook title loaded");
        waitForElementVisible(driver, FacebookPageUI.FACEBOOK_POPUP);
    }
}
