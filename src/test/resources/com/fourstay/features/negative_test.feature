Feature: Login with Invalid Inputs

#As a user, i should get an error messag ewhen i login with blank first name 

@test
Scenario: Register with empty inputs
	
	Given User is on homepage
	And I click on "Need to Register" link
	Then I register with wrong information and I should see proper message
	|email					 | pwd 			| firstName | lastName | company 	| errorMessage | companyType |
	|something else@gmail.com | blaa bla 		| 			| bla - bla | bla-bla | bla-bla 	|  	   |
	|   anotheremail 					| bla -bla      |     sfdg  | last name | bla -bla  |  
	