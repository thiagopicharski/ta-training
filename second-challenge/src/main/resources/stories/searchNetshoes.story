Narrative:
As an user
I want to be able to search Netshoes for a product
So that I add the product to the cart

Scenario: The user must be able to search Netshoes for a product, add to the cart and view the item in the cart
Given I am on Netshoes Home Page
When I search for '$product'
And I click on search button
When I click the first product
And I add the product to the cart
Then I check if the product is in the cart
Examples:
|product |
|meia    |