package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.SoftwarePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

public class SoftwarePageObject extends BasePage {
    public WebDriver driver;
    public SoftwarePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyIsOnSoftwarePage() {
        Log.allure("verify on Software page");
        return driver.findElement(By.xpath(SoftwarePageUI.TITLE_SOFTWARE)).isDisplayed();
    }
    public void selectSort(String text){
        selectItemInDefaultDropdownByText(driver, SoftwarePageUI.SORT_DROPDOWN,text);
        Log.allure("select dropdown option: "+text);
    }
    public boolean verifyOptionZToAIsDisplayed() {
        Log.allure("verify dropdown option Z to A is displayed");
        return driver.findElement(By.xpath(SoftwarePageUI.SORT_OPTIONZTOA)).isDisplayed();
    }
    public void clickSortDropDown(){
        clickToElement(driver,SoftwarePageUI.SORT_DROPDOWN);
        Log.allure("click on dropdown");
    }
    public boolean verifyProductIsDisplayedFromZToA(){
        Log.allure("verify product list is displayed from Z to A");
        ArrayList<String> actualList = getTextListFromElements(driver,SoftwarePageUI.PRODUCTNAME_LIST);
        ArrayList<String> expectList = setTextListFromZToA(driver,SoftwarePageUI.PRODUCTNAME_LIST);
        return expectList.equals(actualList);
    }
    public void waitUntilLoading(){
        waitForElementVisibleShortTime(driver,SoftwarePageUI.LOADING_ICON);
        waitForElementPresence(driver,SoftwarePageUI.LOADING_ICON_NONE);
        Log.allure("wait until sorting is loaded");
    }
}
