package com.wipro.ta.steps;

import com.google.gson.Gson;
import com.wipro.ta.LikeToTimeDishes;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;

public class DishesRemovedSteps {


    private Logger logger = Logger.getLogger(DishesRemovedSteps.class);

    public static LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    public static Gson GSON = new Gson();
    public Map<String,Object> context = new HashMap<String,Object>();

    @Given ("a collection representing the value of each dish '$list1'")
    public void givenCollection(@Value("list1") String list1){
        ArrayList<Double> listGson = GSON.fromJson(list1, ArrayList.class);
        int [] listDish = listGson.stream().mapToInt(Double::intValue).toArray();
        //        String json = "{list:\"" + list + "\"}";
//      ListDish listDish = GSON.fromJson(json, ListDish.class);
        context.put("listDish", listDish);
        logger.info("1 - a collection representing the value of each dish");
    }
    @When ("i remove dishes from the collection '$removedDishes' to evaluate the coeffient")
    public void whenRemovedDishes(@Value("$removedDishes") String removedDishes){
        ArrayList<Double> list = GSON.fromJson(removedDishes, ArrayList.class);
        int [] array = list.stream().mapToInt(Double::intValue).toArray();
        List<Integer> listRemoved = Arrays.stream(array).boxed().collect(Collectors.toList());
        int [] arrayDishes = (int []) context.get("listDish");
        List<Integer> listWihtoutRemovedDishes = Arrays.stream(arrayDishes).boxed().collect(Collectors.toList());
        listWihtoutRemovedDishes.removeAll(listRemoved);
        int [] arrayDishesWihtoutRemovedDishes = listWihtoutRemovedDishes.stream().mapToInt(i->i).toArray();

        LikeToTimeDishes.Solution calculateSolution = likeToTimeDishes.calculateSolution(arrayDishesWihtoutRemovedDishes);
        int coefficient = calculateSolution.getCoefficient();
        context.put("coefficient",coefficient);
        logger.info("2 - i remove dishes from the collection '$removedDishes' to evaluate the coeffient" + coefficient);

    }
    @Then ("the  coeffient of the list with removed values  should be equals to '$coeffient1'")
    public void thenCheckTheCoefficientValue(@Value("$coeffient1") String coeffient1){
        int parseIntCoefficient = Integer.parseInt(coeffient1);
        Integer expectCoefficient = (Integer)context.get("coefficient");
        Assert.assertEquals( parseIntCoefficient,expectCoefficient.intValue() );
        logger.info("3 - the  coeffient of the list with removed values  should be equals to " + coeffient1);

    }
}
