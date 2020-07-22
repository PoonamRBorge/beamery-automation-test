#Author: Poonam Borge
# Take Home Exercise


Feature: Registration process
  This feature will test the registration process.

Scenario Outline: Create and register an account
    Given I am on the home page
    And I click on the sign in
    And I create an account using an email address:<email>
    And I am on the registration form page
    When I fill up the mandatory details title:<title>, firstName:<firstName>, lastName:<lastName>, password:<password>, address:<address>, city:<city>, state:<state>, zip:<zip>, country:<country>, mobile:<mobile>, aliasAddr:<aliasAddr>
    And I click on Register
    Then The registration is <status>
 Examples: 
      |	email										| title	| firstName | lastName		| password	| address			| city  		| state  		| zip  	| country  			| mobile  		| aliasAddr |	status			|
      |	NameEmailAddr3@xyz.com	|	Mrs 	| TestFirst	|	TestLast		|	abcd1234	|	Wintergreen	|	New York	|	New York	|	12345	|	United States	|	1234567890	|	My Addr		|	successful	|
      |	NameEmailAddr4@xyz.com	| Mr		| 					|	TestSecLast	|	efgh1234	|	Boulevard		|	New York	|	New York	|	12345	|	United States	|	4321567890	|	My Addr		| failed			|	
      
Scenario: Create an account with an existing email address
    Given I am on the home page
    When I click on the sign in
    And I create an account using an email address:nameEmail@xyz.com 
    Then The user is not created		 