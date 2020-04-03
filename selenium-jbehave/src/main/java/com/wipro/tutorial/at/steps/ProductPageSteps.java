package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ProductPage;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductPageSteps extends AbstractSteps {

    @Autowired
    private ProductPage productPage;

    @When("I choose the size")
    public void chooseSize(){
        productPage.chooseSize();
    }

    @When("I click on buy button")
    public void clickOnBuyButton(){
        productPage.clickBuyButton();
    }

}
