Narrative:
As an user
I want to add and remove items from a cart

Scenario: Add item to cart

Given no cart
When I add '$product' to a cart's products
Then I should get a cart with a single product in it
Examples:
| product |
| { "description": "description", "id": 0, "value": 10, "weight": 10 } |
