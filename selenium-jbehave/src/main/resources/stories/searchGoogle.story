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

