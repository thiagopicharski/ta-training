Narrative:
As an user,
I want to access a cart API where I can handle products,
calculate total value and shipment costs.

Scenario: I want to add products  thea new  cart
Given i don't have a cart yet
When i want to add a 'product' to a new cart
Then i should see 'expectedDescription' in the cart
And i should see the cart id in cart list
Examples:
|product                                                                |expectedDescription|
|{"description": "socks" , "id": 1, "value":17,"weight": 1  }           |socks|


Scenario: I want to add a product to an existing cart
Given i have  a cart with products
When i  add a 'product' to a existing cart
Then i should see 'expectedDescription' in the existing cart
Examples:
|product                                                                |expectedDescription|
|{"description": "socks" , "id": 1, "value":17,"weight": 1  }           |socks              |


Scenario: I want to remove a product from the cart
Given i have  a cart with products
When i want to remove a product from the cart
Then the 'numberOfProducts' in the cart should have one less product
Examples:
|numberOfProducts|
|1               |

Scenario: I want to see all products in my cart
Given i have  a cart with products
When i  want to see all products in my cart
Then the 'numberOfProducts' in the cart should be the same as the initial cart
Examples:
|numberOfProducts|
|2               |

Scenario: I want to have a sum of all items in cart
Given i have  a cart with products
When i want to have the sum of all items
Then i should see the 'expectedSum'
Examples:
|expectedSum|
|15         |


Scenario: i want to evaluate the total weight of my shipment
Given i have  a cart with products
When i want to have the total cost  and the weight of my 'shipment'
Then the cost should be equals to 'cost'
And the weight should be equals to 'weight'
Examples:
 | shipment                                             |weight  |cost|
| {"cep":"80730-350", "serviceType":"SEDEX_VAREJO"}     |9       | 41.6  |

Scenario: Using product Id i want to  acess product details
Given I have a 'id' of a Product
When i want to see product details
Then the product description should be equals to 'expectedDescription'
And the product weight should be equals to 'expectedWeight'
And the product value should be equals to 'expectedValue'
Examples:
|id|expectedDescription|expectedWeight|expectedValue|
|481|apple             |5             |6            |






