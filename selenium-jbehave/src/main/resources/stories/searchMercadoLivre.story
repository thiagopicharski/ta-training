Narrative:
As an user I want to be able to search mercadoLivre for a product
Add this product to my cart
Verify that the product is indeed in the cart

Scenario: User must be able to search in mercado livre
Given I am on mercado livre page
When I search for 'search'
And I click on search button
And I click on the first result
And I add to the cart
Then I should see the 'product' added in cart
Examples:
|search |product                                    	             |
|Pimenta|Kit Mais Fortes Do Mundo Carolina,scorpion,bhut Macerada 100|
