package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DishNotRemovedSteps {

    private Logger logger = Logger.getLogger(DishNotRemovedSteps.class);

    public static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    public static Gson GSON = new Gson();
    public Map<String,Object> context = new HashMap<String,Object>();

    @Given ("a collection representing the linking value of each dish '$list'")
    public void givenCollection(@Value("list") String list){
        ArrayList<Double> listGson = GSON.fromJson(list, ArrayList.class);
        int [] listDish = listGson.stream().mapToInt(Double::intValue).toArray();
        //        String json = "{list:\"" + list + "\"}";
//      ListDish listDish = GSON.fromJson(json, ListDish.class);
        context.put("listDish", listDish);
        logger.info("1 - a collection representing the linking value of each dish");
    }
    @When ("evaluate the coeffient  of this collection")
    public void whenEvaluateCoefficient (){
        int [] array = (int []) context.get("listDish");
        LikeToTimeDishes.Solution calculateSolution = likeToTimeDishes.calculateSolution(array);
        int coefficient = calculateSolution.getCoefficient();
        context.put("coefficient",coefficient);
        logger.info("2 - evaluate the coeffient  of this collection");

    }
    @Then ("the  coeffient  should be equals to '$coeffient'")
    public void thenCheckTheCoefficientValue(@Value("$coeffient") String coeffient){
        int parseIntCoefficient = Integer.parseInt(coeffient);
        Integer expectCoefficient = (Integer)context.get("coefficient");
        Assert.assertEquals( parseIntCoefficient,expectCoefficient.intValue() );
        logger.info("3 - the  coeffient  should be equals to" + coeffient);

    }
}
