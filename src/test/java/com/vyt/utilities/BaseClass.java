package com.vyt.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;


public class BaseClass {
    public static String baseURL = "https://ca-test.planwithvoyant.com/advisergo";

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger log;
    ExtentReports extentReports;

    private static ExtentTest test;


    @BeforeTest
    public void setup() {
        driver = SetupWebDriver.getWebDriver();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.waitTimeout));
        driver.manage().window().maximize();
        log= LogManager.getLogger(BaseClass.class);

//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(htmlReporter);
//        test = extentReports.createTest("loginWithValidCredential", "first_test");
        Reporter.log("Setup completed");
        log.info("Setup completed");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @AfterMethod
    public void failureSetup(ITestResult result) throws IOException {
        Reporter.setCurrentTestResult(result);
        File img = new File(System.getProperty("user.dir")+"/screen_"+result.getMethod().getMethodName()+".png");

        if(result.getStatus() == 2){
            Reporter.log("Test Case failed", true);

            FileOutputStream screenshotStream = new FileOutputStream(img);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();

            Reporter.log(" <a href='"+img.getAbsolutePath()+"'> <img src='"+ img.getAbsolutePath()+"' height='200' width='200'/> </a>  ");
        }
    }


    public void clickElement(String name, WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", locator);
        LoggerLoad.info("Webelement " + name + " has been clicked");
        Reporter.log("Webelement " + name + " has been clicked");
    }

    public void typeText(String name, WebElement locator, String text) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='"+ text +"';", locator);
        log.info("The following text is entered: " + text);
        Reporter.log("The following text is entered: " + text);
    }

    public void assertEqual(String actual, String expected){
        Assert.assertEquals(actual, expected);
        String methodName = new Throwable().getStackTrace()[1].getMethodName();
        log.info("Test case " + methodName +   " passed successfully");
        Reporter.log("Test case " + methodName +   " passed successfully");
    }

    public void assertTrue(boolean condition){
        Assert.assertTrue(condition);
        String methodName = new Throwable().getStackTrace()[1].getMethodName();
        log.info("Test case " + methodName +   " passed successfully");
        Reporter.log("Test case " + methodName +   " passed successfully");
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

}

}
