package com.vyt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetupWebDriver {

    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            if (System.getProperty("user.dir") + "//Config//config.txt" == "chrome")
                WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

}
