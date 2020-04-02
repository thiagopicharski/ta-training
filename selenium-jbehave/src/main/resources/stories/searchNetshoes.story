Narrative:
As an user
I want to search on google
So that I can acquire knowledge

Scenario: User must be able to search in google
Given I searched on Netshoes for '$search'
When I search for 'search'
And I select the fist result
And I click on add produtc to cart
Then I should see the url 'message'
Examples:
|search |message                                      |
|smartwatches|https://www.netshoes.com.br/relogio-smartwatch-fitgear-fusion-preto-NTX-0004-006|
|bolsa|https://www.netshoes.com.br/bolsa-nike-brasilia-xs-duff-90-25-litros-preto+branco-HZM-1711-026|