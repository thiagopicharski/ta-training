Narrative:
As an user,
I want to the total Like-to-time coefficient to be maximum for the dishes.

Scenario: The solution must calculate the maximum sum of all possible Like-to-time coefficients.

Given a collection of <list>
When the coefficient is calculated
Then the value should be equals to <result>

Examples:
| list | result |
|[-1,3,4]|     17      |

Scenario: I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Given a collection of <list>
When Removed <remove>
And the coefficient is calculated
Then the value should be equals to <result>
Examples:
|     list    |  remove | result |
|[-1,-9,0,5,-7] | [-9, -7]|     14      |
