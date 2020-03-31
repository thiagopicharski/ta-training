package org.example.steps;

import org.apache.log4j.Logger;
import org.example.firstChallenge.LikeToTimeDishes;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySteps {

    private Logger logger = Logger.getLogger(MySteps.class);
    private LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    private LikeToTimeDishes.Solution solution;
    private int[] input;

    @Given("I receive the value of dishes '$field'")
    public void reciveTheList(@Value("field") List<Integer> list){
        input = list.stream().mapToInt(i->i).toArray();
    }


    @When("I calculate the solution")
    public void pendingStep2(){
        solution = likeToTimeDishes.calculateSolution(input);
        int[] preparedDishes = solution.getPreparedDishes();
        List<Integer> preparedDishes1 = new ArrayList<>();
        List<Integer> removed = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            if(preparedDishes[i]!=input[i]){
                removed.add(input[i]);
                preparedDishes[i]=0;
            }
            else
                preparedDishes1.add(input[i]);
        }
        int[] array = preparedDishes1.stream().mapToInt(i->i).toArray();
        if(!removed.isEmpty()){
            solution = likeToTimeDishes.calculateSolution(array);
            logger.info("Removed: input:"+Arrays.toString(input)+" #Dish "+Arrays.toString(removed.toArray())+" must be removed");
        }
        else{
            logger.info("Not Removed: input: "+Arrays.toString(input));
        }
    }

    @Then("I shall see the coeffient: '$coeffient'")
    public void pendingStep3(@Value("field") int a){
        int coef = solution.getCoefficient();
        logger.info("Output: " + coef);
        Assert.assertEquals(a,coef);
    }

}
