package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MySteps {

    private final LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    private static Gson GSON = new Gson();
    private Map<String, Object> context = new HashMap<>();

    @Given("a collection of $dishes")
    public void givenDishes(@Value("list") String dishes){
        int [] dish = convert(dishes);
        context.put("dish", dish);
    }

    @When("the coefficient is calculated")
    public void calculate(){
        int[] dish = (int[]) context.get("dish");
        LikeToTimeDishes.Solution result = likeToTimeDishes.calculateSolution(dish);
        int solution = result.getCoefficient();
        context.put("value", solution);
    }

    @Then("the value should be equals to $coefficient")
    public void coefficientEquals(@Value("result") int coefficient){
        assertEquals(coefficient, context.get("value"));
    }

    @When("Removed $remove")
    public void removeDishes(@Value("remove") String removed){
        int [] dishesRemoved = convert(removed);
        List<Integer> dishes = Arrays.stream(dishesRemoved).boxed().collect(Collectors.toList());
        int [] arrayDishes = (int []) context.get("dish");
        List<Integer> dishesList = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        int [] dishesCollection = dishesList.stream().mapToInt(i->i).toArray();
    }

    public int [] convert(String list){
        ArrayList<Double> arrayList = GSON.fromJson(list, ArrayList.class);
        return arrayList.stream().mapToInt(Double::intValue).toArray();
    }

}
