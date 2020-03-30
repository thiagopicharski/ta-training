# Test Automation Training

## 1st Challenge:

### Create a new Jbehave project with maven

**Use the archetype to create the project:** 
*mvn archetype:generate* 
Use the ID **2074** for org.jbehave:jbehave-spring-archetype

>jbehaveCoreVersion: 4.6.2
groupId: com.wipro.ta
artifactId: first-challenge
version: 0.0.1-SNAPSHOT
package: com.wipro.ta

Use log4j with this log pattern: *[%d{yyyy-MM-dd HH:mm:ss}] [%-5p] [%c{1}:%L] - %m%n*

### Create automated tests based on the story below:

As a user, I want to the total Like-to-time coefficient to be maximum for the dishes.
1. I want to be able remove some dishes, in which case, a new coefficient is calculated using the left dishes.
2. The solution must calculate the maximum sum of all possible Like-to-time coefficients.

**Input Specification:**
input: Array representing the linking value of each dish

**Output Specification:**
Return maximum like-to-time coefficient possible

**Acceptance Criteria:**
1. Check that solution returns the correct coeffient for a valid input of dishes
2. Check the solution when a dish must be removed and when anyone is removed

Examples:

Not Removed:
input: {-1,3,4}
Output: 17

Removed:
input: {-1,-9,0,5,-7} #Dish -9 and -7 must be removed
Output: 14

