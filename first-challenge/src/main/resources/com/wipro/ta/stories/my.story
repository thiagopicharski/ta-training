Narrative:
As an user
I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: Solution must return the correct coeffient for a valid input of dishes, when a dish is removed and when anyone is removed

Given An input '<input>' of dishes
When I calculate the coefficient
Then the solution should return '<coefficient>'
And the array must be equals '<dishesPrepared>'
Examples:
|input          |coefficient   |dishesPrepared
|1,3,2          |13            |1,3,2
|-1,3,4         |17            |-1,3,4
|-1,-9,0,5,-7   |14            |-1,0,5

