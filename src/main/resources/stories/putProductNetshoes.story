Narrative:
As an user I want to be able to search Mercado Livre for a product
Add this product to my cart
Verify that the product is indeed in the cart

Scenario: User must be able to add a product in cart on Mercado Livre
Given I'm on Netshoes home page
When I search for '$search'
And I click on search button
And I click on the first product
And I add it to cart
Then I should see the selected product in cart
Examples:
|search|
|bola|