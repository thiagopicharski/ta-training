package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MySteps {

    private final Gson gson = new Gson();

    private List<Integer> parseList(String listJson){
        ArrayList<Double> list = gson.fromJson(listJson, ArrayList.class);
        return list.stream().map(Double::intValue).collect(Collectors.toList());
    }

    private List<Integer> dishes;

    @Given("some $dishes")
    public void parseDishes(@Named("dishes") String dishes){
        System.out.println(String.format("Given dishes: %s", dishes));
        this.dishes = parseList(dishes);
    }

    @Given("a solution")
    public void solutionForDish(){

        System.out.println("uwu");
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
