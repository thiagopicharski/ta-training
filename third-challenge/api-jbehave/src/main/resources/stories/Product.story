Scenario: I want to add products

Given A product 'loadTemplate(product)'
When I set product description to 'A product'
And I set product value to '20.00'
And I set product weight to '3.0'
And I add the product to the cart
Then I should not see any error
