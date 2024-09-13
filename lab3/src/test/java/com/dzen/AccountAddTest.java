package com.dzen;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dzen.LoginTests.login;
import static com.dzen.Utils.*;

public class AccountAddTest {
    @Test
    public void addAccountTest(){
        WebDriver driver = initDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[@data-test-id='global-nav-account-button']"));

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//div[text()='Social accounts and teams']"))).click();

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//button[@data-tracking-action='add_social_network']"))).click();

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//button[.//span[text()='Pinterest']]"))).click();
//
//        new Actions(driver).sendKeys("#FREEDUROV" + Keys.ENTER).perform();
//
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Social account setup still in progress')]")));

        driver.quit();
    }
}
