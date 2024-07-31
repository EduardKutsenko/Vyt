package com.vyt.pageObjects;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Clients_Page extends BaseClass {
    WebDriver driver;

    public Clients_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Close']")
    private List<WebElement> listBtnCloseReleaseNotes;


    @FindBy(className = "add-button")
    private WebElement btnAdd;


    public String getPageTitle() {
        wait.until(ExpectedConditions.titleIs("Clients"));
        return driver.getTitle();
    }


    public void closeReleaseNotes(){
        sleep(2);
        if(listBtnCloseReleaseNotes.size() > 0)
            clickElement("Closing Release Notes", listBtnCloseReleaseNotes.get(0));
        log.info("Closing Release Notes");
    }


    public void clickAddButton(){

        btnAdd.click();
        btnAdd.sendKeys(Keys.ENTER);
    clickElement("Add button", btnAdd);
    }




}
