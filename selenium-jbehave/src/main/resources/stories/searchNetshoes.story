Narrative:
As an user I want to go to Netshoes website, add a product in the cart and check that it's in there

Scenario: User must be able to add product to cart in Netshoes website and check if it was added successfully
Given I'm in Netshoes website
When I search for '<search>'
And I click on search button
And I click in the first result of the search '<searchResult>'
And then click on add to cart button
Then I should see '<addedProduct>' on items list
Examples:
|search |searchResult                                      |addedProduct                              |
|bola de futebol|Bola de Futebol Campo Adidas Starlancer VI|Bola de Futebol Campo Adidas Starlancer VI|