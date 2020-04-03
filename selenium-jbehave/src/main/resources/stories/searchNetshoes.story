Narrative:
As an user
I want to be able to search Netshoes for a product
Add this product to my cart
Verify that the product is indeed in the cart

Scenario: User must be able to add a item to cart
Given I am on netshoes page
When I search for 'search'
And I click on search button
And I click on the first item
And Add the item to cart
Then I should see the 'item' at the cart
Examples:
|search         |item                                           |
|bolsa nike     |Bolsa Nike Brasilia Xs Duff 9.0 - 25 Litros    |