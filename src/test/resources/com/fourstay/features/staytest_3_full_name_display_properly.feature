@st_3
Feature: Full name not displayed properly
	
	Scenario: Verify name display as host
		Given the user is on the FourStay sign up dialog
		And the user enters enter first name "John" and last name "Smith"
		And the user enters any unregistered email and password 
		When click on the Sign up button
		Then first name "John" and last name "Smith" should be displayed
	
	Scenario: Verify name display as guest
		Given the user is on the FourStay sign up dialog
		And the user enters enter first name "John" and last name "Smith"
		And the user clicks on the guest radio button
		And the user enters any unregistered email and password 
		When click on the Sign up button
		Then first name "John" and last name "Smith " should be displayed