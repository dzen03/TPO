package com.dzen;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dzen.LoginTests.login;
import static com.dzen.Utils.*;

public class AnalyticsTest {
    @Test
    public void analyticsTest(){
        WebDriver driver = initDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[@aria-label='Analytics - analyse social media performance']"));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'YouTube overview')]")));

        driver.quit();
    }
}
