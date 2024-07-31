package com.vyt.pageObjects.goals;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Goals_Page extends BaseClass {
    WebDriver driver;

    public Goals_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='Pre-Retirement Goal']")
    private WebElement btnPreReqGoal;


    public void clickGoalsButton(){
        clickElement("Pre-Retirement Goal button", btnPreReqGoal);
    }




}
