Feature: Account Page feature

Background:
	Given user is already logged in to application
	|username | password |
	|dec2020secondbatch@gmail.com | Selenium@12345 |
	
 Scenario: Account page title
	Given user is on account page
	When user gets the page title
	Then title of the page should be "My account - My Store"
	
Scenario: Account Section 
	Given user is on account page
	Then user gets account section
	|ORDER HISTORY AND DETAILS|
	|MY CREDIT SLIPS|
	|MY ADDRESSES|
	|MY PERSONAL INFORMATION|
	|MY WISHLISTS|
	Then user gets the count as 5
	
Scenario: Search section
 	Given user is on account page
 	When user enters valid text "shoes" in search textbox 
 	Then search result should be displayed
 	Then user clicks on search button
 	When user enters invalid text in search textbox and clicks on search button
 	Then error msg should be displayed
 	
 Scenario: Validate Category
 	Given user is on account page
 	Then user gets the categories
 	|WOMEN|
 	|DRESSES|
 	|T-SHIRTS|
 	Then count of category should be 3
 	When user mouse over on women category
 	Then women category should be displayed
 	|TOPS|
 	|DRESSES|
 	When user mouse over on dresses category
 	Then dresses category should be displayed
 	|causual dresses|
 	|summer dresses|
 	|evening dresses|
 	When user clicks on T-shirts category
 	Then title of the page should be "T-shirts - My Store"
 	

Scenario: validating sort by option
 	Given user is on account page
 	When user enters valid text "shoes" in search textbox 
 	Then search result should be displayed
 	Then user clicks on search button
 	And number of search results for that product should be displayed
 	When user selects sort by price highest first 
 	Then highest price product should be displayed first 
 	When user selects sort by  Z to A of product name
 	Then product name from Z to A should be displayed
 	
 
	

 
 	
	
	