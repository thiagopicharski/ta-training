package org.example.steps;

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
    public void givenCollection(@Value("list") String list){
        ArrayList<Double> listGson = GSON.fromJson(list, ArrayList.class);
        int [] listDishes = listGson.stream().mapToInt(Double::intValue).toArray();

        context.put ("listDishes",listDishes);
    }

    @When ("evaluate coefficient of the dishes")
    public void evaluateCoefficient(){
        int [] dishList = (int []) context.get("listDishes");
        LikeToTimeDishes.Solution solution = likeToTimeDishes.calculateSolution(dishList);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);

    }

    @Then ("the coefficient of the list should be equals '$coefficient'")
    public void checkCoefficient (@Value("coefficient") int coefficient) {
        int actualCoefficient = (int) context.get("actualCoefficient");
        Assert.assertEquals(coefficient, actualCoefficient);

    }
    @When("I remove dishes '$removeDishes'")
    public void removeDishes (@Value("removeDishes") String removeDishes) {
        ArrayList<Double> list = GSON.fromJson(removeDishes, ArrayList.class);
        int[] arrayOfRemovedDishes = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listOfRemovedDishes = Arrays.stream(arrayOfRemovedDishes).boxed().collect(Collectors.toList());
        int[] arrayDishess = (int[]) context.get("listDishes");
        List<Integer> listWithoutRemovedDishes = Arrays.stream(arrayDishess).boxed().collect(Collectors.toList());
        listWithoutRemovedDishes.removeAll(listOfRemovedDishes);
        int[] arrayDishesWithoutRemovedDishes = listWithoutRemovedDishes.stream().mapToInt(i -> i).toArray();
        context.put("listDish", arrayDishesWithoutRemovedDishes);

    }

}


