package com.vyt.pageObjects.insurance;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TermLife_Page extends BaseClass {
    WebDriver driver;

    public TermLife_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id= "termLifeName")
    private WebElement inputPolicyName;

    @FindBy(id= "termLifeInsuranceEmploymentId")
    private WebElement inputLinkedEmployment;

    @FindBy(xpath= "//button[@aria-label = 'Done']")
    private WebElement btnDone;

    public void setForm(String name, String employment){
        wait.until(ExpectedConditions.visibilityOf(inputPolicyName));
        inputPolicyName.clear();
        inputPolicyName.sendKeys(name);

        Select select = new Select(inputLinkedEmployment);
        select.selectByVisibleText(employment);
        sleep(1);
        clickElement("Done button", btnDone);
    }


    //public void clickDoneButton(){
       // clickElement("Done button", btnDone);
   // }


}
