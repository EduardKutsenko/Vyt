package com.vyt.pageObjects;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Dashboard_Page extends BaseClass {
    WebDriver driver;

    public Dashboard_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@aria-label='Add an account, person or timing item to your plan.']")
    private WebElement btnAddAccount;

    @FindBy(xpath = "//div[@id='accordion']//span[@class='help-wrapper-yield']")
    private List<WebElement> listEssentials;



    public void clickAddButton(){
      sleep(2);
        clickElement("Add Planning Essentials button", btnAddAccount);
    }

    public boolean isListContainsValue(String value){
        wait.until(ExpectedConditions.visibilityOfAllElements(listEssentials));
        for (WebElement i:listEssentials) {
            if(i.getText().trim().equals(value))
                return true;
        }
        return false;


    }




}
