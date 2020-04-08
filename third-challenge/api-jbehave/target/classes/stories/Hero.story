Narrative:
As an user
I want to access a cart API where I can handle products, calculate total value and shipment costs

Scenario: I want to add products
Given A product 'loadTemplate(product)'
When I set product description to 'Just a product'
And I set product value to '13.60'
And I set product weight to '2.0'
And I add the product to the cart
Then I should not see any error
