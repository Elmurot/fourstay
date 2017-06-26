@uptake
Feature: Uptake homepage and contact page 

	Scenario: User homepage and contact 
		When user goes to uptake homepage
		Then user clicks on contact button
		And user should be able to see contact page
		And user navigates back
		Then user should see uptake homepage