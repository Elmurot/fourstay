Feature: Multiple users login tests

Scenario: Login as a test user
	Given the user is on the FourStay homepage
	And the user signs in using "sking@testmail.com" and "password"
	When the user goes to the user general settings page
	Then the user full name should be "Steven" "King"
	And the user phone number should be "5151234567"
	And the user email should be "sking@testmail.com"

@runThis
Scenario Outline: Login using multiple users
	Given the user is on the FourStay homepage
	And the user signs in using "<email>" and "<password>"
	When the user goes to the user general settings page
	Then the user full name should be "<first name>" "<last name>"
	And the user phone number should be "<phonenumber>"
	And the user email should be "<email>"
	
	Examples:
	|first name | last name | email 	                | phonenumber | password |
	|Steven    | King        | sking@testmail.com    | 5151234567 |  password |
	|Diana     | Lorentz     | dlorentz@testmail.com | 5904235567 |  password |
	|David     | Austin      | daustin@testmail.com  | 5904234569 |  password |
	|Ismael    | Sciarra     | isciarra@testmail.com | 5151244369 |	 password |
	|Irene     | Mikkilineni | imikkili@testmail.com | 6501241224 |  password |
	|Julia     | Nayer       | jnayer@testmail.com	| 6501241214 |  password |
	|Shelley   | Higgins	     | shiggins@testmail.com | 5151238080 |  password |
	|Anthony   | Cabrio      | acabrio@testmail.com  | 6505094876 |  password |
	|Randall   | Perkins     | rperkins@testmail.com | 6505054876 |  password |
	|Donald    | OConnell    | doconnel@testmail.com | 6505079833 |  password |


Scenario: Number of beds
	Given the user is on the FourStay homepage
	Then bed options should have the following entries:
		| 1 Bed  |
		| 2 Beds |
		| 3 Beds |
		| 4 Beds |
		| 5 Beds |
		| 6 Beds |
		| More   |
		
@runit
Scenario: Verify user information
	Given the user is on the FourStay homepage
	When the user signs in using "sking@testmail.com" and "password"
	Then the user information should be displayed on general settings page 
		|firstName | lastName     | email 	             | phoneNumber | 
		|Steven    | 	           | sking@testmail.com     | 5151234567 | 
		|Stev      | Shmiing        | sking@stmail.com       | 5151223567 |
	
	