package com.wipro.ta.steps;

import com.google.common.primitives.Ints;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class DishesSteps {

    private Logger logger = Logger.getLogger(DishesSteps.class);

    private final LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    private List<Integer> dishesToCalculate;
    private int calculatedCoefficient;

    @Given("the collection '$dishes' with each value representing a dish")
    public void prepareCollection(@Value("dishes") List<Integer> inputDishes) {
        this.dishesToCalculate = inputDishes;
        logger.info("1. Given received dish collection \"" + inputDishes.toString()+"\"");
    }

    @Given(("having the '$removedDishes' removed"))
    public void removeDishes(@Value("removedDishes") List<Integer> dishesToRemove) {
        this.dishesToCalculate.removeAll(dishesToRemove);
        logger.info("1.2. And removing dishes \"" +dishesToRemove.toString()+"\" from it");
    }

    @When("I calculate the solution")
    public void calculateSolution() {
        this.calculatedCoefficient = likeToTimeDishes.calculateSolution(Ints.toArray(dishesToCalculate)).getCoefficient();
        logger.info("2. When I calculate the solution");
    }

    @Then("the coefficient should be '$coefficient'")
    public void assertResult(@Value("coefficient") int expectedResult) {
        logger.info("3. The coefficient should be: " + expectedResult);
        Assert.assertEquals("Values are not the same", expectedResult, calculatedCoefficient);
    }
}
