package com.vyt.pageObjects.insurance;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Page extends BaseClass {
    WebDriver driver;

    public Insurance_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@data-test-model-category='termLifeInsurance']")
    private WebElement btnTerm_Life;


    public void clickTermLifeButton(){
        clickElement("Term Life button", btnTerm_Life);
    }





}
