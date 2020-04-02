package com.wipro.tutorial.at.steps;


import org.jbehave.core.annotations.Then;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.tutorial.at.pages.ProductPage;

@Component
public class ProductPageSteps extends AbstractSteps {

    @Autowired
    private ProductPage productPage;

    @Then("I click the buy button and add it to the cart")
    public void clickBuyButtonAndAddToCart() {
        productPage.clickBuyButton();
    }
}
