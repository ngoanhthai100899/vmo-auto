package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
import com.vmo.demowebshop.interfaces.DigitalDownloadsPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalDownloadsPageObject extends BasePage {
    private WebDriver driver;

    public DigitalDownloadsPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isOnDigitalDownloadsPage() {
        Log.allure("verify on Digital Downloads page");
        return driver.findElement(By.xpath(DigitalDownloadsPageUI.TITLE_DIGITAL_DOWNLOADS_PAGE)).isDisplayed();
    }
}
