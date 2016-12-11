@Regression
Feature: FourStay login with invalid credentials

3. As a Guest, I should see login button disabled when I enter incorrect email format
4. As a Guest, I should see login button disabled when I enter email is blank
5. As a Guest, I should see login button disabled when I enter password is blank
6. As a Guest, I should be able to see an error message when I try to login with a wrong email
7. As a Guest, I should be able to see an error message when I try to login with a wrong password
9. As a Host, I should be able to see an error message when I try to login with a wrong email
10. As a Host, I should be able to see an error message when I try to login with a wrong password


Scenario: Guest-LoginButton Disabled with incorrect email format
	Given I am on the fourstay homepage
	Then I click Login link
	When I enter email "testguestuserb#zain.site" and password "password"
	Then login button should disabled

Scenario: Guest-LoginButton Disabled with blank email
	Given I am on the fourstay homepage
	Then I click Login link
	When I enter email "" and password "password"
	Then login button should disabled
	
Scenario: Guest-LoginButton Disabled with blank password
	Given I am on the fourstay homepage
	Then I click Login link
	When I enter email "testguestuserb@zain.site" and password ""
	Then login button should disabled
@Test	
Scenario: Guest Error massage with wrong email
	Given I am on the fourstay homepage
	Then I click Login link
	When I login with email "testguestuserb@yahoo.com" and password "password"
	Then I should see "Something went wrong" message