package com.wikipediatest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected static WebDriver driver;

    public static WebDriver launchTestWithSpecificDriver(String specificDriver) {

        switch (specificDriver) {
            case "chromedriver":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addArguments("enable-automation");
                chromeoptions.addArguments("--no-sandbox");
                chromeoptions.addArguments("--disable-infobars");
                chromeoptions.addArguments("--disable-dev-shm-usage");
                chromeoptions.addArguments("--disable-browser-side-navigation");
                chromeoptions.addArguments("--disable-gpu");
                chromeoptions.addArguments("--disable-cookies");
                driver = new ChromeDriver(chromeoptions);
                break;
            case "firefoxdriver":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                firefoxoptions.addArguments("enable-automation");
                firefoxoptions.addArguments("--no-sandbox");
                firefoxoptions.addArguments("--disable-infobars");
                firefoxoptions.addArguments("--disable-dev-shm-usage");
                firefoxoptions.addArguments("--disable-browser-side-navigation");
                firefoxoptions.addArguments("--disable-gpu");
                driver = new FirefoxDriver(firefoxoptions);
                break;
            //TODO: Figure out why this ones wont work using WebDriverManager
//            case "operadriver"":
//                WebDriverManager.operadriver().setup();
//                TODO: set opera opera options
//                driver = new OperaDriver();
//                break;
//            case "edgedriver":
//                WebDriverManager.edgedriver().setup();
//                //TODO: set edge options
//                driver = new EdgeDriver();
//                break;
//            case "iedriver":
//                WebDriverManager.iedriver().setup();
//                //TODO: set internet explorer options
//                driver = new InternetExplorerDriver();
//                break;
            default:
                throw new IllegalStateException("Unexpected value: " + specificDriver);
        }
        return driver;
    }
}
