Narrative:
As an user
I want to access an APi cart, where I can handle products, calculate total value and the shipment costs.



Scenario: I want to get a cart

Given I am on the store
When I make a request to a cart with id '6'
Then I should receive the cart

Scenario: I want to get a list of cart

Given I am on the store
When I make a request to a list of carts
Then I should receive the list of carts

Scenario: I want to get a product

Given I am on the store
When I make a request to a product with id '11'
Then I should receive the product

Scenario: I want to get some products from a cart

Given I am on the store
When I request some product list that's in a cart with id '8'
Then I should see the product list




Scenario: I want to make a count of the shipment

Given Some shipment with model 'loadTemplate(shipment)'
And I set my cep to '000000000'
When I want to make a count of the total in the cart with id '25'
Then I should see the total count of the shipment




Scenario: I want to add some products to the cart

Given Some product with  model 'loadTemplate(product)'
When I set the product description to 'Is a product'
And I set the product value to '99.99'
And I set the product weight to '13.0'
And I add the product to the cart
Then I shoul see product added to the cart

Scenario: I want to add some products to the cart with an id

Given Some product with model 'loadTemplate(product)'
When I set  the product description to 'Is a product'
And I set the product value to '99.99'
And I set the product weight to '13.0'
And I add the product to the cart with the id '9'
Then I shoul see product added to the cart




Scenario: I want to delete a product from my cart

Given Some cart on the Store
When I delete the product with id '15' from my cart with id '25'
Then I should see the deleted product from the cart