Narrative:
As an user,
I want to access a cart API where I can handle products, calculate total value and shipment costs.

!-- PUT METHOD

Scenario: I want to add products to the cart
Given A product model 'loadTemplate(product)'
When I set product description to 'Just a product'
And I set product value to '13.60'
And I set product weight to '2.0'
And I add the product to the cart
Then I should not see any error

Scenario: I want to add products to a cart
Given A product model 'loadTemplate(product)'
When I set product description to 'Just a product'
And I set product value to '13.60'
And I set product weight to '2.0'
And I add the product to the cart with id '1'
Then I should not see any error

!-- GET METHOD

Scenario: I want to get a cart list
Given I am on the store
When I request a list of carts
Then I should receive a list of carts

Scenario: I want to get a cart
Given I am on the store
When I request a cart with id '1'
Then I should see the cart

Scenario: I want to get products from a cart
Given I am on the store
When I request a product list in a cart with id '1'
Then I should see a product list

Scenario: I want to get a product
Given I am on the store
When I request a product with id '5'
Then I should see the product

!-- POST METHOD

Scenario: I want to calculate shipment
Given A shipment model 'loadTemplate(shipment)'
And I set my cep to '80240440'
When I want to calculate the total price in the cart with id '1'
Then I should see the total price for shipment

!-- DELETE METHOD
Scenario: I want to remove a product from my cart
Given A cart on the store
When I remove the product with id '2' from my cart with id '1'
Then I should not see any error