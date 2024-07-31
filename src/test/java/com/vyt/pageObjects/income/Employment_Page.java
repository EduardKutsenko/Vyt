package com.vyt.pageObjects.income;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Employment_Page extends BaseClass {
    WebDriver driver;

    public Employment_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id= "employmentInputName")
    private WebElement inputEmploymentName;

    @FindBy(id= "employmentInputSalary")
    private WebElement inputEmploymentSalary;

    @FindBy(xpath= "//button[@aria-label = 'Done']")
    private WebElement btnDone;

    public void setEmploymentName(String name){
        wait.until(ExpectedConditions.visibilityOf(inputEmploymentName));
        inputEmploymentName.clear();
        inputEmploymentName.sendKeys(name);
    }

    public void setSalary(String amount){
        inputEmploymentSalary.clear();
        sleep(2);
        inputEmploymentSalary.sendKeys(amount);


    }
    public void clickDoneButton(){
        clickElement("Done button", btnDone);
    }


}
