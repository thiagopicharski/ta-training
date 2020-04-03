package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class DishesSteps {
    private static final Logger logger = LogManager.getLogger("DishesSteps");
    private static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    private Gson gson = new Gson();
    private ArrayList<Integer> jsonToIntArray;
    private ArrayList<Integer> jsonToIntArrayRemove;
    private Type type;
    private int coefficient;

    @Given("a list of '$dishesList'")
    public void listOfDishes(@Value("dishesList") String stringList){
        type = new TypeToken<ArrayList<Integer>>(){}.getType();
        jsonToIntArray = gson.fromJson(stringList, type);
    }

    @When("it removes '$removeDishes' from the list")
    public void removeDishesFromList(@Value("removeDishes") String removeDishes){
        type = new TypeToken<ArrayList<Integer>>(){}.getType();
        jsonToIntArrayRemove = gson.fromJson(removeDishes, type);
        jsonToIntArray.removeIf(i -> jsonToIntArrayRemove.indexOf(i) != -1);
    }

    @When("calculates the sum of like-to-time coefficient of dishes")
    public void whenCalculatesSumCoefficients(){
        int[] array = jsonToIntArray.stream().mapToInt(Integer::intValue).toArray();
        coefficient = likeToTimeDishes.calculateSolution(array).getCoefficient();
    }

    @Then("it should return '$coefficient'")
    public void thenItShouldReturnCoefficient(@Value("coefficient") String result){
        int resultInt = Integer.parseInt(result);
        Assert.assertEquals(coefficient, resultInt);
    }
}
