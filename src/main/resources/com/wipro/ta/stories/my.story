Narrative: As a user, I want to the total Like-to-time coefficient to be maximum for the dishes.

Scenario:
Given a set of dishes '<list>'
When I calculate its coefficient
Then the coefficient is '<coefficient>'
Examples:
|list | coefficient|
|[-1, 3, 4] | 17|

I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Scenario:
Given a set of dishes '<list>'
When I remove some dishes '<removeDish>'
Then the coefficient is '<coefficient>'

Examples:
|list |removeDish |coefficient|
[-1, -9, 0, 5, -7] | [-9, -7] | 14|

