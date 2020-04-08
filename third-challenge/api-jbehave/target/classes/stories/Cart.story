Narrative:
As an user
I want to manipulate a store cart

Scenario: Add a product to an empty cart
Given an empty cart
When I put the '$product' to a cart
Then I should have only one product on the cart
Examples:
| product |
| { "description": "frogPhone", "id": 626, "value": 100, "weight": 900 } |

Scenario: Remove item from cart with some items
Given cart with items containing product ids: '$idproducts'
When product id '$id' is removed from the cart
Then product '$id' won't be found
Examples:
| n | idproducts |
| 1 | 1, 5, 11   |

Scenario: Create cart a list of products then subtract one item
Given a cart with a list of '$products'
When I delete a product
Then cart size is subtracted
Examples:
| products |
| ["{ \"description\": \"productToDelete\", \"id\": 0, \"value\": 50, \"weight\": 400 }", "{ \"description\": \"productToSurvive\", \"id\": 0, \"value\": 250, \"weight\": 700 }" ] |

Scenario: Calculate amount price in the cart
Given a cart with a list of '$products'
When I have a cart
Then cart price amount is '$total'
Examples:
|total | products |
| 12 | ["{ \"description\": \"xilofone\", \"id\": 0, \"value\": 6, \"weight\": 80000 }", "{ \"description\": \"aipo\", \"id\": 0, \"value\": 6, \"weight\": 3 }" ] |

Scenario: Generate shipping price
Given a cart with a list of '$products'
When I call shipment method with the following '$request'
Then the total weight of the requested products is'$weight'
Examples:
|weight   | request                                           | products                                                                                                                                                                          |
|8001     | {"cep":"68440-970", "serviceType":"SEDEX_VAREJO"} | ["{ \"description\": \"brinquedoUpaUpaDoGugu\", \"id\": 0, \"value\": 40000000, \"weight\": 1 }", "{ \"description\": \"tekpix\", \"id\": 0, \"value\": 50, \"weight\": 8000 }" ] |
