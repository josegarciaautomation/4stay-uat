Feature: Search options


Scenario: verify number of beds
	Given I am on the fourstay homepage
	When I click on the beds dropdown list
	Then I should see the following bed options
		| 1 Bed |
		| 2 Beds|
		| 3 Beds|
		| 4 Beds|
		| 5 Beds|
		| 6 Beds|
		| More  |
		

Scenario Outline: Guest-LoginButton Disabled with incorrect email format
	Given I am on the fourstay homepage
	And I click Login link
	When I enter email "<email>" and password "<password>"
	Then login button should disabled
	
	Examples: 
	|email        | pass    |
#	|good@mail.com|asdfasdf |
	|bademail.com |asdfasdf |
#	|bademail.com@|asdfasdf |
#	|@bademail.com|asdfasdf |
	
	@homepage
Scenario: Login negative test
	Given I am on the fourstay homepage
	And I click Login link
	When I enter user information:
		|email					 |password|firstName|
		|testguestuserb@zain.site|password|John     |
		|a@zain.site             |password|Johnny 1 |
		|b@zain.site             |password|Johnny 2 |
	Then I should see "ZZZ zzz" message
	
	