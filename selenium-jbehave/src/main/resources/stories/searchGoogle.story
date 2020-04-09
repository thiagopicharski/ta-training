Narrative:
As an user
I want to search on netshoes
So that I can buy anything

Scenario: User must be able to search in google
Given I am on netshoes page
When I search for '<item>'
And I click on search button
And I select an item
And I select a size
And I click in buy
Then I want go to my bag
And I should see the item on my bag
Examples:
|item           |firstResult                                      |
|Tenis          |Ronaldo Nazário – Wikipédia, a enciclopédia livre|