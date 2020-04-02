Narrative:
As an user
I want to search on google
So that I can acquire knowledge

Scenario: User must be able to search in NetShoes
Given I am on NetShoes home page
When I search for '$search'
And I click on search button
And I click on the first product
Then I click the buy button and add it to the cart
And I should see the product in the shopping cart
Examples:
|search |
|Mochila|