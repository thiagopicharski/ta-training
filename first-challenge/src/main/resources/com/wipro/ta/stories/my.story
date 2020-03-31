Narrative:
As a user,
I want to the total Like-to-time coefficient to be maximum for the dishes.

Scenario: Check that solution returns correct coefficient for a valid input of dishes are not removed

Given a collection of dishes'<list>'
When evaluate coefficient of the dishes
Then the coefficient of the list should be equals '<coefficient>'
Examples:
|list    |coefficient |
|[-1,3,4]     |17     |

Scenario: I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.
Given a collection of dishes'<list>'
When I remove dishes '<removeDishes>'
When evaluate coefficient of the dishes
Then the coefficient of the list should be equals '<coefficient>'
Examples:
|list      | removeDishes |coefficient|
|[-1, -9, 9, 0, 5, -7]| [-9, -7] | 14 |



