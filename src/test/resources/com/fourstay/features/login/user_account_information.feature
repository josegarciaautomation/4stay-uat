Feature: Display correct user information
	As I user, when I login to 4stay,
	I should be able to see my personal
	information displayed
	
@dbtest	
Scenario Outline: Verify user information from the UI with the database
	Given I am on the fourstay homepage
	And I click Login link
	When I login with email "<email>" and password "password"
#	Then information for "<email>" should match the database records
	Then information for "<email>" should match the provided records
	Examples: 
	|email                   |
	|stvance@maileme101.com  |
#	|meghart@maileme101.com  |
#	|unaoliver@maileme101.com|
#	|stallan@maileme101.com  |
	|gglover@maileme101.com  |


#Scenario Outline: do sth
#	Then LIST YOUR STAY <expected> display
#	|expected  |
#	|should    |	
#	|should not|
