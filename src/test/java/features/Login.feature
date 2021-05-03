Feature: Application Login

Scenario: Login with valid email and password

Given User is in landing page
When user enters valid email "Yanzee" and password "123"
Then user should redirect to Dashboard 
And user can view different features "true"
