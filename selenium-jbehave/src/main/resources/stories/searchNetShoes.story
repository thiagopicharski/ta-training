Narrative:
As an user
I want to search on netshoes
So that I can buy

Scenario: User must be able to search in netshoes
Given I searched on Netshoes for '$search'
When I search for 'search'
And I select the first result
And I click on add produtc to cart
Then I should see the url 'message'
Examples:
|search |message                                      |
|mochila|https://www.netshoes.com.br/mochila-nike-brasilia-academy-team-22-litros-preto+branco-HZM-2865-026|