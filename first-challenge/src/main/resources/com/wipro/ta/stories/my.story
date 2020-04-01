Narrative:
As a user,
I want to total like-to-time coefficient to be maximum for the dishes

Scenario: 1 - The solution must calculate the maximum sum of all possible Like-to-time coefficients.

Given a collection of dishes '<list>'
When calculating the coefficient of the dishes
Then the coefficient of the list should be equal to '<coefficient>'
Examples:
|list          |coefficient  |
|[-1,3,4]      |17           |

Scenario: 2 - I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Given a collection of dishes '<list>'
When I remove dishes '<removeSomeDishes>'
When calculating the coefficient of the dishes
Then the coefficient of the list should be equal to '<coefficient>'
Examples:
| list           | removeSomeDishes  | coefficient |
| [-1,-9,0,5,-7] | [-9,-7] | 14          |