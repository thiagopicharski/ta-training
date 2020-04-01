
Scenario: As an user I want the total Like-to-time coefficient to be maximum for the dishes

Given some <dishes>
When I calculate coefficient
Then coefficient is <coefficient>

Examples:
|dishes|coefficient|
|[-1,3,4|17|

Scenario: I want to be able remove some dishes, in wich case, a new coefficient is calculated using left dishes.Scenario:

Given some <dishes>
And calculate their coefficient
When I remove dishes <removeNums>
And I calculate coefficient

Examples:
|dishes       |removeNums |coefficient
|[-1,-9,0,5,-7|[-9,-7]    |14

