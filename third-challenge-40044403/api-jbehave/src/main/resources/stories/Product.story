Narrative:
As an user
I want to access a cart API where I can handle products, calculate total value and shipment costs.

Scenario: Create a cart with a product
Given a '$product'
When I create a cart and put a product
Then I should see the response with a product of '$price' in the cart

Examples:
| price || product |
| 100   || { "description": "shoes", "id": 0, "value": 100, "weight": 1 } |

Scenario: Remove a product in the cart
Given a '$product' in the cart
When I delete the product
Then I should see the response without product
Examples:
| product |
| { "description": "shoes", "id": 0, "value": 100, "weight": 1 } |