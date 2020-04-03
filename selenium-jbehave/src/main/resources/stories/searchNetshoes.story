Narrative:
As an user
I want to search on Netshoes
So that I can buy a product

Scenario: User must be able to search in Netshoes
I am on Netshoes
Given I am on Netshoes
When I search for '<search>'
And I click on search button
And I click on the first product
And I should see first result as '<firstResult>'
And I should click on the product
Then I should buy the product

Examples:
|search  |firstResult     |
|meia    |Meia Olympikus Sem Cano Pacote Com 3 Masculina     |