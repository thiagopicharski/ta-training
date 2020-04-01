Narrative: As an user, I want to the total Like-to-time coefficient to be maximum for the dishes

Scenario: With two collections, one representing all dishes, and other with dishes to be removed, the coefficient
must be calculated without considering the removed ones

Given the collection '<dishes>' with each  value representing a dish
And having the '<removedDishes>' removed
When I calculate the solution
Then the coefficient should be '<coefficient>'
Examples:
|dishes         |removedDishes|coefficient |
|1,2,4,6        |4            |23          |
|-1,-9,0,5,-7   |-9,-7        |14          |
|2,4,1,0,8,9    |1,0,8        |37          |