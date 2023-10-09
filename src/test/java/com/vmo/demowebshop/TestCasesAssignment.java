package com.vmo.demowebshop;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.helper.TestNGListener;
import com.vmo.demowebshop.pageobject.*;
import com.vmo.demowebshop.utils.DataUtils;
import com.vmo.demowebshop.utils.excelutils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)
public class TestCasesAssignment extends BaseTest {
    protected HomePageObject homePage;
    protected LoginPageObject loginPage;
    protected BooksPageObject booksPage;
    protected ShoppingCartPageObject shoppingCartPage;
    protected DigitalDownloadsPageObject digitalDownloadsPage;
    protected CheckoutPageObject checkoutPage;
    public WebDriver driver;

//    @BeforeMethod(alwaysRun = true)
//    @Parameters({"browser"})
//    public void setUp(@Optional("H_CHROME") String browser) {
//        driver = getBrowserDriver(browser);
//        ExcelUtil.setExcelFileSheet("TestData");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        cleanBrowserAndDriver();
//    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("CHROME") String browser) {
        Log.allure("Start Browser " + browser);
        driver = getBrowserDriver(browser);
    }
    @BeforeTest
    public void setTestData(){
        Log.allure("Read test data");
        ExcelUtil.setExcelFileSheet("TestData");
    }

    @Test(dataProvider = "assignment", dataProviderClass = DataUtils.class)
    public void Login(String STT, String email, String password, String expectedMessage) {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        loginPage = homePage.goToLogin();
        Assert.assertTrue(loginPage.verifyIsOnLoginPage());
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoginMessageCorrect(expectedMessage));
    }

//    @Test(priority = 2)
//    public void Buy2HighestRatedBooks() {
//        homePage = PageGenerator.getHomePageObject(getDriver());
//        homePage.goToHomePage();
//        Assert.assertTrue(homePage.isOnHomePage());
//        booksPage = homePage.goToBooksPage();
//        Assert.assertTrue(booksPage.isOnBooksPage());
//        booksPage.addThe1stHighestRatingProduct();
//        Assert.assertTrue(booksPage.isMsgAddProductDisplayed("The product has been added to your ", "shopping cart"));
//        booksPage.addThe2ndHighestRatingProduct();
//        Assert.assertTrue(booksPage.isMsgAddProductDisplayed("The product has been added to your ", "shopping cart"));
//        Assert.assertTrue(booksPage.isShoppingCartIncreaseTheAmount("2"));
//        booksPage.hoverToShoppingCart();
//    }
//
//    @Test(priority = 3)
//    public void RemoveItemsOutOfShoppingCart() {
//        homePage = PageGenerator.getHomePageObject(getDriver());
//        homePage.goToHomePage();
//        Assert.assertTrue(homePage.isOnHomePage());
//        homePage.addItem("14.1-inch Laptop");
//        Assert.assertTrue(homePage.isMsgAddProductDisplayed("The product has been added to your ", "shopping cart"));
//        homePage.addItem("Build your own cheap computer");
//        homePage.clickAddToCart2ndItem();
//        Assert.assertTrue(homePage.isMsgAddProductDisplayed("The product has been added to your ", "shopping cart"));
//        homePage.goToHomePage();
//        homePage.addItem("Build your own computer");
//        homePage.selectHDDOption("320 GB ");
//        homePage.clickAddToCart3rdItem();
//        Assert.assertTrue(homePage.isMsgAddProductDisplayed("The product has been added to your ", "shopping cart"));
//        Assert.assertTrue(homePage.verifyShoppingCartAmount("3"));
//        homePage.scrollToTop();
//        shoppingCartPage = homePage.goToShoppingCart();
//        shoppingCartPage.isOnShoppingCartPage();
//        shoppingCartPage.selectItem("14.1-inch Laptop");
//        shoppingCartPage.clickUpdateCart();
//        Assert.assertTrue(shoppingCartPage.isItemUndisplayed("14.1-inch Laptop"));
//        Assert.assertTrue(homePage.verifyShoppingCartAmount("2"));
//    }
//
//    @Test(priority = 4)
//    public void BuyItemSuccessfully() {
//        homePage = PageGenerator.getHomePageObject(getDriver());
//        homePage.goToHomePage();
//        Assert.assertTrue(homePage.isOnHomePage());
//        digitalDownloadsPage = homePage.goToDigitalDownloadsPage();
//        Assert.assertTrue(digitalDownloadsPage.isOnDigitalDownloadsPage());
//        digitalDownloadsPage.clickAddToCart("3rd Album");
//        Assert.assertTrue(digitalDownloadsPage.isMsgAddProductDisplayed("The product has been added to your ", "shopping cart"));
//        Assert.assertTrue(digitalDownloadsPage.verifyShoppingCartAmount("1"));
//        shoppingCartPage = digitalDownloadsPage.goToShoppingCart();
//        shoppingCartPage.isOnShoppingCartPage();
//        shoppingCartPage.agreeTermsOfService();
//        shoppingCartPage.verifyTermsOfServiceIsChecked();
//        checkoutPage = shoppingCartPage.clickCheckout();
//        Assert.assertTrue(checkoutPage.isOnCheckoutPage());
//        checkoutPage.clickCheckoutAsGuest();
//        Assert.assertTrue(checkoutPage.isOnOnePageCheckoutPage());
//        Assert.assertTrue(checkoutPage.isBillingAddressTabExpand());
//        checkoutPage.inputFirstName("Thai");
//        checkoutPage.inputLastName("Ngo");
//        checkoutPage.inputEmail("thai@gmail.com");
//        checkoutPage.selectCountry("Viet Nam");
//        checkoutPage.inputCity("Ha Noi");
//        checkoutPage.inputAddress1("Dinh Cong");
//        checkoutPage.inputZipPostal("10000");
//        checkoutPage.inputPhone("0392921517");
//        checkoutPage.clickContinueToPaymentMethod();
//    }
}
