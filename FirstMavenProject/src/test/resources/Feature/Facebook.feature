Feature: Login into the app

Background: 
Given User provides the url to launch the web page

Scenario: Launch the facebook url with valid credentials
#Given User provides the url to launch the web page
When User enters the valid username and valid password

Scenario Outline: Launch the facebook url with invalid credantials
When User enter the invalid "<username>" and "<password>" 

Examples:
|username|password|, 
|helloghhgc@gmail.com|sjahjse|

