package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.PasswordRecoveryPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPageObject extends BasePage {
    public WebDriver driver;
    public boolean verifyIsOnPasswordRecoveryPage() {
        Log.allure("verify on Password Recovery page");
        return driver.findElement(By.xpath(PasswordRecoveryPageUI.TITLE_PASSWORDRECOVERYPAGE)).isDisplayed();
    }

    public PasswordRecoveryPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputEmail(String email){
        sendKeyToElement(driver,PasswordRecoveryPageUI.EMAIL,email);
        Log.allure("input email");
    }
    public void clickRecover(){
        clickToElement(driver,PasswordRecoveryPageUI.RECOVER_BTN);
        Log.allure("click button Recovery");
    }
    public String verifyMsgEmailSentSuccess(){
        Log.allure("verify msg email sent successfully");
        return driver.findElement(By.xpath(PasswordRecoveryPageUI.MSG_EMAILSENTSUCCESS)).getText();
    }
    public void openANewTab(){
        switchToNewTab(driver);
        Log.allure("open a new tab");
    }
}
