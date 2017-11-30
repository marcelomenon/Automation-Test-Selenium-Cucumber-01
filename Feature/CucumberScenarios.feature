#Author: Marcelo Menon

@Feature
Feature: Web Project with functionality to buy or rent a car
	Automation Test Scenarios with Selenium Java and Cucumber

@Scenario01
Scenario Outline: Automation Test Scenario to rent a gasoline car
Given the '<brand>' and '<type>' fields completed
When I select '<year>'
	And I select the '<fuel>'
	And I select the '<market>' option
	And I click on Save
Then I validate if the message is displayed with '<brand>'  '<type>'  '<year>'  '<fuel>' and '<market>'
Examples:
    | brand   		| type 	|	year	|	fuel			|	market	|
    | Chevrolet 	| Celta |	2016	|	gasoline	|	rent		|
    | Volkswagem 	| Gol 	|	2018	|	gasoline	|	rent		|
    
@Scenario02
Scenario Outline: Automation Test Scenario to buy an alcohol car
Given the '<brand>' and '<type>' fields completed
When I select '<year>'
	And I select the '<fuel>'
	And I select the '<market>' option
	And I click on Save
Then I validate if the message is displayed with '<brand>'  '<type>'  '<year>'  '<fuel>' and '<market>'
Examples:
    | brand   		| type 	|	year	|	fuel			|	market	|
    | Fiat			 	| Palio |	2016	|	alcohol		|	buy			|
    | Nissan		 	| Versa |	2018	|	alcohol		|	buy			|