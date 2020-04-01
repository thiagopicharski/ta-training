
As a User
I want the total Like-to-time coefficient to be maximum for the dishes.

Scenario: 1 - I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Given a collection of dishes with the following values 1, 3, 5, 6, 8
When I calculate coefficient
Then i expect the result 86


Scenario: 2 - The solution must calculate the maximum sum of all possible Like-to-time coefficients.

Given a collection of dishes with the following values 2, 3, 4
When i calculate the maximum sum of coefficients
Then i expect the result

