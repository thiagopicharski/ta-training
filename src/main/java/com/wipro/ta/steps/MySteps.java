package com.wipro.ta.steps;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;

@RunWith(JUnitReportingRunner.class)
public class MySteps {

    private static final Gson GSON = new Gson();
    private Map<String, Object> context = new HashMap<String, Object>();
    private static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    private static final Logger LOGGER = Logger.getLogger(MySteps.class);

    private int[] parseList(String listJson){
        ArrayList<Double> list = GSON.fromJson(listJson, ArrayList.class);
        return list.stream().mapToInt(Double::intValue).toArray();
    }

    @Given("a collection of dishes '$list'")
    public void givenCollection(@Value("list") String list) {
        ArrayList<Double> listGson = GSON.fromJson(list, ArrayList.class);
        int[] listDish = listGson.stream().mapToInt(Double::intValue).toArray();
        context.put("listDish", listDish);
        LOGGER.info("A collection of dishes");
    }

    @When("evaluate coefficient of the dishes")
    public void evaluateCoefficient() {
        int[] listDish = (int[]) context.get("listDish");
        LikeToTimeDishes.Solution solution = likeToTimeDishes.calculateSolution(listDish);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);
        LOGGER.info("Evaluate coefficient of the dishes");
    }

    @Then("the coefficient of the list should be equals '$coefficient'")
    public void checkCoefficient(@Value("coefficient") int coefficient) {
        int actualCoefficient = (int) context.get("actualCoefficient");
        assertEquals(coefficient, coefficient);
        LOGGER.info("The coefficient of the list should be equals " + coefficient);
    }

    @Given("I remove dishes '$removedDishes'")
    public void removeDishes(@Named("removedDishes") String dishesToRemoveJson) {
        ArrayList<Double> dishList = GSON.fromJson(dishesToRemoveJson, ArrayList.class);
        int [] arrayOfRemovedDishes = dishList.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listOfRemovedDishes = Arrays.stream(arrayOfRemovedDishes).boxed().collect(Collectors.toList());
        int [] arrayDishes = (int []) context.get("listDish");
        List<Integer> listWithtoutRemovedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWithtoutRemovedDishes.removeAll(listOfRemovedDishes);
        int [] arrayDishesWithoutRemovedDishes = listWithtoutRemovedDishes.stream().mapToInt(i->i).toArray();
        context.put("listDish", arrayDishesWithoutRemovedDishes);
    }
}

