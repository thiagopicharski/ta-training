Narrative:
As an user
I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: Solution must be returns Like-to-time coefficient to be maximum

Given a collection '<list>'
When calculate coefficient of the dishes
Then the coefficient should be equals to '<coefficient>'
Examples:
|list           |coefficient  |
|[-1,3,4]       |17           |

Scenario: I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes

Given a collection '<list>'
When remove some dishes '<listRemove>'
When calculate coefficient of the dishes
Then the coefficient should be equals to '<coefficient>'
Examples:
|list           |listRemove  |coefficient  |
|[-1,-9,0,5,-7] |[-9,-7]     |14           |