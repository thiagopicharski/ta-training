Narrative:
As an user
I want to access a cart API where I can handle products, calculate total value and shipment costs.

Scenario: Add a product to the cart
Given a cart
When I add a product with '$id' to the cart
Then I should see the product on the cart

Examples:
|id          |
|200         |