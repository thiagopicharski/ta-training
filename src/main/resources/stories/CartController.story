Narrative:
As an user
I want to handle my cart and prodcuts in the store

Meta:
Scenario: Get the list of products
Given I am on a store with model 'loadTemplate(product)'
Then I get the list of products

Scenario: Verify if product with with a description is present
Given I am on a store with model 'loadTemplate(product)'
Given I add a product to the store with description Fortunato, value 1234 and weight 130
Then I verify if the product with description Fortunato has been added

Scenario: Verify if cart with an id is present
Given I am on a store with model 'loadTemplate(product)'
Then I verify if the cart with id 1998 has been added

Scenario: Verify if cart with an id is present and add a product to cart
Given I am on a store with model 'loadTemplate(product)'
Given the cart with id 1998 is present
Then I add a product with description Fortunato, value 1234 and weight 130 to the cart with id 1998


Scenario: Verify if product inside cart with id can be removed
Given I am on a store with model 'loadTemplate(product)'
Given the cart with id 2558 is present
Then Then I delete the product with id 2559 inside cart with id 2558

Scenario: I remove everything modified in the api
Given I am on a store with model 'loadTemplate(product)'
Then I remove everything with description Fortunato
