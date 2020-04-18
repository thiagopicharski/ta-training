Narrative:
As a user,
I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: Check that solution returns the correct coeffient for a valid input of dishes when dishes are removed
Given a collection representing the value of each dish '<list1>'
When i remove dishes from the collection '<removedDishes>' to evaluate the coeffient
Then the  coeffient of the list with removed values  should be equals to '<coeffient1>'
Examples:
|list1            |removedDishes |coeffient1  |
|[-1,-9,0,5,-7]   |[-9,-7]       |14          |