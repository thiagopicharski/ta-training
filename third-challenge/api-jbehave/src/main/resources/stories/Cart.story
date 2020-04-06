Narrative:
As an user
I want to add and remove items from a cart

Scenario: Creating cart by adding a product
Given no cart
When I add '$product' to a cart's products
Then I should get a cart with a single product in it
Examples:
| product |
| { "description": "description", "id": 18, "value": 10, "weight": 10 } |

Scenario: Remove item from cart with known items
Given cart with populated with the following product ids: '$productIds'
When I remove the product with id '$id' from the cart
Then cart no longer contains product '$id'
Examples:
| n | productIds |
| 2 | 2, 5, 7    |

