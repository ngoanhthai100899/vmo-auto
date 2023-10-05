package com.vmo.demowebshop.factoryBrowser;

import com.vmo.demowebshop.common.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGridDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "117");
        options.setCapability("platformName", "Windows");
        options.setCapability("se:name", "My simple test");
        options.setCapability("se:sampleMetadata", "Sample metadata value");
        try {
            return new RemoteWebDriver(new URL(GlobalConstants.HUB_REMOTE),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
