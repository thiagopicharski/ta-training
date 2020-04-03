package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.FinalPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FinalPageSteps extends AbstractSteps {

    @Autowired
    private FinalPage finalPage;

    private String productName;

    @When("I click on the cart")
    public void clickOnCart(){
        productName = finalPage.getProductName();
    }

    @Then("I should see the item on cart")
    public void checkIfItemIsOnCart(){
        Assert.assertTrue(finalPage.getProductNameOnCart().contains(productName));
    }

}
