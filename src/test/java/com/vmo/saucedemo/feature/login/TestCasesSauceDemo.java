package com.vmo.saucedemo.feature.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.pageobject.*;
import com.vmo.nopcommerce.utils.excelutils.ExcelUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)
public class TestCasesSauceDemo extends BaseTest {
    protected HomeSauceDemoPageObject homeSauceDemoPage;
    public WebDriver driver;

    @Parameters({"browser","runType"})
    @BeforeMethod
    public void setUp(@Optional("H_CHROME") String browser,@Optional("CHROME")String runType) {
        driver = getBrowserDriver(browser,runType);
        ExcelUtil.setExcelFileSheet("data");
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
    }

    @Epic("SauceDemo")
    @Feature("Login")
    @Story("Login fail")
    @Test(priority = 1)
    public void LoginWrongPasswordChar() {
        homeSauceDemoPage = PageGenerator.getHomeSauceDemoPageObject(getDriver());
        homeSauceDemoPage.goToHomePage();
        Assert.assertTrue(homeSauceDemoPage.isOnHomePage());
        homeSauceDemoPage.inputUsername(ExcelUtil.getRowData(1));
        homeSauceDemoPage.inputPassword(ExcelUtil.getRowData(1));
        homeSauceDemoPage.clickLogin();
        Assert.assertTrue(homeSauceDemoPage.isLoginFail());
    }
    @Epic("SauceDemo")
    @Feature("Login")
    @Story("Login fail")
    @Test(priority = 2)
    public void LoginEmptyUsername() {
        homeSauceDemoPage = PageGenerator.getHomeSauceDemoPageObject(getDriver());
        homeSauceDemoPage.goToHomePage();
        Assert.assertTrue(homeSauceDemoPage.isOnHomePage());
        homeSauceDemoPage.inputUsername(ExcelUtil.getRowData(2));
        homeSauceDemoPage.inputPassword(ExcelUtil.getRowData(2));
        homeSauceDemoPage.clickLogin();
        Assert.assertTrue(homeSauceDemoPage.isLoginFail());
    }
    @Epic("SauceDemo")
    @Feature("Login")
    @Story("Login fail")
    @Test(priority = 3)
    public void LoginEmptyPassword() {
        homeSauceDemoPage = PageGenerator.getHomeSauceDemoPageObject(getDriver());
        homeSauceDemoPage.goToHomePage();
        Assert.assertTrue(homeSauceDemoPage.isOnHomePage());
        homeSauceDemoPage.inputUsername(ExcelUtil.getRowData(3));
        homeSauceDemoPage.inputPassword(ExcelUtil.getRowData(3));
        homeSauceDemoPage.clickLogin();
        Assert.assertTrue(homeSauceDemoPage.isLoginFail());
    }
    @Epic("SauceDemo")
    @Feature("Login")
    @Story("Login fail")
    @Test(priority = 4)
    public void LoginEmptyUsernameAndPassword() {
        homeSauceDemoPage = PageGenerator.getHomeSauceDemoPageObject(getDriver());
        homeSauceDemoPage.goToHomePage();
        Assert.assertTrue(homeSauceDemoPage.isOnHomePage());
        homeSauceDemoPage.inputUsername(ExcelUtil.getRowData(4));
        homeSauceDemoPage.inputPassword(ExcelUtil.getRowData(4));
        homeSauceDemoPage.clickLogin();
        Assert.assertTrue(homeSauceDemoPage.isLoginFail());
    }
    @Epic("SauceDemo")
    @Feature("Login")
    @Story("Login fail")
    @Test(priority = 5)
    public void LoginWrongPasswordNumber() {
        homeSauceDemoPage = PageGenerator.getHomeSauceDemoPageObject(getDriver());
        homeSauceDemoPage.goToHomePage();
        Assert.assertTrue(homeSauceDemoPage.isOnHomePage());
        homeSauceDemoPage.inputUsername(ExcelUtil.getRowData(5));
        homeSauceDemoPage.inputPassword(ExcelUtil.getRowData(5));
        homeSauceDemoPage.clickLogin();
        Assert.assertTrue(homeSauceDemoPage.isLoginFail());
    }
    @Epic("SauceDemo")
    @Feature("Login")
    @Story("Login fail")
    @Test(priority = 6)
    public void LoginWrongUsernameAndPassword() {
        homeSauceDemoPage = PageGenerator.getHomeSauceDemoPageObject(getDriver());
        homeSauceDemoPage.goToHomePage();
        Assert.assertTrue(homeSauceDemoPage.isOnHomePage());
        homeSauceDemoPage.inputUsername(ExcelUtil.getRowData(6));
        homeSauceDemoPage.inputPassword(ExcelUtil.getRowData(6));
        homeSauceDemoPage.clickLogin();
        Assert.assertTrue(homeSauceDemoPage.isLoginFail());
    }
}