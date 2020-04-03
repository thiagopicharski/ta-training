Narrative:
As an user
I want to search on google
So that I can acquire knowledge

Scenario: User must be able to search in Netshoes
Given I searched on google for '$search'
When  I click on the search button
And   I click on the first product
And   I add this product to the cart
Then I should see first result as 'firstResult'
Examples:
|search |firstResult          |
| Bola |  product in the cart |
