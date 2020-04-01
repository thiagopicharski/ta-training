Narrative:
As User,
I want to the total Like-to-time coefficient to be maximum for the dishes.

Scenario: Check that solution returns the correct coeffient for a valid input of dishes when dishes are not removed
Given a collection of dishes '<list>'
When evaluate coefficient of the dishes
Then the coefficient of the list should be equals '<coefficient>'
Examples:
|list	    |coefficient	|
|[-1,3,4]   |17		    	|

Scenario: I want to be able to remove some dishes, in wich case, a new coefficient is calculated

Given a collection of dishes '<list>'
And I remove dishes '<removedDishes>'
When evaluate coefficient of the dishes
Then the coefficient of the list should be equals '<coefficient>'
Examples:
|list		|removedDishes	|coefficient|
|[-1,-9,0,5,-7]	|[-9,-7]		|	14		|