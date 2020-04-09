Scenario:
    As a user,
    I want to be able remove some dishes,
    in which case,
    a new coefficient is calculated using the left dishes.

Given I used an array '<list>' of dishes
And I give the result
When I remove the dishes '<positionListToRemove>'
Then the current output must be '<result>'
Examples:
| list               | positionListToRemove | result |
| [-1, -9, 0, 5, -7] | [1, 4]               | 14     |