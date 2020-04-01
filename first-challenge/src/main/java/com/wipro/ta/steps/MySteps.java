package com.wipro.ta.steps;

import com.google.gson.Gson;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MySteps {
    public static Gson GSON = new Gson();
    private static Map<String, Object> context = new HashMap<String, Object>();
    private static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    @Given ("a collection of dishes '$list'")
    public void givenCollectionOfDishes(@Value("list") String list) {
        ArrayList<Double> listGson = GSON.fromJson(list, ArrayList.class);
        int [] listOfDishes = listGson.stream().mapToInt(Double::intValue).toArray();
        context.put ("listOfDishes", listOfDishes);
    }

    @When("I remove dishes '$removeSomeDishes'")
    public void removeDishes (@Value("removeSomeDishes") String removeSomeDishes) {
        ArrayList<Double> list = GSON.fromJson(removeSomeDishes, ArrayList.class);
        int[] removedDishesArray = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> removedDishesList = Arrays.stream(removedDishesArray).boxed().collect(Collectors.toList());
        int[] arrayDishes = (int[]) context.get("listDishes");
        List<Integer> listWithoutRemovedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWithoutRemovedDishes.removeAll(removedDishesList);
        int[] arrayDishesWithoutRemovedDishes = listWithoutRemovedDishes.stream().mapToInt(i -> i).toArray();
        context.put("listDish", arrayDishesWithoutRemovedDishes);
    }

    @When ("calculating the coefficient of the dishes")
    public void evaluatingCoefficientOfTheDishes() {
        int [] dishList = (int []) context.get("listOfDishes");
        LikeToTimeDishes.Solution solution = likeToTimeDishes.calculateSolution(dishList);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);

    }
    @Then ("the coefficient of the list should be equal to '$coefficient'")
    public void coefficientShouldBeEqualTo(@Value("coefficient") int coefficient) {
        int actualCoefficient = (int) context.get("actualCoefficient");
        Assert.assertEquals(coefficient, actualCoefficient);
    }
}