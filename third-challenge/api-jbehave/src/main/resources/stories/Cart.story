Narrative: As an user, I want to access a cart API where I can handle products, calculate total value and shipment costs.

Scenario: the user must to add products to a new cart

Given The user dont have a cart
When The user adds a 'product' to the new cart
Then the user must see the product 'description' in the cart
And The user must see the id of the cart

Examples:

|product|description|
|{"description": "socks" , "id": 1, "value":17,"weight": 1  }           |socks|

Scenario: The user must add a product to an existent cart

Given a cart with 'products'
When the user add a new 'product' to the cart
Then the user must see the new product 'description' in the cart

Examples:

|products|product|description|
|["{ \"description\": \"apple\", \"id\": 1, \"value\": 6, \"weight\": 5 }", "{ \"description\": \"lemon\", \"id\": 1, \"value\": 9, \"weight\": 3 }"]|{"description": "socks" , "id": 1, "value":17,"weight": 1  }           |socks              |


Scenario: The user needs to remove a product from the cart

Given a cart with 'products'
When the user removes a product from the cart
Then the 'amount' of products in the cart must have one less product

Examples:

|products|amount|
|["{ \"description\": \"apple\", \"id\": 1, \"value\": 6, \"weight\": 5 }", "{ \"description\": \"lemon\", \"id\": 1, \"value\": 9, \"weight\": 3 }"] |1|


Scenario: the user wants to check the products in the cart

Given a cart with 'products'
When the user check the cart for the total of products
Then the user must see 'total' of products in the cart

Examples:

|products|total|
|["{ \"description\": \"apple\", \"id\": 1, \"value\": 6, \"weight\": 5 }", "{ \"description\": \"lemon\", \"id\": 1, \"value\": 9, \"weight\": 3 }"]   |2|


Scenario: the user wants to check the shipping cost

Given a cart with 'products'
When the user inform his 'adress' to check the total cost of shippment
Then the price must be iquals to 'cost'
And the weight must be iquals to 'weight'

Examples:

|products|adress|cost|weight|
|["{ \"description\": \"apple\", \"id\": 1, \"value\": 6, \"weight\": 5 }", "{ \"description\": \"lemon\", \"id\": 1, \"value\": 9, \"weight\": 3 }"] | {"cep":"80730-350", "serviceType":"SEDEX_VAREJO"}     |9       | 41.6  |


Scenario: The user wants to see the product details by id

Given a product with 'id'
When the user want to see the product details
Then the product description must be equals to 'description'
And the product weight should be equals to 'expectedWeight'
And the product value should be equals to 'expectedValue'

Examples:

|id|description|expectedWeight|expectedValue|
|481|apple|5|6|