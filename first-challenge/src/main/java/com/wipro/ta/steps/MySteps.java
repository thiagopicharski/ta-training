package com.wipro.ta.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MySteps {

    @Given("some 'dishes'")
    public void parseDishes(){
        System.out.println("uwu");
    }
    @Given("a solution")
    public void solutionForDish(){

        System.out.println("uwu");
    }
    @When("I remove a 'dish'")
    public void removeDish(){
        System.out.println("uwu");

    }
    @Then("I get a new coefficient")
    public void thenNewCoefficient(){
        System.out.println("uwu");

    }


}
