package com.vmo.nopcommerce.feature.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.pageobject.*;
import com.vmo.nopcommerce.utils.DataUtils;
import com.vmo.nopcommerce.utils.excelutils.ExcelUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)
public class TestCasesNopCommerce extends BaseTest {
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

    @Parameters({"browser","runType"})
    @BeforeMethod
    public void setUp(@Optional("H_CHROME") String browser,@Optional("CHROME") String runType) {
        driver = getBrowserDriver(browser,runType);
        ExcelUtil.setExcelFileSheet("data");
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
    }

    @Epic("Nopcommerce")
    @Feature("Registration")
    @Story("Registration successful")
    @Test(priority = 1)
    public void UserRegistration() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        registerPage = homePage.goToRegisterPage();
        Assert.assertTrue(registerPage.verifyIsOnRegisterPage());
        registerPage.selectMale();
        registerPage.inputFirstName("Thai");
        registerPage.inputLastName("Ngo");
        registerPage.selectDay("1");
        registerPage.selectMonth("1");
        registerPage.selectYear("1");
        email = DataUtils.generateEmail();
        registerPage.inputEmail(email);
        registerPage.inputPW("4Youonly4");
        registerPage.inputPWConfirm("4Youonly4");
        registerPage.clickRegister();
        Assert.assertTrue(registerPage.verifyRegisterSuccessful());
    }

    @Epic("Nopcommerce")
    @Feature("Product search")
    @Story("Display msg when search")
    @Test(priority = 2)
    public void ProductSearch() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        homePage.inputSearchProduct("Nokia");
        searchPage = homePage.clickSearchButton();
        Assert.assertTrue(searchPage.verifySearchProduct("Nokia", "No products were found that matched your criteria."));
    }

    @Epic("Nopcommerce")
    @Feature("Sort product")
    @Story("Sorting product successful")
    @Test(priority = 3)
    public void ProductSortingAndFiltering() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        computersPage = homePage.goToComputers();
        softwarePage = computersPage.goToSoftware();
        Assert.assertTrue(softwarePage.verifyIsOnSoftwarePage());
        softwarePage.clickSortDropDown();
        Assert.assertTrue(softwarePage.verifyOptionZToAIsDisplayed());
        softwarePage.selectSort("Name: Z to A");
        softwarePage.waitUntilLoading();
        Assert.assertTrue(softwarePage.verifyProductIsDisplayedFromZToA());
    }
    @Epic("Nopcommerce")
    @Feature("Password recovery")
    @Story("Password recovery and receive email successful")
    @Test(priority = 4)
    public void PasswordRecovery() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        homePage.waitUntilLogin();
        loginPage = homePage.goToLogin();
        Assert.assertTrue(loginPage.verifyIsOnLoginPage());
        passwordRecoveryPage = loginPage.goToPasswordRecovery();
        Assert.assertTrue(passwordRecoveryPage.verifyIsOnPasswordRecoveryPage());
        passwordRecoveryPage.inputEmail(email);
        passwordRecoveryPage.clickRecover();
        Assert.assertEquals(passwordRecoveryPage.verifyMsgEmailSentSuccess(), "Email with instructions has been sent to you.");
        passwordRecoveryPage.openANewTab();
        yopMailPage = new YopMailPageObject(getDriver());
        yopMailPage.goToYopMail();
        yopMailPage.inputEmail(email);
        yopMailPage.closeOtherTabs();
    }
    @Epic("Nopcommerce")
    @Feature("News")
    @Story("Leave comment successful")
    @Test(priority = 5)
    public void ReadNewsAndLeaveComment() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        newsPage = homePage.clickOnNews("New online store is open!");
        Assert.assertTrue(newsPage.isArticleDisplayed("New online store is open!"));
        newsPage.inputTitle("Online Store is great");
        newsPage.inputComment("I can't wait to try shopping");
        newsPage.clickAddComment();
        Assert.assertTrue(newsPage.isCommentSuccess());
    }
    @Epic("Nopcommerce")
    @Feature("Change currency")
    @Story("Currency symbol is correct")
    @Test(priority = 6)
    public void ChangeExchange() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        String selectedCurrency = homePage.selectCurrency();
        Assert.assertTrue(homePage.isCurrentCurrencyCorrect(selectedCurrency));
        Assert.assertTrue(homePage.isCurrencySymbolCorrect());
    }
    @Epic("Nopcommerce")
    @Feature("Footer")
    @Story("Open social media button successful")
    @Test(priority = 7)
    public void ClickOnOneOfTheSocialMedia() {
        homePage = PageGenerator.getHomePageObject(getDriver());
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isOnHomePage());
        homePage.clickFacebook();
        facebookPage = homePage.switchToFacebookTab();
        facebookPage.waitForTitle();
        Assert.assertTrue(facebookPage.isTitleCorrect("NopCommerce | Facebook"));
    }
}
