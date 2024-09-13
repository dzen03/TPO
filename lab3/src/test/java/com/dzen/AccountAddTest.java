package com.dzen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static com.dzen.LoginTests.login;
import static com.dzen.Utils.*;

public class AccountAddTest {
    @ParameterizedTest
    @MethodSource("generateData")
    public void addAccountTest(WebDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[@data-test-id='global-nav-account-button']"));

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//div[text()='Social accounts and teams']"))).click();

        tryClicking(driver, new By.ByXPath("//button[@data-tracking-action='add_social_network']"));

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//button[.//span[text()='Pinterest']]"))).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Social account setup still in progress')]")));

        driver.quit();
    }

    static Stream<Arguments> generateData() {
        return Utils.generateData();
    }
}
