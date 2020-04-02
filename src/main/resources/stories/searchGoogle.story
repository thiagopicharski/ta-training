Narrative:
As an user I want to be able to search Mercado Livre for a product
Add this product to my cart
Verify that the product is indeed in the cart

Scenario: User must search an item on mercado livre and add a product to his cart

Given I am on netshoes
When I search for '<search>'
And click on search button
When I click on the product '<whatIGet>'
And add to my cart
Then I should see the message '<msg>'
Examples:
|search   |whatIGet                           |msg                                      |
|relogio  |Relógio Smartwatch FitGear Fusion  |Relógio Smartwatch FitGear Fusion - Preto|
