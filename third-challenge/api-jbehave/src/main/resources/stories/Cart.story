Narrative:
As an user
I want to add and remove items from a cart

Scenario: Add item to cart

Given no cart
When I add '$product'
Then I should get a cart with a '$product' in it
Examples:
| product |
| { "description": "string", "id": 0, "value": 0, "weight": 0 } |
