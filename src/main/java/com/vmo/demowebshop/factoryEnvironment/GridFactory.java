package com.vmo.demowebshop.factoryEnvironment;

import com.vmo.demowebshop.factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class GridFactory {
    private WebDriver driver;
    public WebDriver createDriver(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver = new ChromeGridDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            case "H_CHROME":
                driver = new ChromeHeadlessDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
        return driver;
    }
}
