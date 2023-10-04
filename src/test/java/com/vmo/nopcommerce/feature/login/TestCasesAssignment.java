package com.vmo.nopcommerce.feature.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.pageobject.*;
import com.vmo.nopcommerce.utils.DataUtils;
import com.vmo.nopcommerce.utils.excelutils.ExcelUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)
public class TestCasesAssignment extends BaseTest {
    private String email;
    protected HomePageObject homePage;
    protected RegisterPageObject registerPage;
    protected SearchPageObject searchPage;
    protected ComputersPageObject computersPage;
    protected SoftwarePageObject softwarePage;
    protected LoginPageObject loginPage;
    protected PasswordRecoveryPageObject passwordRecoveryPage;
    protected YopMailPageObject yopMailPage;
    protected NewsPageObject newsPage;
    protected FacebookPageObject facebookPage;
    protected HomeSauceDemoPageObject homeSauceDemoPage;
    public WebDriver driver;

    @BeforeMethod
    public void setUp(@Optional("H_CHROME") String browser) {
        driver = getBrowserDriver(browser);
        ExcelUtil.setExcelFileSheet("Test data");
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
    }

    @DataProvider(name = "UsernamePassword")
    public Object[][] getDataFromExcel() {
        return new Object[][]
                {
                        {ExcelUtil.getRowData(1), ExcelUtil.getRowData(2), ExcelUtil.getRowData(3)}
                };
    }

    @Test(priority = 1, dataProvider = "UsernamePassword")
    public void Login() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        loginPage = homePage.goToLogin();
        Assert.assertTrue(loginPage.verifyIsOnLoginPage());
    }
}
