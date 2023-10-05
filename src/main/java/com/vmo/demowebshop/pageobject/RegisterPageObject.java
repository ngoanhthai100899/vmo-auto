package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.RegisterPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    public WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyIsOnRegisterPage() {
        Log.allure("verify is on Register page");
        return driver.findElement(By.xpath(RegisterPageUI.TITLE_REGISTERPAGE)).isDisplayed();
    }

    public boolean verifyRegisterSuccessful() {
        Log.allure("verify register successfully");
        return driver.findElement(By.xpath(RegisterPageUI.TITLE_REGISTERSUCCESS)).isDisplayed();
    }

    public void selectMale() {
        clickToElement(driver, RegisterPageUI.MALE_BTN);
        Log.allure("select Gender = Male");
    }

    public void selectFemale() {
        clickToElement(driver, RegisterPageUI.FEMALE_BTN);
        Log.allure("select Gender = Female");
    }

    public void inputFirstName(String firstname) {
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME, firstname);
        Log.allure("input first name: " + firstname);
    }

    public void selectDay(String day) {
        selectItemInDefaultDropdownByText(driver, RegisterPageUI.DAY_DROPDOWN, day);
        Log.allure("select Day: " + day);
    }

    public void selectMonth(String month) {
        selectItemInDefaultDropdownByText(driver, RegisterPageUI.DAY_DROPDOWN, month);
        Log.allure("select Month: " + month);
    }

    public void selectYear(String year) {
        selectItemInDefaultDropdownByText(driver, RegisterPageUI.DAY_DROPDOWN, year);
        Log.allure("select Year: " + year);
    }

    public void inputLastName(String lastname) {
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME, lastname);
        Log.allure("input last name: " + lastname);
    }

    public void inputEmail(String email) {
        sendKeyToElement(driver, RegisterPageUI.EMAIL, email);
        Log.allure("input email: " + email);
    }

    public void inputPW(String pw) {
        sendKeyToElement(driver, RegisterPageUI.PW, pw);
        Log.allure("input pw: "+pw);
    }

    public void inputPWConfirm(String pw) {
        sendKeyToElement(driver, RegisterPageUI.PW_CONFIRM, pw);
        Log.allure("input pw: "+pw);
    }

    public void clickRegister() {
        clickToElement(driver, RegisterPageUI.REGISTER_BTN);
        Log.allure("click button Register");
    }
}
