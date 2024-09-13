package com.dzen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static com.dzen.Utils.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests
{
    @ParameterizedTest
    @MethodSource("generateData")
    public void loginLogoutTest(WebDriver driver){
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

    static Stream<Arguments> generateData() {
        return Utils.generateData();
    }
}
