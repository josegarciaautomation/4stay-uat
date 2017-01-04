$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/fourstay/features/login/fourStayPositiveLogin.feature");
formatter.feature({
  "line": 2,
  "name": "4stay login with valid credentials",
  "description": "\nAs a Guest, I should be able to log into the system with correct credentials\nAs a Host, I should be able to log into the system with correct credentials",
  "id": "4stay-login-with-valid-credentials",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.before({
  "duration": 2471854171,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "I am on the fourstay homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I click Login link",
  "keyword": "And "
});
formatter.match({
  "location": "FourStayLoginSteps.i_am_on_the_fourstay_homepage()"
});
formatter.result({
  "duration": 4573117262,
  "status": "passed"
});
formatter.match({
  "location": "FourStayLoginSteps.i_click_Login_link()"
});
formatter.result({
  "duration": 139432820,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Guest logs in with correct credentials",
  "description": "",
  "id": "4stay-login-with-valid-credentials;guest-logs-in-with-correct-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@Smoke"
    },
    {
      "line": 11,
      "name": "@Logintest"
    },
    {
      "line": 11,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I enter \"guest\" credentials",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I should see \"Stewart Vance\" message",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "guest",
      "offset": 9
    }
  ],
  "location": "FourStayLoginSteps.i_enter_credentials(String)"
});
formatter.result({
  "duration": 961201323,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stewart Vance",
      "offset": 14
    }
  ],
  "location": "FourStayLoginSteps.i_should_see_message(String)"
});
formatter.result({
  "duration": 10096153680,
  "error_message": "java.lang.AssertionError: Partial Text not displayed: Stewart Vance-\u003eElement not found\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat com.fourstay.utilities.Browser.verifyPartialText(Browser.java:40)\n\tat com.fourstay.step_definitions.FourStayLoginSteps.i_should_see_message(FourStayLoginSteps.java:74)\n\tat ✽.Then I should see \"Stewart Vance\" message(com/fourstay/features/login/fourStayPositiveLogin.feature:14)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("URL at failure: http://fourstay.herokuapp.com/");
formatter.after({
  "duration": 2100527792,
  "status": "passed"
});
});