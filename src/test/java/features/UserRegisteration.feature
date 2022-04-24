Feature: User Registeration
i want to check that the user can register in our website 

Scenario Outline: user registeration
Given the user is in the home page 
When the user clicks on the register link 
And the user enters "<firstname>","<lastname>","<email>","<password>"
Then the registeration page should be displlayed successfully

Examples:
|firstname|lastname|email|password|
|ahmed|samir|ahmed1@test.com|123456|
|khaled|walid|khaled1@test.com|123456789|
|shady|hussin|shady1@test.com|123456|