Narrative:
As an user
I want the total Like-to-time coefficient to be maximum for the dishes

Scenario: The solution must calculate the maximum sum of all possible Like-to-time coefficients.

Given some <dishes>
When I calculate coefficient
Then coefficient is <maximum>

Examples:
|dishes|maximum|
|[-1,3,4]| 17 |
