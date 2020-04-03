package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.HomePage;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultClickedSteps extends AbstractSteps {

    @Autowired
    HomePage homePage;

    @When("I click on buy button")
    public void iClickOnBuy(){
        homePage.clickBuy();
    }

    @When("I click on continue")
    public void iClickOnContinue(){
        homePage.clickContinue();
    }

    @When("I click on continue shopping")
    public void iClickOnContinueShopping(){
        homePage.clickContinueShopping();
    }



}
