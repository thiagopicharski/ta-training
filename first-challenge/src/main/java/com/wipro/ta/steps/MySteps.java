package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
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

    private final Gson gson = new Gson();
    private LikeToTimeDishes.Solution solution;

    private int[] parseList(String listJson){
        ArrayList<Double> list = gson.fromJson(listJson, ArrayList.class);
        return list.stream().mapToInt(Double::intValue).toArray();
    }

    private int[] listToArray(List<Integer> list) {
        return list.stream().mapToInt(i->i).toArray();
    }

    private List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    private final LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    private int[] dishes;

    @Given("some $dishes")
    public void parseDishes(@Named("dishes") String dishes){
        System.out.println(String.format("Given dishes: %s", dishes));
        this.dishes = parseList(dishes);
    }

    @When("I calculate coefficient")
    public void getSolution(){
        this.solution = likeToTimeDishes.calculateSolution(this.dishes);
        System.out.println(String.format("Calculated solution: %s", this.solution));
    }

    @Then("coefficient is $coefficient")
    public void coefficientIsMax(@Named("coefficient") int coefficient){
        assertEquals(coefficient, solution.getCoefficient());
    }


    @Given("a solution")
    public void solutionForDish(){
        this.solution = this.likeToTimeDishes.calculateSolution(this.dishes);
        System.out.println(String.format("Solution = %s", solution));
    }

    @Given("calculate their coefficient")
    public void calculateCoeff(){
        this.getSolution();
    }

    @When("I remove dishes $removeNums")
    public void removeDishes(@Named("removedNums") String dishesToRemoveJson){
        int[] dishesToRemove = this.parseList(dishesToRemoveJson);
        List<Integer> dishes = arrayToList(this.dishes);
        dishes.removeAll(arrayToList(dishesToRemove));
        this.dishes = listToArray(dishes);
    }


}
