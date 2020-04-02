package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ProductPage;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

@Component
public class ProductPageSteps extends AbstractSteps {

    @Autowired
    ProductPage productPage;

    @Then("I get redirected to a page that contains add to cart button")
    public void pageContainsAddToCart(){
        assertTrue(productPage.containsAddButton());
    }

    @Given("I searched for '$item' and clicked the first result")
    @Composite(steps = {
            "Given I search for '$item'",
            "When I select the first item"})
    public void searchItem(@Named("item") String item){

    }

    @When("I add item to cart")
    public void addToCart(){
        productPage.clickAddButton();
    }

}
