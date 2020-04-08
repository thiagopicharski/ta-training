Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: I want to create a cart with a product
Given a product '$product'
When I call PUT on the cart endpoint
Then response contains cart with product with '$price'
Examples:
|price | product |
|1000  | {"description": "refrigerator", "id": 0, "value": 1000, "weight": 0}

Scenario: Remove item from cart
Given a cart with '$product'
When I call delete on cart
Then response contains cart without product
Examples:
|price | product |
|1000 | {"description": "refrigerator", "id": 0, "value": 1000, "weight": 0}


