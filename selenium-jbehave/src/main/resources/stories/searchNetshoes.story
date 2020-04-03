Narrative:
As an user
I want to search on netshoes
So that I can buy stuff

Scenario: User must be able to search in netshoes
Given I search on netshoes for '$search'
When I search for 'search'
And I click on search button
And I click on buy button
And I click on continue
And I click on continue shopping

Examples:
|search                               |firstResult                          |
|óculos oakley fuel cell prizm iridium|Óculos Oakley Fuel Cell Prizm Iridium|
