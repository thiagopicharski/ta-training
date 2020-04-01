
Scenario: As a user, I want to the total Like-to-time coefficient to be maximum for the dishes.

Given I receive the value of dishes '<field>'
When I calculate the solution
Then I shall see the coefficient: '<coefficient>'
Examples:
|field          |coefficient|
|1,2,3          |14         |
|-1,3,4         |17         |
|-1,-9,0,5,-7   |14         |


