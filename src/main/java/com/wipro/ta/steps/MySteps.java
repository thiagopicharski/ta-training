package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;

//Saporra não tá confundindo?
public class MySteps {

    private static Gson GSON = new Gson();
    private Map<String,Object> context = new HashMap<String,Object>();
    private static LikeToTimeDishes LikeToTimeDishes = new LikeToTimeDishes();

    @Given("a set of dishes '$list'")
    public void avaliableDishes(@Value("list") String list){
        ArrayList<Double> listGson = GSON.fromJson(list, ArrayList.class);
        int [] dishList = listGson.stream().mapToInt(Double::intValue).toArray();

        context.put("dishList", dishList);
    }

    @When("I calculate its coefficient")
    public void takeDishes(){
        int [] totalDishes = (int[]) context.get("dishList");
        LikeToTimeDishes.Solution solution = LikeToTimeDishes.calculateSolution(totalDishes);
        int coefficient =  solution.getCoefficient();
        context.put("realCoefficient", coefficient);
    }

    @Then("the coefficient is '$coefficient'")
    public void totDishes(@Value("coefficient") int coefficient){
        int realCoefficient = (int)context.get("realCoefficient");
        Assert.assertEquals(coefficient, realCoefficient);
    }
    
    @When("I remove some dishes '$removeDish'")
    public void subtractDishes(@Value("removeDish")String removeDish){
        ArrayList<Double> list = GSON.fromJson(removeDish, ArrayList.class);
        int [] arrayOfRemovedDishes = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listOfRemovedDishes = Arrays.stream(arrayOfRemovedDishes).boxed().collect(Collectors.toList());
        int [] arrayDishes = (int[]) context.get("dishList");
        List<Integer> listWithoutRemovedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWithoutRemovedDishes.removeAll(listOfRemovedDishes);
        int [] arrayDishesWithoutRemovedDishes = listWithoutRemovedDishes.stream().mapToInt(i->i).toArray();
        context.put("dishList", arrayDishesWithoutRemovedDishes);
    }
}

