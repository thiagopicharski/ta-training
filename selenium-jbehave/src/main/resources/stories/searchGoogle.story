Narrative:
As an user
I want to search items and add them to my cart in MercadoLivre
So that I can make purchases

Scenario: User must be able to search item
Given I am on Mercado Livre
When I search for '$item'
And I click on search button
Then I should see first result as '$result'
Examples:
|item            |  result                                                    |
|potato          | Sr & Sra Cabeça De Batata Potato Head Toy Story 4 Hasbro   |
|plastico bolha  |  Bobina Plástico Bolha 1,30 X 100m Para Proteção - Oferta  |

Scenario: User must be able to see item page
Given I search for '$item'
When I select the first item
Then I get redirected to a page that contains add to cart button
Examples:
|item            |
|potato          |
|plastico bolha  |

Scenario: User must be able to add item to cart
Given I searched for '$item' and clicked the first result
When I add item to cart
Then I get cart contains item
Examples:
|item            |
|potato          |
|plastico bolha  |