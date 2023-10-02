package com.vmo.nopcommerce.interfaces;

import org.openqa.selenium.WebElement;

public class RegisterPageUI {
    public static final String MALE_BTN = "//input[@id='gender-male']";
    public static final String FEMALE_BTN = "//input[@id='gender-female']";
    public static final String FIRST_NAME = "//input[@id='FirstName']";
    public static final String LAST_NAME = "//input[@id='LastName']";
    public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
    public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
    public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
    public static final String EMAIL = "//input[@name='Email']";
    public static final String PW = "//input[@id='Password']";
    public static final String PW_CONFIRM = "//input[@id='ConfirmPassword']";
    public static final String REGISTER_BTN = "//button[@id='register-button']";
    public static final String TITLE_REGISTERSUCCESS = "//div[text()='Your registration completed']";
    public static final String TITLE_REGISTERPAGE = "//strong[text()='Your Personal Details']";
}
