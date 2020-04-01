Narrative 1:
As a user 
I want to calculate the total Like-to-time coefficient to be maximum for the dishes.

Given a collection <notRemoved>
When calculate this collection by maximum sum of all possible 
Then the result should be <coefficient>

Acceptance Criteria 1:
Check that solution returns the correct coefficient for a valid input of dishes

Examples:

|notRemoved  |coefficient  |

|[-1,3,4]    |17           |

Narrative 2:
As a user 
I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.

Given a collection <dishesNumber>
When remove dishes <removed>
And calculate this collection by maximum sum of all possible left dishes 
Then the result should be <coefficient>

Acceptance Criteria 2:
Check the solution when a dish must be removed and when no dishes is removed

Examples:

| dishesNumber   | removed       | coefficient |

| [-1,-9,0,5,-7] | [-9, -7]      | 14          |