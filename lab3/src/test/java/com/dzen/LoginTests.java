package com.dzen;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dzen.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests
{
    @Test
    public void loginLogoutTest() {
        WebDriver driver = initDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login(driver, driverWait);

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Welcome')]")));

        logout(driver, driverWait);

        assertTrue(driver.getCurrentUrl().endsWith("logged-out"));

        driver.quit();
    }

    public static void login(WebDriver driver, WebDriverWait driverWait) {
        openAndCookies(driver);

        tryClicking(driver, new By.ByLinkText("Log in"));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ById("loginEmailInput"))).sendKeys(System.getenv("EMAIL"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ById("loginPasswordInput"))).sendKeys(System.getenv("PASSWORD"));

        waitLoad(driver);

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ById("loginPasswordInput"))).sendKeys(Keys.ENTER);
    }

    public static void logout(WebDriver driver, WebDriverWait driverWait) {
        tryClicking(driver, new By.ByXPath("//button[@data-test-id='global-nav-account-button']"));

        tryClicking(driver, new By.ByXPath("//button[.//p[text()='Sign out']]"));
    }
}
