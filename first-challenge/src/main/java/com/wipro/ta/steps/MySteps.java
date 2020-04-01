package com.wipro.ta.steps;

import com.wipro.ta.program.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

public class MySteps {

    private Logger logger = Logger.getLogger(MySteps.class);
    int[] dishes;
    int[] endDishes;
    int coefficient;

    @Given("An input '$input' of dishes")
    public void dishesInput(@Value("input") List<Integer> dishesInput){
        dishes = dishesInput.stream().mapToInt(i->i).toArray();
        Assert.assertNotNull("Array is null", dishes);
        logger.info("Dishes = " + Arrays.toString(dishes));
    }

    @When("I calculate the coefficient")
    public void calculateCoefficient(){
        LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
        likeToTimeDishes.calculateSolution(dishes);
        LikeToTimeDishes.Solution solution = likeToTimeDishes.getSolution();
        coefficient = solution.getCoefficient();
        endDishes = solution.getPreparedDishes();
        logger.info(solution.toString());
    }

    @Then("the solution should return '$coefficient'")
    public void returnCoefficient(@Value("coefficient") int correctCoefficient){
        Assert.assertEquals("Coefficient is not correct", correctCoefficient, coefficient);
    }

    @Then("the array must be equals '$dishesPrepared'")
    public void compareDishes(@Value("dishesPrepared") List<Integer> correctDishes){
        Assert.assertEquals("The array of dishes is incorrect", correctDishes.toString(), Arrays.toString(endDishes));
    }
    
}
