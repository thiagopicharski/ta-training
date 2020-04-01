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

public class MySteps {

    private static Gson GSON = new Gson();
    private Map<String, Object> context = new HashMap<String, Object>();
    private static com.wipro.ta.LikeToTimeDishes LikeToTimeDishes = new LikeToTimeDishes();

    @Given("a collection of dishes '$list'")
    public void givenCollection(@Value("list") String list) {
        ArrayList<Double> listGson = GSON.fromJson(list, ArrayList.class);
        int[] listTheDishes = listGson.stream().mapToInt(Double::intValue).toArray();
        context.put("listDish", listTheDishes);
    }

    @When("evaluate coefficient of the dishes")
    public void evaluatedCoefficient() {
        int[] listDishes = (int[]) context.get("listDish");
        LikeToTimeDishes.Solution solution = LikeToTimeDishes.calculateSolution(listDishes);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);
    }

    @Then("the coefficient of the list should be equals '$coefficient'")
    public void checkCoefficient(@Value("coefficient") int coefficient) {
        int actualCoefficient = (int) context.get("actualCoefficient");
        Assert.assertEquals(coefficient, actualCoefficient);
    }

    @When("i remove '$removeDishes'")
    public void removeDishes(@Value("removeDishes") String removeDishes) {
        ArrayList<Double> list = GSON.fromJson(removeDishes, ArrayList.class);
        int[] arrayOfRemovedDishes = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listOfRemovedDishes = Arrays.stream(arrayOfRemovedDishes).boxed().collect(Collectors.toList());
        int[] arrayDishes = (int[]) context.get("listDish");
        List<Integer> listWithoutRemovedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWithoutRemovedDishes.removeAll(listOfRemovedDishes);
        int[] arrayDishesWithoutRemovedDishes = listWithoutRemovedDishes.stream().mapToInt(i -> i).toArray();
        context.put("listDish", arrayDishesWithoutRemovedDishes);
    }
}