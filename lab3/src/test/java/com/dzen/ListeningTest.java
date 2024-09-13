package com.dzen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static com.dzen.LoginTests.login;
import static com.dzen.Utils.*;

public class ListeningTest {
    @ParameterizedTest
    @MethodSource("generateData")
    public void listeningTest(WebDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        login(driver, driverWait);

        waitLoad(driver);
        tryClicking(driver, new By.ByXPath("//button[@aria-label='Social listening - monitor mentions and trends']"));

        waitLoad(driver);

        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(new By.ByXPath("//iframe[@title='talkwalker-listening']")));

        driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//code[@title='Search for a brand, topic or person']"))).click();

        new Actions(driver).sendKeys("#FREEDUROV" + Keys.ENTER).perform();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//*[contains(text(), 'Quick Search')]")));

        driver.quit();
    }

    static Stream<Arguments> generateData() {
        return Utils.generateData();
    }
}
