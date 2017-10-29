package com.ZOPA.Pages;

import com.ZOPA.Support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 29/10/2017.
 */
public class LoansPage {


    ElementUtils utils = new ElementUtils();
    private final String TEXT_ON_LOANS_PAGE = "//h2[contains(text(),'What will you do?')]";
    private final String GET_PERSONALISED_RATES_BUTTON = "submit-loan-button";

    String xpath;

    public void assertLoansPage() {
        utils.assertURL("https://www.zopa.com/loans");
        utils.verifyStringMatch(By.xpath(TEXT_ON_LOANS_PAGE), "What will you do?");
    }

    public void chooseLoanAmount() {
        utils.sendText(By.id("amount"), utils.randomNumber(5));
    }

    public String supplyLocatorThatChoosesYearRandomly() {
        xpath = "//label[contains(text(),'" + utils.provideNumberLessThan6andGreaterThan0() + " year')]";
        return xpath;
    }

    public void chooseYear() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(supplyLocatorThatChoosesYearRandomly()));
    }

    public void navigateToPersonalisedLoanRatesPage() {
        utils.clickBtn(By.id(GET_PERSONALISED_RATES_BUTTON));
    }
}

