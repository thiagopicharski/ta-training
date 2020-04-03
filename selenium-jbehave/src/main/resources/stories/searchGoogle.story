Narrative:
As an user I want to be able to search Netshoes for a product
Add this product to my cart
Verify that the product is indeed in the cart

Scenario: Product searched is in the cart

Given I m in the netshoes online store
When I search in the search bar for 'product'
And I click on search button
Then I should see first result as 'firstProduct'
When I click on Product Image 
Then I get product page
When I click on buy button
Then I should add the product to cart 'finalProduct'
Examples:
|product |firstProduct                                        |
|skate   |Skate Completo OWL Sports Moon Time 50-50 32" X 7,6"|

