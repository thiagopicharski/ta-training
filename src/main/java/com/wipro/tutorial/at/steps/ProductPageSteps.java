package com.wipro.tutorial.at.steps;


import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.tutorial.at.pages.ProductPage;

@Component
public class ProductPageSteps extends AbstractSteps{

    @Autowired
    public ProductPage productPage;


    @Then("I add it to my cart and verify it")
    public void AddToCartAndVerifyTheProduct(){
        productPage.addToCartAndVerify();
    }

}
