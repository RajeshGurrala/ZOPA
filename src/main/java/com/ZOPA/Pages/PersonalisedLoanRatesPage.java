package com.ZOPA.Pages;

import com.ZOPA.Support.ElementUtils;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by RajeshG on 29/10/2017.
 */
public class PersonalisedLoanRatesPage {

    private final String TEXT_ON_PERSONALISED_LOAN_RATES_PAGE = "//h2[contains(text(),'About you')]";
    private final String EMAIL_FIELD = "member_email";
    private final String FIRST_NAME = "applications_loan_apply_first_name";
    private final String LAST_NAME = "applications_loan_apply_last_name";
    private final String PHONE = "applications_loan_apply_home_phone";
    private final String BIRTH_DAY = "date_of_birth_day";
    private final String BIRTH_MONTH = "date_of_birth_month";
    private final String YEAR_OF_BIRTH = "date_of_birth_year";
    private final String SHOW_MORE_REASONS_FOR_LOAN = "//span[text()='Show']";
    private final String ADDRESS_POSTCODE = "address_postcode";
    private final String LOOKUP_ADDRESS_BUTTON = "//input[@value='Look up address']";
    private final String CLICK_THE_FIRST_ADDRESS_FROM_INDEX = "//select[@id='address_possible_address']/option[1]";
    private final String MOVE_IN_MONTH = "address_from_2i";
    private final String MOVE_IN_YEAR = "address_from_1i";
    private final String CHOOSE_ADDRESS = "//input[@value='Use this address']";
    private final String SALARY_FIELD = "applications_loan_apply_salary";
    private final String RENT_FIELD = "applications_loan_apply_rent";
    private final String PASSWORD_FIELD = "member_password";
    private final String SHOW_PASSWORD_FIELD = "//label[contains(text(),'Show password')]";
    private final String OUT_RIGHT_OWNER_RADIO_BUTTON = "//label[contains(text(),'Yes, outright owner')]";
    private final String TEXT_ON_MONTHLY_RENTAL_CONTRIBUTION_FIELD = "//label[contains(text(),'Your monthly contribution to')]";


    ElementUtils utils = new ElementUtils();

    public void assertPersonalisedLoanPage() throws InterruptedException {
        utils.verifyStringMatch(By.xpath(TEXT_ON_PERSONALISED_LOAN_RATES_PAGE), "About you");
    }

    public String randomPrefix() {
        String[] prefix = {"Mr", "Ms", "Miss", "Mrs"};
        Random random = new Random();
        String randomPick = prefix[random.nextInt(prefix.length)];
        return randomPick;
    }

    public String randomReason() {
        String[] reason = {"Credit cards", "Boat", "Business", "Caravan", "Christmas expenses", "Stocks and shares"};
        Random random = new Random();
        String randomReason = reason[random.nextInt(reason.length)];
        return randomReason;
    }

    public String randomPostCode() {
        String[] postCode = {"N22 5NP", "GU14 9JX", "GU22 9DY", "N22 5PG", "TW9 1AJ"};
        Random random = new Random();
        String randomPostCode = postCode[random.nextInt(postCode.length)];
        return randomPostCode;
    }

    public String randomEmploymentStatus() {
        String[] employmentStatus = {"Employed full-time", "Self employed", "Employed part-time", "Retired, not working", "Housewife, househusband or homemaker"};
        Random random = new Random();
        String randomEmploymentStatus = employmentStatus[random.nextInt(employmentStatus.length)];
        return randomEmploymentStatus;
    }

    public String randomHomeStatus() {
        String[] homeStatus = {"Yes, with a mortgage", "No"};
        Random random = new Random();
        String randomHomeStatus = homeStatus[random.nextInt(homeStatus.length)];
        return randomHomeStatus;

    }

    public Date yearOfBirth() {
        Date birthYear = new Date();
        Calendar currentYear = Calendar.getInstance();
        currentYear.setTime(birthYear);
        currentYear.add(Calendar.YEAR, -21);
        birthYear = currentYear.getTime();
        return birthYear;
    }


    public void populateAboutYou() throws InterruptedException {
        utils.sendText(By.id(EMAIL_FIELD), "" + utils.randomName() + "@GMAIL.COM");
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//label[text()='" + randomPrefix() + "']"));
        utils.sendText(By.id(FIRST_NAME), utils.randomName());
        utils.sendText(By.id(LAST_NAME), utils.randomName());
        utils.sendText(By.id(PHONE), utils.randomNumber(11));
        utils.sendText(By.id(BIRTH_DAY), "10");
        utils.sendText(By.id(BIRTH_MONTH), "10");
        String year = new SimpleDateFormat("YYYY").format(yearOfBirth());
        utils.sendText(By.id(YEAR_OF_BIRTH), year);
        utils.clickBtn(By.xpath(SHOW_MORE_REASONS_FOR_LOAN));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//label[text()='" + randomReason() + "']"));
    }

    public void populateAddressHistory() {
        utils.sendText(By.id(ADDRESS_POSTCODE), randomPostCode());
        utils.clickBtn(By.xpath(LOOKUP_ADDRESS_BUTTON));
        utils.clickBtn(By.xpath(CLICK_THE_FIRST_ADDRESS_FROM_INDEX));
        utils.selectByIndex(By.id(MOVE_IN_MONTH), 1);
        utils.selectByIndex(By.id(MOVE_IN_YEAR), 1);
        utils.clickBtn(By.xpath(CHOOSE_ADDRESS));
    }

    public void financialDetails() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//label[contains(text(),'" + randomEmploymentStatus() + "')]"));
        utils.sendText(By.id(SALARY_FIELD), "100000");
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'You have entered £100,000.')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//label[contains(text(),'" + randomHomeStatus() + "')]"));
        utils.sendText(By.id(RENT_FIELD), "800");
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'You have entered £800.')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(OUT_RIGHT_OWNER_RADIO_BUTTON));
        utils.searchAndAssertTextNotPresent(By.xpath(TEXT_ON_MONTHLY_RENTAL_CONTRIBUTION_FIELD), "Your monthly contribution to");
        utils.sendText(By.id(PASSWORD_FIELD), "Z" + utils.randomName() + "" + utils.randomNumber(3) + "");
        utils.clickBtn(By.xpath(SHOW_PASSWORD_FIELD));


    }
}
