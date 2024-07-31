package com.vyt.pageObjects.income;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Income_Page extends BaseClass {
    WebDriver driver;

    public Income_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@data-test-model-category='caEmployment']")
    private WebElement btnEmployment;


    public void clickEmploymentButton(){
        clickElement("Income button", btnEmployment);
    }





}
