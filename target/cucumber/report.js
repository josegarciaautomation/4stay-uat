$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/fourstay/features/login/fourStayNegativeLogin.feature");
formatter.feature({
  "line": 2,
  "name": "FourStay login with invalid credentials",
  "description": "\n3. As a Guest, I should see login button disabled when I enter incorrect email format\n4. As a Guest, I should see login button disabled when I enter email is blank\n5. As a Guest, I should see login button disabled when I enter password is blank\n6. As a Guest, I should be able to see an error message when I try to login with a wrong email\n7. As a Guest, I should be able to see an error message when I try to login with a wrong password\n9. As a Host, I should be able to see an error message when I try to login with a wrong email\n10. As a Host, I should be able to see an error message when I try to login with a wrong password",
  "id": "fourstay-login-with-invalid-credentials",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.before({
  "duration": 1656812141,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Guest Error massage with wrong email",
  "description": "",
  "id": "fourstay-login-with-invalid-credentials;guest-error-massage-with-wrong-email",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 30,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 32,
  "name": "I am on the fourstay homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 33,
  "name": "I click Login link",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I login with email \"testguestuserb@yahoo.com\" and password \"password\"",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "I should see \"Something went wrong\" message",
  "keyword": "Then "
});
formatter.match({
  "location": "FourStayLoginSteps.i_am_on_the_fourstay_homepage()"
});
formatter.result({
  "duration": 3698272129,
  "status": "passed"
});
formatter.match({
  "location": "FourStayLoginSteps.i_click_Login_link()"
});
formatter.result({
  "duration": 80154537,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testguestuserb@yahoo.com",
      "offset": 20
    },
    {
      "val": "password",
      "offset": 60
    }
  ],
  "location": "FourStayNegativeLoginSteps.i_login_with_email_and_password(String,String)"
});
formatter.result({
  "duration": 681425822,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Something went wrong",
      "offset": 14
    }
  ],
  "location": "FourStayLoginSteps.i_should_see_message(String)"
});
formatter.result({
  "duration": 813293848,
  "status": "passed"
});
formatter.after({
  "duration": 141236858,
  "status": "passed"
});
});