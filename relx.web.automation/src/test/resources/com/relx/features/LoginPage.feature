Feature: Login page feature

Scenario: Login with correct credentials
Given user is on login page
When user enters username "standard_user"
And user enters password "secret_sauce"
And user clicks on Login button
And user navigates to homepage with header 'PRODUCTS'