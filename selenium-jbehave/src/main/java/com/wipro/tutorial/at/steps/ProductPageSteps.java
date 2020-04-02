package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ProductPage;
import org.jbehave.core.annotations.Then;
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

}
