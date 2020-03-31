package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MySteps {

    private final Gson gson = new Gson();
    private LikeToTimeDishes.Solution solution;

    private int[] parseList(String listJson){
        ArrayList<Double> list = gson.fromJson(listJson, ArrayList.class);
        return list.stream().mapToInt(Double::intValue).toArray();
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
    @Then("coefficient is $maximum")
    public void coefficientIsMax(@Named("maximum") int max){
        assertEquals(max, solution.getCoefficient());
    }


    @Given("a solution")
    public void solutionForDish(){
        this.solution = this.likeToTimeDishes.calculateSolution(this.dishes);
        System.out.println(String.format("Solution = %s", solution));
    }

    @When("I remove a $dish")
    public void removeDish(){
        System.out.println("uwu");

    }

    @Then("I get a new coefficient")
    public void thenNewCoefficient(){
        System.out.println("uwu");

    }


}
