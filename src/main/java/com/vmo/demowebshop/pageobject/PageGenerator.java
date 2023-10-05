package com.vmo.demowebshop.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static HomeSauceDemoPageObject getHomeSauceDemoPageObject(WebDriver driver){
        return new HomeSauceDemoPageObject(driver);
    }
}
