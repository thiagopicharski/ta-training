package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MySteps {

    private final Logger logger = Logger.getLogger(MySteps.class);
    private final Gson gson = new Gson();
    private LikeToTimeDishes.Solution solution;
    private int coefficientResult;

    private int[] toList(String listJson){
        ArrayList<Double> list = gson.fromJson(listJson, ArrayList.class);
        return list.stream().mapToInt(Double::intValue).toArray();
    }

    private List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    private int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(i->i).toArray();
    }

    private final LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    private int[] dishes;

    @Given("a collection of $dishes")
    public void parseDishes(@Named("dishes") String dishes){
        logger.info("1 - Given the dishes: "+dishes);
        this.dishes = toList(dishes);
    }

    @Given("calculate their coefficient")
    public void calculateCoefficient(){
        this.coefficientResult = likeToTimeDishes.calculateSolution(dishes).getCoefficient();
    }

    @When("I calculate the coefficient of the given dishes")
    public void getSolution(){
        this.solution = likeToTimeDishes.calculateSolution(this.dishes);
        logger.info("2 - I run the solution: "+this.solution);
    }

    @When("I remove a number of dishes $numdishes")
    public void removeDishes(@Named("$numdishes") String dishesToRemoveJson){
        int[] dishesToRemove = this.toList(dishesToRemoveJson);
        List<Integer> dishes = arrayToList(this.dishes);
        dishes.removeAll(arrayToList(dishesToRemove));
        logger.info("2 - I removed "+ Arrays.toString(dishesToRemove) +" from it");
        this.dishes = toArray(dishes);
    }

    @Then("the coefficient should be $coefficient")
    public void coefficientIsMax(@Named("coefficient") int coefficient){
        logger.info("3 - Then the coefficient should be: "+coefficient+" and I get: "+coefficientResult);
        assertEquals(coefficient, solution.getCoefficient());
    }

}
