package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.NewsPageUI;
import org.openqa.selenium.WebDriver;

public class NewsPageObject extends BasePage {
    public WebDriver driver;
    public NewsPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isArticleDisplayed(String title){
        Log.allure("verify article is displayed: "+title);
        return isElementDisplay(driver,NewsPageUI.NEWS_TITLE,title);
    }
    public boolean isCommentSuccess(){
        Log.allure("verify comment successfully");
        return isElementDisplay(driver,NewsPageUI.MSG_COMMENT_SUCCESS);
    }
    public void inputTitle(String title){
        sendKeyToElement(driver,NewsPageUI.INPUT_TITLE,title);
        Log.allure("input title");
    }
    public void inputComment(String comment){
        sendKeyToElement(driver,NewsPageUI.INPUT_COMMENT,comment);
        Log.allure("input comment");
    }
    public void clickAddComment(){
        clickToElement(driver,NewsPageUI.COMMENT_BTN);
        Log.allure("click button Add Comment");
    }
}
