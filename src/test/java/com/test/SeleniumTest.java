package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class SeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // These capture the parameters you set in Jenkins 
        String browser = System.getProperty("browser"); 
        String url = System.getProperty("url");         

        if (browser != null && browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Needed for Jenkins servers
            driver = new ChromeDriver(options);
        } 
        else if (browser != null && browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }

        if (url != null) {
            driver.get(url);
        }
    }

    @Test
    public void executeTest() {
        System.out.println("Page Title is: " + driver.getTitle());
        // Add your Selenium validation logic here 
    }
}
