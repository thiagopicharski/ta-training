Narrative:
As an user
I want to handle heros on the hero store

Scenario: Get the list of products

Given I am on a store with model 'loadTemplate(product)'
Then I get the list of products

Scenario: Verify if product with an id is present

Given I am on a store with model 'loadTemplate(product)'
Given I add a product to the store with description Fortunato, value 1234 and weight 130
Then I verify if the product with description Fortunato has been added
