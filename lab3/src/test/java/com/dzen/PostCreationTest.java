package com.dzen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static com.dzen.LoginTests.login;
import static com.dzen.Utils.*;

public class PostCreationTest {
    @ParameterizedTest
    @MethodSource("generateData")
    public void postCreationTest(WebDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[.//div[text()='Create a post']]"));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//div[@class='DraftEditor-editorContainer']"))).click();
        new Actions(driver).sendKeys("test").perform();

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//button[.//div[text()='Save as draft']]"))).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Success!')]")));

        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void scheduledPostCreationTest(WebDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[.//div[text()='Create a post']]"));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//div[@class='DraftEditor-editorContainer']"))).click();
        new Actions(driver).sendKeys("scheduled test").perform();

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//div[@aria-label='Toggle Dialog']/span/div[@role='button']"))).click();

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//button[.//div[text()='Save as draft']]"))).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Success!')]")));

        driver.quit();
    }

    static Stream<Arguments> generateData() {
        return Utils.generateData();
    }
}
