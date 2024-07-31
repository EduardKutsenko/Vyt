package com.vyt.pageObjects;

import com.vyt.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_Page extends BaseClass {
    WebDriver driver;

    public Login_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#id")
    @CacheLookup
    private WebElement inputUserName;

    @FindBy(css = "#pw")
    @CacheLookup
    private WebElement inputPassword;

    @FindBy(css = ".login-text")
    @CacheLookup
    private WebElement btnLogin;

    @FindBy(linkText = "/voyant/main/login")
    @CacheLookup
    private WebElement lnkCantLogIn;

    @FindBy(css = "/voyant")
    @CacheLookup
    private WebElement lnkCreateAccount;


    public void loginWithUserNameAndPassword(String name, String pass){
        wait.until(ExpectedConditions.visibilityOf(inputUserName));
        inputUserName.sendKeys(name);
        inputPassword.sendKeys(pass);
        clickElement("Login button", btnLogin);
    }


    public void clickLogin(){
         clickElement("Login button", btnLogin);
     }


}
