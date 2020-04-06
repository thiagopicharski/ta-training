Narrative:
As an user
I want to search a Whey Protein on Netshoes
So that I can put it on a shopping cart

Scenario: User must be able to search product
Given I access the Netshoes page
When I searched for '$search' on the search field
Then the first result is '$result'

Examples:
|search     |result                                        |
|Whey       |Whey Protein 100% Pure Whey 900g - Probiótica |

Scenario: User must be able to select and put into shopping cart
Given I '$search' for a product
When I click on first result
And I click in buy button
Then I should see the shopping cart page

Examples:
|search     |
|Whey       |