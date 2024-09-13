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

public class ListeningTest {
    @Test
    public void listeningTest(){
        WebDriver driver = initDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[@aria-label='Social listening - monitor mentions and trends']"));

        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(new By.ByXPath("//iframe[@title='talkwalker-listening']")));

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector(".match-braces"))).click();

        new Actions(driver).sendKeys("#FREEDUROV" + Keys.ENTER).perform();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Quick Search')]")));

        driver.quit();
    }
}
