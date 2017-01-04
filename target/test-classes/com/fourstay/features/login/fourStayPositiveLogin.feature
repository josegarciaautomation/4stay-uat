@Regression
Feature: 4stay login with valid credentials

As a Guest, I should be able to log into the system with correct credentials
As a Host, I should be able to log into the system with correct credentials

Background:
	Given I am on the fourstay homepage
	And I click Login link

@Smoke @Logintest @Test
Scenario: Guest logs in with correct credentials
	When I enter "guest" credentials
	Then I should see "Stewart Vance" message
	
@Smoke @Logintest
Scenario: Host logs in with correct credentials
	When I enter "host" credentials
	Then I should see "ZZZ zzz" message