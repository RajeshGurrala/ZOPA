$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/ZOPA/FeatureFiles/GetQuote.feature");
formatter.feature({
  "line": 2,
  "name": "getQuote",
  "description": "",
  "id": "getquote",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@GetQuote"
    }
  ]
});
formatter.before({
  "duration": 6053550685,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "User should be able to provide all the valid details before getting a quote",
  "description": "",
  "id": "getquote;user-should-be-able-to-provide-all-the-valid-details-before-getting-a-quote",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "The user is on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "He navigates to the get_loan page and provides the amount and term time",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "He should be directed to a secured link where he would be able to provide his personal details",
  "keyword": "Then "
});
formatter.match({
  "location": "GetQuote_stepDefs.theUserIsOnTheHomePage()"
});
formatter.result({
  "duration": 74771724,
  "status": "passed"
});
formatter.match({
  "location": "GetQuote_stepDefs.heNavigatesToTheGet_loanPageAndProvidesTheAmountAndTermTime()"
});
formatter.result({
  "duration": 3310019815,
  "status": "passed"
});
formatter.match({
  "location": "GetQuote_stepDefs.heShouldBeDirectedToASecuredLinkWhereHeWouldBeAbleToProvideHisPersonalDetails()"
});
formatter.result({
  "duration": 11473376046,
  "status": "passed"
});
formatter.after({
  "duration": 969497890,
  "status": "passed"
});
});