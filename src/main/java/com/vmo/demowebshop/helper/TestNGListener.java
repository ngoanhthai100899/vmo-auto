package com.vmo.demowebshop.helper;

import com.vmo.demowebshop.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("______Test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.allure("---------- " + result.getName() + " PASSED test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.allure("---------- " + result.getName() + " FAILED test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("______Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("______Finish");
    }
    @Attachment()
    public  static byte[] saveScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
