package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.ComputersPageUI;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class ComputersPageObject extends BasePage {
    public WebDriver driver;

    public ComputersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public SoftwarePageObject goToSoftware() {
        clickToElement(driver, ComputersPageUI.SOFTWARE_BTN);
        Log.allure("navigate to Software page");
        return new SoftwarePageObject(driver);
    }
}
