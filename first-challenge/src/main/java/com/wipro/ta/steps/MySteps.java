package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import com.wipro.ta.data.ListField;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


import static org.junit.Assert.assertEquals;

public class MySteps {

    public static Map<String, Object> context = new HashMap<String, Object>();

    public static Gson gson = new Gson();

    private Logger logger = Logger.getLogger(MySteps.class);

    private static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();

    private LikeToTimeDishes.Solution solution;

    @Given("some dishes '$list'")
    public void givenSomeDishes(@Value("list") String list) {
        String json = "{\"list\":" + list +"}";
        ListField listField = gson.fromJson(json, ListField.class);

        context.put("listField", listField);
    }

    @When("I calculate coefficient")
    public void whenCalculateCoefficient() {
        ListField listField = (ListField) context.get("listField");

        this.solution = likeToTimeDishes.calculateSolution(listField.getList().stream().mapToInt(i->i).toArray());
        logger.info(String.format("Solution: %s", solution));
    }


    @Then("coefficient is $coefficient")
    public void thenCoefficientIs(@Value("coefficient") int coefficient) {
        assertEquals(coefficient, solution.getCoefficient());
    }

    @Given("calculate their coefficient")
    public void givenCalculateTheirCoefficient() {
        ListField listField = (ListField) context.get("listField");

        this.solution = likeToTimeDishes.calculateSolution(listField.getList().stream().mapToInt(i->i).toArray());
        logger.info(String.format("Calculated solution: %s", this.solution));
    }

    @When("I remove dishes $removeNums")
    public void whenRemoveDishes(@Value("removeEnums") String removeDishesJson) {
        ListField originalListField = (ListField) context.get("listField");
        String json = "{\"list\":" + removeDishesJson +"}";
        ListField removeList = gson.fromJson(json, ListField.class);
        List<Integer> list = new ArrayList<>();
        for (Integer i: originalListField.getList()) {
            if (!removeList.getList().contains(i))  {
                list.add(i);
            }
        }
        originalListField.setList(list);
    }
}
