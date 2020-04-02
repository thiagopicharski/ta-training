package trainning.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import trainning.LikeToTimeDishes;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MySteps {
    LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    static Logger log = Logger.getLogger(MySteps.class.getName());
    List<Integer> dishesArray = new ArrayList<>();
    List<Integer> dishesArrayPostRemoval = new ArrayList<>();

    @Given("I have an array $arrayOfDishes of dishes")
    public void array(@Value("arrayOfDishes") List<Integer> dishes) {
        Assert.assertNotNull("Array is null", dishes);
        Assert.assertFalse("Array is empty", dishes.isEmpty());
        log.info(dishes);
        dishesArray.addAll(dishes);
        dishesArrayPostRemoval.addAll(dishes);
        log.info(likeToTimeDishes.calculateSolution(dishesArray.stream().mapToInt(i -> i).toArray()).toString());

    }

    @Given("I want to be able to remove $dish in the $dishes array")
    public void givenIWantToBeAbleToRemoveSomeDishes(@Value("dish") int dish, @Value("dishes") List<Integer> dishes) {
        Assert.assertTrue(dishes.remove((Integer) dish));
        dishesArrayPostRemoval.remove((Integer) dish);
    }

    @Then("a new coefficient is calculated usign the left dishes")
    public void thenANewCoefficientIsCalculatedUsignTheLeftDishes() {
        log.info(likeToTimeDishes.calculateSolution(dishesArray.stream().mapToInt(i -> i).toArray()).toString());
        log.info(likeToTimeDishes.calculateSolution(dishesArrayPostRemoval.stream().mapToInt(i -> i).toArray()).toString());
        Assert.assertNotEquals(likeToTimeDishes.calculateSolution(dishesArray.stream().mapToInt(i -> i).toArray()).toString(),
                likeToTimeDishes.calculateSolution(dishesArrayPostRemoval.stream().mapToInt(i -> i).toArray()).toString());
    }
    @Given("I want to be calculate the maximum sum of all possible coefficients")
    @Then("a maximum sum is calculated")
    public void iWantToCalculateTheMaximumSumOfAllPossiblesCoefficients(){

    }
}
