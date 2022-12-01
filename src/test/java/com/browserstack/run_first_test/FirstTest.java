package com.browserstack.run_first_test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest extends BrowserStackTestNGTest {

    public JavascriptExecutor jse;
    @Test
    public void test() throws Exception {
        jse = (JavascriptExecutor)driver;
        System.out.println("starting test 1. . . .");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Starting Test 1 . . .\", \"level\": \"info\"}}");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Sleeping for 30000ms . . .\", \"level\": \"info\"}}");
        Thread.sleep(30000);
      AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
          ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//      searchElement.click();
//      AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//          ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//      searchElement.click();
//      List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
      Assert.assertTrue(searchElement.isDisplayed());

            if (searchElement.isDisplayed()) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
            }
            else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Results not found\"}}");
            }

    }

    @Test
    public void test2() throws Exception {
        jse = (JavascriptExecutor)driver;
        System.out.println("starting test 2. . . .");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Starting Test 2 . . .\", \"level\": \"info\"}}");
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//        searchElement.click();
//      AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//          ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//      searchElement.click();
//      List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        Assert.assertTrue(searchElement.isDisplayed());

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        if (searchElement.isDisplayed()) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Results not found\"}}");
        }

    }

    @Test
    public void test3() throws Exception {
        jse = (JavascriptExecutor)driver;
        System.out.println("starting test 3. . . .");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Starting Test 3 . . .\", \"level\": \"info\"}}");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Sleeping for 30000ms . . .\", \"level\": \"info\"}}");
        Thread.sleep(30000);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//      searchElement.click();
//      AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//          ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//      searchElement.click();
//      List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        Assert.assertTrue(searchElement.isDisplayed());

        if (searchElement.isDisplayed()) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Results not found\"}}");
        }

    }

    @Test
    public void test4() throws Exception {
        jse = (JavascriptExecutor)driver;
        System.out.println("starting test 4. . . .");
        jse.executeScript("browserstack_executor: {\"action\": \"annotate\", \"arguments\": {\"data\": \"Starting Test 4 . . .\", \"level\": \"info\"}}");
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//        searchElement.click();
//      AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//          ExpectedConditions.elementToBeClickable(MobileBy.id("com.ada.astrapayupdate:id/btnLogin")));
//      searchElement.click();
//      List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        Assert.assertTrue(searchElement.isDisplayed());

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        if (searchElement.isDisplayed()) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Results not found\"}}");
        }

    }
}
