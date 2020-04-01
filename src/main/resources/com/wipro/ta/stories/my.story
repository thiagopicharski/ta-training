Narrative:
As an user
I want the total Like-to-time coefficient to be maximum for the dishes

Scenario: The solution must calculate the maximum sum of all possible Like-to-time coefficients.

Given a collection of <dishes>
When I calculate the coefficient of the given dishes
Then the coefficient should be <coefficient>
Examples:
|dishes    |coefficient|
|[-1,3,4]  | 17        |

Scenario: I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Given a collection of <dishes>
And calculate their coefficient
When I remove a number of dishes <numdishes>
And I calculate the coefficient of the given dishes
Then the coefficient should be <coefficient>
Examples:
|dishes        | numdishes  |coefficient|
|[-1,-9,0,5,-7]| [-9, -7]   |    14     |


