package com.ZOPA.StepDefs;


import com.ZOPA.Support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by raj on 28/10/2017.
 */
public class GetQuote_stepDefs {

    WebModel webModel = new WebModel();

    @Given("^The user is on the home page$")
    public void theUserIsOnTheHomePage() {
        //this method will assert that the user is on the home page. it will assert the page URL
        webModel.getHomePage().assertHomePage();

    }

    @When("^He navigates to the get_loan page and provides the amount and term time$")
    public void heNavigatesToTheGet_loanPageAndProvidesTheAmountAndTermTime() throws InterruptedException {
        //this method will click on the 'get a zopa loan button'
        webModel.getHomePage().navigateToLoansPage();
        //this method will assert the user is on https://www.zopa.com/loans page. a text on the page is asserted
        webModel.loansPage().assertLoansPage();
        //this method will provide the loan amount and choose the desired term duration.
        // the loan amount provided is generated via random method ( JAVA random utils)
        webModel.loansPage().chooseLoanAmount();
        //the term duration is also picked in random. i.e each time a test runs a different number between 1-5 is passed
        webModel.loansPage().chooseYear();
        //this method will click 'Get my personalised rates' button
        webModel.loansPage().navigateToPersonalisedLoanRatesPage();

    }

    @Then("^He should be directed to a secured link where he would be able to provide his personal details$")
    public void heShouldBeDirectedToASecuredLinkWhereHeWouldBeAbleToProvideHisPersonalDetails() throws InterruptedException {
        //this method will assert that the flow is on the personalisedLoanPage. a text on the page is asserted
        webModel.getPersonalisedLoanRatesPage().assertPersonalisedLoanPage();
        //this method will populate fields under 'about you' label
        // email, first name, last name and phone number provided by random methods, title is selected at random
        // date and month are hard coded however year is calculated by a method that gets current year and then subtracts 21 out of it and provides the value
        //loan reason like title is selected at random for each run,
        webModel.getPersonalisedLoanRatesPage().populateAboutYou();
        //address history is populated by a method that stores few pre assigned address and provides them at random per each test execution
        //month and year are chosen by a method are provided by selectByIndex
        webModel.getPersonalisedLoanRatesPage().populateAddressHistory();
        //financial details again like title and loan reason are chosen at random per each test run
        //annual salary is provided by random method
        //for 'do you own home': initially 'either of 2nd and 3rd radio buttons are chosen at random and then a amount is provided in the field below
        //assertion of the value that is entered is performed on the string 'You have entered £xxxx.'
        //password is provided by combination of hardcoded and random alphanumerics
        webModel.getPersonalisedLoanRatesPage().financialDetails();


    }
}
