Narrative:
As an user,
I want to access a cart API where I can handle products, calculate total value and shipment costs.

Scenario: I will add a product to the cart


given A product in the API 
when  I  add a product  to the  cart
then I  should see the product in the cart


Scenario: Remove product to cart

Given a product in the cart
When I remove the  product to  the cart
Then  I get the cart empty


Scenario: Update the cart

Given a product in the cart
When I update the product 
Then I changed the cart



As an user,
I want to calculate values of the products inside the cart 

Scenario: Calculate the value of the products.

Given A product inside the cart
When I Want calculate values of the products 
Then I see the value of the products.



As an a user
I want to verify if is possible, calculate value of the shipment costs

Scenario: calculate value of the shipment costs

Given a couple products inside the cart
When I see the address of the client,
And I calculate value of the shipment costs
Then I see the value of the shipment costs


