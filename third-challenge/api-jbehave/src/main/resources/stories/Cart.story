Narrative:
As an user
I want to add and remove products from my cart

Scenario: Add a product to a cart

Given A product
When I add a '$product' in a cart
Then The product should be on cart
Examples:
|product|
|"{ \"description\": "Product description", \"id\": 1, \"value\": 10, \"weight\": 5 }"|

Scenario: Remove a product from a cart

Given A cart with the product id '$id'
When I remove the product id '$id'
Then The cart should be empty

Examples:
| id |
| 1  |

Scenario: Calcule the shipment of a product

Given A cart with a '$product'
When I calculate the shipment '$shipment'
Then The value should be equals to '$value'

Examples:
|product|shipment|value|
|"{ \"description\": Mochila, \"id\": 20, \"value\": 10, \"weight\": 5 }"|{"cep":"32434-110", "serviceType":"SEDEX_VAREJO"}|10|

