Narrative:
As an user
I want to access a cart API where I can handle products, calculate total value and shipment costs.

Scenario: See carts
Given I am on cart controller
When I request the list of carts
Then I should receive a list of carts

Scenario: See cart by id
Given I am on cart controller
When I request a cart 'id'
Then I should receive a single cart
Examples:
|id
|1

Scenario: Add product to the cart
Given I am on cart controller
When I set the product's description to 'description'
And I set the product's id to 'id'
And I set the product's value to 'value'
And I set the product's weight to 'weight'
And I add the product to cart
Then I should not see any error
Examples:
|description         |id |value  |weight
|productDescription  |1  |5      |10