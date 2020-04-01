Narrative:
As a user
I want to the total Like-to-time coefficient to be maximum for the dishes.

Scenario: Check that solution calculate the maximum sum of all possible Like-to-time coefficients.

Given some dishes '<list>'
When I calculate coefficient
Then coefficient is <coefficient>

Examples:
|list    |coefficient|
|[-1,3,4]| 17 |

Scenario: I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Given some dishes '<list>'
And calculate their coefficient
When I remove dishes <removeNums>
And I calculate coefficient
Then coefficient is <coefficient>
Examples:
|list             | removeNums |coefficient|
|[-1,-9,0,5,-7]   | [-9, -7]   |    14     |