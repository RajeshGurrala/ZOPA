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
        webModel.getHomePage().assertHomePage();

    }

    @When("^He navigates to the get_loan page and provides the amount and term time$")
    public void heNavigatesToTheGet_loanPageAndProvidesTheAmountAndTermTime() throws InterruptedException {
        webModel.getHomePage().navigateToLoansPage();
        webModel.loansPage().assertLoansPage();
        webModel.loansPage().chooseLoanAmount();
        webModel.loansPage().chooseYear();
        webModel.loansPage().navigateToPersonalisedLoanRatesPage();

    }

    @Then("^He should be directed to a secured link where he would be able to provide his personal details$")
    public void heShouldBeDirectedToASecuredLinkWhereHeWouldBeAbleToProvideHisPersonalDetails() throws InterruptedException {
        webModel.getPersonalisedLoanRatesPage().assertPersonalisedLoadPage();
        webModel.getPersonalisedLoanRatesPage().populateAboutYou();
        webModel.getPersonalisedLoanRatesPage().populateAddressHistory();
        webModel.getPersonalisedLoanRatesPage().financialDetails();


    }
}
