package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.SearchPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends BasePage {
    public WebDriver driver;
    public SearchPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean verifySearchProduct(String productName, String message){
        Log.allure("verify search product result");
        WebElement elementProductName= driver.findElement(By.xpath(SearchPageUI.TITLE_SEARCHPRODUCT));
        if (elementProductName!= null) {
            return elementProductName.getText().contains(productName);
        }
        WebElement elementMessage = driver.findElement(By.xpath(SearchPageUI.MSG_NOSEARCHPRODUCT));
        if (elementProductName!= null) {
            return elementMessage.getText().equals(message);
        }
        return false;
    }
}
