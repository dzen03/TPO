package com.dzen;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    static String URL = "https://hootsuite.com/";
    static String DASHBOARD_URL = "https://hootsuite.com/dashboard";

    public static WebDriver initFirefoxDriver() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver initChromeDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver initSafariDriver() {
        SafariDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initDriver() {
        return initChromeDriver();
    }

    public static void openAndCookies(WebDriver driver) {
        driver.get(URL);
        tryClicking(driver, new By.ByXPath("//button[text()='Accept All Cookies']"));
    }

    public static void waitLoad(WebDriver driver) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public static void tryClicking(WebDriver driver, By by) {
        while (true) {
            try {
                WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                driverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
                break;
            }
            catch (org.openqa.selenium.ElementNotInteractableException ignored) {}
        }
    }
}