Narrative:
As an user
I want to handle heros on the hero store

Scenario: Add a hero to store

Given I am on a product store with model 'loadTemplate(product)'
When I request the product with the '$id'
Then I should not see any error

Examples:
|id|
|2|