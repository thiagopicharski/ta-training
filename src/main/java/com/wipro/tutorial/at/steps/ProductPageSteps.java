package com.wipro.tutorial.at.steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.tutorial.at.pages.ResultsPage;
import com.wipro.tutorial.at.pages.ProductPage;

@Component
public class ProductPageSteps extends AbstractSteps {

    @Autowired
    private ProductPage productPage;

    @When("I add it to cart")
    public void IAddItToCart() {
        productPage.addToCart();
    }

}
