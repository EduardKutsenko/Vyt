package com.vyt.pageObjects;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewClient_Page extends BaseClass {
    WebDriver driver;

    public NewClient_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "newInputFirst")
    private WebElement inputFirstName;

    @FindBy(id = "newInputLast")
    private WebElement inputLastName;

    @FindBy(id = "birthYear")
    private WebElement inputBirthY;

    @FindBy(xpath = "//input[@aria-label = 'Plan Start Date: MM Month']")
    private WebElement inputMonth;

    @FindBy(xpath = "//input[@aria-label = 'Plan Start Date: DD Day']")
    private WebElement inputDay;

    @FindBy(id = "alreadyRetiredDropdown")
    private WebElement drpdAlreadyRetired;

    @FindBy(id = "retirementAge")
    private WebElement inputRetAge;

    @FindBy(xpath = "//button[@aria-label = 'Done']")
    private WebElement btnDone;


    public void fillInForm(String name, String last_name, String birthYear, String psdMonth,
                           String psdDay, String retired, String age){
        wait.until(ExpectedConditions.elementToBeClickable(inputFirstName));

        typeText("text entered in the name field", inputFirstName, "");
        inputFirstName.sendKeys(name);
        inputLastName.sendKeys(last_name);
        inputBirthY.sendKeys(birthYear);
        inputMonth.clear();
        inputDay.clear();
        inputMonth.sendKeys(psdMonth);
        inputDay.sendKeys(psdDay);
        Select dropdn = new Select(drpdAlreadyRetired);
        dropdn.selectByVisibleText(retired);
        inputRetAge.clear();
        inputRetAge.sendKeys(age);
        clickElement("button Done",  btnDone);

    }






}
