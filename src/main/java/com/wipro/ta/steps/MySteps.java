package com.wipro.ta.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class MySteps {

    private int[] dishes = new int[0];

    private LikeToTimeDishes.Solution solution;

    @Given("a collection of dishes with the following values $commaSeparatedValues")
    public void givenACollectionOfDishesWithTheFollowingValues(String commaSeparatedValues) {

        String [] strArray = commaSeparatedValues.split(",");
        dishes  = new int[strArray.length];

        for(int i = 0; i < strArray.length; i++){
            dishes[i] = Integer.parseInt(strArray[i].trim());
        }
            System.out.println(commaSeparatedValues);

    }

    @When("I calculate coefficient")
    public void iCalculateCoefficient(){
        LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
       // solution = LikeToTimeDishes.calculateSolution(dishes);
    }

    @Then("I expect the result to be $result")
    public void iExpectTheResultToBe(int result){
        Assert.assertThat(solution.getCoefficient(), is(result));
    }


}
