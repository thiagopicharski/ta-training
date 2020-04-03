Narrative:
As an cotumer
I want to search an item on Netshoes
So that I can add it to cart and calculate shipping fees

Scenario: User must be able add item do netshoes cart
Given the customer access the NetShoes home page
Then I should see the search bar
When I search for product mochila 3 stripes
When I click on search button
When I click the 3 product
When I click buy
When I search for zip code 80410180
When I click search zip
Then I should see calculated shipping fee
