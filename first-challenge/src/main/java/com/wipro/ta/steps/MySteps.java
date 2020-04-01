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

public class MySteps
{

    private final Logger logger = Logger.getLogger(MySteps.class);


    private final Gson gson = new Gson();
    private LikeToTimeDishes.Solution solution;

    private int[] parseList(String listJson)
    {
        ArrayList<Double> list = gson.fromJson(listJson, ArrayList.class);
        return list.stream().mapToInt(Double::intValue).toArray();
    }

    private int[] listToArray(List<Integer> list)
    {
        return list.stream().mapToInt(i->i).toArray();
    }

    private List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    private final LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    private int[] dishes;

    @Given("the amount of $dishes")
    public void parseDishes(@Named("dishes") String dishes)
    {
        logger.info(String.format("Amount of dishes: %s", dishes));
        this.dishes = parseList(dishes);
    }

    @When("the coefficient are calculated")
    public void getSolution()
    {
        this.solution = likeToTimeDishes.calculateSolution(this.dishes);
        logger.info(String.format("The coefficient is: %s", this.solution));
    }

    @Then("the coefficient is equal to $coefficientResult")
    public void coefficientIsMax(@Named("coefficientResult") int coefficientResult)
    {
        assertEquals(coefficientResult, solution.getCoefficient());
    }




    @Given("a solution")
    public void solutionForDish()
    {
        this.solution = this.likeToTimeDishes.calculateSolution(this.dishes);
        logger.info(String.format("Solution = %s", solution));
    }

    @Given("the coefficient calculated")
    public void calculateCoeff()
    {
        this.getSolution();
    }

    @When("some dishes are $removed")
    public void removeDishes(@Named("$removed") String dishesToRemoveJson)
    {
        int[] dishesToRemove = this.parseList(dishesToRemoveJson);
        List<Integer> dishes = arrayToList(this.dishes);
        dishes.removeAll(arrayToList(dishesToRemove));
        this.dishes = listToArray(dishes);
    }

}