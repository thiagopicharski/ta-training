package com.wipro.ta.steps;

import com.google.gson.Gson;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;

public class MySteps {
    public static Gson GSON = new Gson();
    private static Map<String,Object> context = new HashMap<String, Object>();
    private static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    @Given ("a collection of dishes '$list'")
    public void givenACollectionOfDishes(@Value("list") String list){
        ArrayList<Double> listJSon = GSON.fromJson(list, ArrayList.class);
        int [] listDishes = listJSon.stream().mapToInt(Double::intValue).toArray();

        context.put ("listDishes",listDishes);
    }


    @When ("evaluate coefficient of the dishes")
    public void evaluateCoefficientOfTheDishes(){
        int [] dishesList = (int []) context.get("listDishes");
        LikeToTimeDishes.Solution solution = likeToTimeDishes.calculateSolution(dishesList);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);

    }

    @Then ("the coefficient of the list should be equals '$coefficient'")
    public void checkCoefficientShouldBeEquals (@Value("coefficient") int coefficient) {
        int actualCoefficient = (int) context.get("actualCoefficient");
        Assert.assertEquals(coefficient, actualCoefficient);

    }
    @When("I delete dishes '$deleteDishes'")
    public void deleteDishesFrom (@Value("deleteDishes") String deleteDishes) {
        ArrayList<Double> list = GSON.fromJson(deleteDishes, ArrayList.class);
        int[] arrayOfDeletedDishes = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listOfDeletedDishes = Arrays.stream(arrayOfDeletedDishes).boxed().collect(Collectors.toList());
        int[] arrayDishes = (int[]) context.get("listDishes");
        List<Integer> listWithoutDeletedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWithoutDeletedDishes.removeAll(listOfDeletedDishes);
        int[] arrayDishesWithoutDeletedDishes = listWithoutDeletedDishes.stream().mapToInt(i -> i).toArray();
        context.put("listDish", arrayDishesWithoutDeletedDishes);

    }

}
