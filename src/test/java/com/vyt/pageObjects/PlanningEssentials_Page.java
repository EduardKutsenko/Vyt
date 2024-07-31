package com.vyt.pageObjects;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlanningEssentials_Page extends BaseClass {
    WebDriver driver;

    public PlanningEssentials_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@data-test-model-type='goals']")
    private WebElement btnGoals;
    @FindBy(xpath = "//button[@data-test-model-type='income']")
    private WebElement btnIncome;

    @FindBy(xpath = "//button[@data-test-model-type='protection']")
    private WebElement btnInsurance;


    public void clickGoalsButton(){
        clickElement("Goals button", btnGoals);
    }

    public void clickIncomeButton(){
        clickElement("Income button", btnIncome);
    }

    public void clickInsuranceButton(){
        clickElement("Insurance button", btnInsurance);
    }

}
