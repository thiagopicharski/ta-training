Narrative: As an user, I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: With a collection without any removals the application should calculate the coefficient using all dishes

Given the collection '<dishes>' with each value representing a dish
When I calculate the solution
Then the coefficient should be '<coefficient>'
Examples:
|dishes  |coefficient |
|1,2,3   |14          |
|-1,3,4  |17          |
|2,7,1   |19          |



