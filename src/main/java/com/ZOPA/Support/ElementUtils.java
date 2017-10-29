package com.ZOPA.Support;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import static com.ZOPA.Support.BaseClass.driver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by raj on 28/10/2017.
 */
public class ElementUtils {


    private Properties prop;
    private FileInputStream fileInputStream;



    public Wait waitForSomeTime() {
        Wait wait = new FluentWait(BaseClass.driver)
                .withTimeout(20, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(WebDriverException.class);
        return wait;
    }
    public void sendText(By by, String txt) {
        waitForSomeTime().until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(txt);
    }

    public void clickBtn(By by) {
        waitForSomeTime().until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(element));
        element.click();}


    public void verifyStringMatch(By by, String expectedString) {
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, expectedString));
        String actualString = driver.findElement(by).getText();
        assertEquals(expectedString, actualString);
    }
    public void verifyStringContent(By by, String expectedString) {
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, expectedString));
        String actualString = driver.findElement(by).getText();
        assertTrue(actualString.contains(expectedString));
    }

    public void assertURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    public WebDriver browser() {
            if (getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "DriverFiles\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (getProperty("browser").equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "DriverFiles\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
        }
        return driver;
    }
    public String getProperty(String key) {

        try {
            prop = new Properties();
            fileInputStream = new FileInputStream("src\\test\\resources\\com\\ZOPA\\config.properties");
            prop.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
    public void captureScreenShot(String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/" + screenShotName + ".png"));
        System.out.println("screenShot taken");
    }
    public String randomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public int provideNumberLessThan6andGreaterThan0(){
        Random random = new Random();
        int  number = random.nextInt(5) + 1;
        return number;
    }
    public void javaScriptExecutorClick(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public String randomName() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public void selectByIndex(By by, int number) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }
    public void searchAndAssertTextNotPresent(By by, String searchText) {
        String actualText = driver.findElement(by).getText();
        assertFalse(actualText.contains(searchText));
    }
    public void waitForElementVisible(By by)  {
        waitForSomeTime().until(ExpectedConditions.presenceOfElementLocated(by));}






}
