package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MySteps {
    public static Gson GSON = new Gson();
    public Map<String, Object> context = new HashMap<String, Object>();
    private LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    @Given("A value of dishes '<$list>'")
    public void givenList(@Value("list") String list) {
        ArrayList<Double> listGSON = GSON.fromJson(list, ArrayList.class);
        int[] listDishes = listGSON.stream().mapToInt(Double::intValue).toArray();
        context.put("listDishers", listDishes);
    }

    @When("I calculate the solution")
    public void whenCalculate() {
        int[] listDish = (int[]) context.get("listDisher");
        LikeToTimeDishes.Solution solution = likeToTimeDishes.calculateSolution(listDish);
        int coefficient = solution.getCoefficient();
        context.put("actualCoefficient", coefficient);

    }

    @Then("I shall have the coefficient <coefficient>")
    public void thenCalculateCoefficient(@Value("coefficient") int coefficient) {
        int newCoefficient = (int) context.get("afterCoefficient");
        assertEquals(newCoefficient, coefficient);


    }



}
