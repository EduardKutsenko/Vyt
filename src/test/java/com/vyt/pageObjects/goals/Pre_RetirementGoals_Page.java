package com.vyt.pageObjects.goals;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class Pre_RetirementGoals_Page extends BaseClass {
    WebDriver driver;

    public Pre_RetirementGoals_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id= "basicExpenseInputAmount")
    private WebElement inputAmount;

    @FindBy(xpath= "//button[@aria-label = 'Done']")
    private WebElement btnDone;

    public void setAmount(String amount){
        wait.until(ExpectedConditions.visibilityOf(inputAmount));
        inputAmount.clear();

        clickElement("", inputAmount);
        inputAmount.sendKeys(amount);

    }
    public void clickDoneButton(){
        clickElement("Done button", btnDone);
    }




}
