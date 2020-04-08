Narrative:
As an user
I want to search on Netshoes for a product
So that I can buy this product

Scenario: User must be able to search in netshoes
Given I open netshoes page
And I search for '$product'
When I click on the product
Then 'I add the product to my cart'

Examples:
|product |
|meia    |


