
Narrative:
As an user
I want to insert a product in my cart
So that I may buy it

Scenario:
Given I am at the Netshoes homepage
When I search for '<prod>' at the searchbar
And I click on search button
And I click on the product
Then I add it to my cart and verify it


Examples:
|prod          |
|Espada tai chi|
