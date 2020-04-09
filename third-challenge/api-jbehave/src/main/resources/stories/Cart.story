Narrative:
As an user
I want to add a product

Given I a model 'loadTemplate(product)'
And a product '<product>'
And I put it on the cart
When I get the product by '<id>'
Then I want se '<result>'
Examples:
| product                                               | id | result                                                 |
| {"description":"Batata","id":1,"value":10,"weight":5} | 1  | {"description":"Batata","id": 1,"value":10,"weight":5} |