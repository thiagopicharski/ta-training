Narrative:
As an user
I want to handle heros on the hero store

Scenario: Add a hero to store

Given I am on a product store with model 'loadTemplate(product)'
When I request the product with the '$id'
And I patch the product with the '$id' with '$description' and '$weight' and '$value'

Examples:
|id|description|weight|value|
|2|another product|3.0|4.0|