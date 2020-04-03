Narrative:
As an user I want to be able to search Netshoes for a product
Add this product to my cart
Verify that the product is indeed in the cart

Scenario: User must be able to search in google
Given I am on Netshoes page
When I search for '$search'
And I click on search button
And I click on the first result
And I choose the size
And I click on buy button
And I click on the cart
Then I should see the item on cart
Examples:
|search         |
|tenis masculino|