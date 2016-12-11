@Regression
Feature: 4stay login with valid credentials

As a Guest, I should be able to log into the system with correct credentials
As a Host, I should be able to log into the system with correct credentials


Scenario: Guest logs in with correct credentials
	Given I am on the fourstay homepage
	And I click Login link
	When I enter "guest" credentials
	Then I should see "TestGuest UserB" message

Scenario: Host logs in with correct credentials
	Given I am on the fourstay homepage
	And I click Login link
	When I enter "host" credentials
	Then I should see "ZZZ zzz" message