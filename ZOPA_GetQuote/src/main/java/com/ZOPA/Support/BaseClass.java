package com.ZOPA.Support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by raj on 28/10/2017.
 */
public class BaseClass {

    public static WebDriver driver;
    ElementUtils utils=new ElementUtils();

    @Before
    public void startUp() {
        try {
            driver = utils.browser();
            driver.get(utils.getProperty("url"));
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
             utils.captureScreenShot(scenario.getName());
        }
        driver.close();
        driver.quit();
    }
}
