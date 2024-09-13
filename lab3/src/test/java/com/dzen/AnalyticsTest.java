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

public class AnalyticsTest {
    @ParameterizedTest
    @MethodSource("generateData")
    public void analyticsTest(WebDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[@aria-label='Analytics - analyse social media performance']"));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'YouTube overview')]")));

        driver.quit();
    }

    static Stream<Arguments> generateData() {
        return Utils.generateData();
    }
}
