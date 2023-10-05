package com.vmo.demowebshop.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver(){
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }
}
