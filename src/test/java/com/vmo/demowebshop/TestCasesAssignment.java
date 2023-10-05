package com.vmo.demowebshop;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.TestNGListener;
import com.vmo.demowebshop.pageobject.*;
import com.vmo.demowebshop.utils.excelutils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)
public class TestCasesAssignment extends BaseTest {
    private String email;
    protected HomePageObject homePage;
    protected LoginPageObject loginPage;
    protected BooksPageObject booksPage;
    public WebDriver driver;

    @BeforeMethod
    public void setUp(@Optional("CHROME") String browser) {
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
    @Test(priority = 2)
    public void Buy2HighestRatedBooks(){
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        booksPage = homePage.goToBooksPage();
        Assert.assertTrue(booksPage.isOnBooksPage());
        booksPage.addThe1stHighestRatingProduct();
        Assert.assertTrue(booksPage.isMsgAddProductDisplayed("The product has been added to your ","shopping cart"));
        booksPage.addThe2ndHighestRatingProduct();
        Assert.assertTrue(booksPage.isMsgAddProductDisplayed("The product has been added to your ","shopping cart"));
        Assert.assertTrue(booksPage.isShoppingCartIncreaseTheAmount("2"));
        booksPage.hoverToShoppingCart();
    }
    @Test(priority = 3)
    public void RemoveItemsOutOfShoppingCart(){
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        homePage.add1stItem();
        homePage.add2ndItem();
        homePage.add3rdItem();
    }
}
