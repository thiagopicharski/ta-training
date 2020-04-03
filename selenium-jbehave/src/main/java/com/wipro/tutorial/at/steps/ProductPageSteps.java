package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ProductPage;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductPageSteps {
    @Autowired
    private ProductPage productPage;
    @When ("I add to the cart")
    public void iAddToCart(){
        productPage.clickFirstResult();
        productPage.clickCartButton();
    }

}
