Narrative: As an user I want to be able to search Netshoes for a product

Scenario: Product searched must be in the cart

Given I open netshoes page
And I search for the '$product'
When I click on the product
Then I add the product to my cart

Examples:
|    product     |
|    mochila     |