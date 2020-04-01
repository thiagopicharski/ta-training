Narrative:

As a user,
As a user, I want to the total Like-to-time coefficient to be maximum for the dishes.

Scenario: Check that solution returns the correct coefficient for a valid input of dishes.

Given a collection of dishes '<list>'
When evaluate coefficient of the dishes
Then the coefficient of the list should be equals '<coefficient>'

Examples:

|list        |coefficient  |
|[-1,3,4]    |17           |


Scenario: Check the solution when a dish must be removed and when anyone is removed.

Given a collection of dishes '<list>'
When i remove '<removeDishes>'
When evaluate coefficient of the dishes
Then the coefficient of the list should be equals '<coefficient>'

Examples:
| list           | removeDishes  | coefficient |
| [-1,-9,0,5,-7] | [-9, -7]      | 14          |