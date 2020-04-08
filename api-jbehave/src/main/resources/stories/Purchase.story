Narrative:
As an user
I want to add and remove items from a cart

Scenario: Adding products to a cart
Given an empty cart
When I add a'$prod' to the cart
Then the cart should have one product inside
Examples:
| prod |
| { "description": "game console", "id": 64, "value": 1200, "weight": 4 } |

Scenario: Remove a product from the cart
Given a cart filled with products which their ids are '$prodIds'
When I remove a product with the following '$id' from the cart
Then the cart no long contain the product with '$id'
Examples:
| n | prodIds |
| 2 | 2, 5, 7    |

Scenario: Create cart with new products then remove one
Given a new cart with the following products '$prod'
When I remove the first element from the cart
Then the cart needs to have one less element
Examples:
| prod |
| ["{ \"description\": \"game console\", \"id\": 64, \"value\": 1200, \"weight\": 4 }", "{ \"description\": \"game cartidge\", \"id\": 89, \"value\": 150, \"weight\": 1 }" ] |

Scenario: Calculate cart total
Given a new cart with the following products '$prod'
When I proceed to checkout
Then the total amount should be '$total'
Examples:
|total | prod |
| 5 | ["{ \"description\": \"game console\", \"id\": 64, \"value\": 1200, \"weight\": 4 }", "{ \"description\": \"game cartidge\", \"id\": 89, \"value\": 150, \"weight\": 1 }" ] |

Scenario: Calculate shipping
Given a new cart with the following products '$prod'
When I receive the shipment value through '$shipment'
Then the shipment cost should correspond to the weight '$weight'
Examples:
|weight | shipment | prod |
|5 | {"cep":"81920-060", "serviceType":"SEDEX_VAREJO"} | ["{ \"description\": \"game console\", \"id\": 64, \"value\": 1200, \"weight\": 4 }", "{ \"description\": \"game cartidge\", \"id\": 89, \"value\": 150, \"weight\": 1 }" ] |