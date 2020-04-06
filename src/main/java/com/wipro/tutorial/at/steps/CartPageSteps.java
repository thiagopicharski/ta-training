package com.wipro.tutorial.at.steps;


import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.tutorial.at.pages.CartPage;

@Component
public class CartPageSteps extends AbstractSteps {

    @Autowired
    private CartPage cartPage;

    @Then("I should see the selected product in cart")
    public void IShouldSeeTheSelectedProductInCart() {
        assertTrue(cartPage.checkProductIsInCart());
    }

}
