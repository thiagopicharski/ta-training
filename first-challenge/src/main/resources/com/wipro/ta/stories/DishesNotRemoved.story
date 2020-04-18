Narrative:
As a user,
I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: Check that solution returns the correct coeffient for a valid input of dishes when anyone is removed
Given a collection representing the linking value of each dish '<list>'
When evaluate the coeffient  of this collection
Then the  coeffient  should be equals to '<coeffient>'
Examples:
|list      |coeffient  |
|[-1,3,4]  |17         |

