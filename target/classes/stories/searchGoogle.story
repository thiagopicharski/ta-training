Narrative:
As an user
I want to search for a football boot in Net Shoes
So that I can acquire a Nike

Scenario: User must be able to search in google
Given I am on NetShoes page
And I search for '<search>'
When I click on search button
And I click on first shoe
And I add it to cart
Then I should see if '<product>' is there

Examples:
|search         |product                                        |
|Gorro          |Gorro Beanie Brohood Canelado Masculino        |
