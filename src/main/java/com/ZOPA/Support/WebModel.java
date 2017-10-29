package com.ZOPA.Support;

import com.ZOPA.Pages.HomePage;
import com.ZOPA.Pages.LoansPage;
import com.ZOPA.Pages.PersonalisedLoanRatesPage;

/**
 * Created by raj on 28/10/2017.
 */
public class WebModel {

    private HomePage homePage;
    private LoansPage loansPage;
    private PersonalisedLoanRatesPage personalisedLoanRatesPage;


    public WebModel() {
        homePage = new HomePage();
        loansPage = new LoansPage();
        personalisedLoanRatesPage = new PersonalisedLoanRatesPage();
    }

    public HomePage getHomePage() {
        return homePage;

    }

    public LoansPage loansPage() {
        return loansPage;
    }

    public PersonalisedLoanRatesPage getPersonalisedLoanRatesPage() {
        return personalisedLoanRatesPage;
    }


}
