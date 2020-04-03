Narrative:
As an user
I want to search on google
So that I can acquire knowledge

Scenario: User must be able to search in google
Given I am on NetShoes page
When I search for 'search'
And I click on search button
When I click on the first product
Then Click on buy
And the product should be on cart

Examples:
|search |
|Mochila|
