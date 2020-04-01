Narrative: As an user, I want the total Like-to-time coefficient to be maximum for the dishes

Scenario: The solution must calculate the maximum sum of all possible Like-to-time coefficients.

Given the amount of <dishes>
When the coefficient are calculated
Then the coefficient is equal to <coefficientResult>

Examples:
| dishes    | coefficientResult|
| [-1,3,4]  |        17        |

Scenario: I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.


Given the amount of <dishes>
And the coefficient calculated
When some dishes are <removed>
And the coefficient are calculated
Then the coefficient is equal to <coefficientResult>

Examples:
| dishes        | removed     | coefficientResult|
| [-1,-9,0,5,-7]| [-9, -7]    |       14         |
