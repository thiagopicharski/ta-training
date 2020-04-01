Narrative:
As an user
I want to search on google
So that I can acquire knowledge

Scenario: User must be able to search in google
Given I searched on google for '$search'
When I search for 'search'
And I click on search button
Then I should see first result as 'firstResult'
Examples:
|search |firstResult                                      |
|Ronaldo|Ronaldo Nazário – Wikipédia, a enciclopédia livre|
|Rivaldo|Rivaldo – Wikipédia, a enciclopédia livre        |