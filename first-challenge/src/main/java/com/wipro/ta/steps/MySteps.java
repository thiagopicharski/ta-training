package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.data.LikeToTimeDishes;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;

public class MySteps {

    private LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    public static Gson GSON = new Gson();
    public Map<String, Object> context = new HashMap<String, Object>();

    @Given("a collection '$list'")
    public void givenCollection(@Value("list") String list) {
        ArrayList<Double> listGSON = GSON.fromJson(list, ArrayList.class);
        int [] listDishes = listGSON.stream().mapToInt(Double::intValue).toArray();
        context.put("listDishes", listDishes);
    }

    @When("calculate coefficient of the dishes")
    public void calculateCoefficient() {
        int [] listDish = (int []) context.get("listDishes");
        LikeToTimeDishes.Solution solution = likeToTimeDishes.calculateSolution(listDish);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);
    }

    @Then("the coefficient should be equals to '$coefficient'")
    public void thenEvaluateCoefficientResult(@Value("coefficient") int coefficient) {
        int actualCoefficient = (int) context.get("actualCoefficient");
        Assert.assertEquals(actualCoefficient, coefficient);
    }

    @When("remove some dishes '$listRemove'")
    public void removeDishes(@Value("listRemove") String listRemove){
        ArrayList<Double> list = GSON.fromJson(listRemove, ArrayList.class);
        int [] arrayOfRemovedDishes = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listOfRemovedDishes = Arrays.stream(arrayOfRemovedDishes).boxed().collect(Collectors.toList());
        int [] arrayDishes = (int []) context.get("listDishes");
        List<Integer> listWithoutRemovedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWithoutRemovedDishes.removeAll(listOfRemovedDishes);
        int[] arrayDishesWithoutRemoveDishes = listWithoutRemovedDishes.stream().mapToInt(i -> i).toArray();
        context.put("listDishes", arrayDishesWithoutRemoveDishes);
    }
}
