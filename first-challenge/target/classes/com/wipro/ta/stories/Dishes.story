Narrative:
As a user,
I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: Check that solution returns the correct coeffient for a valid input of dishes and when it removes some dishes from the list

Given a list of '<dishesList>'
When it removes '<removeDishes>' from the list
And calculates the sum of like-to-time coefficient of dishes
Then it should return '<coefficient>'
Examples:
|dishesList     |removeDishes |coefficient    |
|[1,3,5,2]      |[2,5]        |7              |
|[4,-1,3,2]     |[2]          |11             |
|[1,2,3,4]      |[]           |30             |

