package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ShoppingCartPage;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.jbehave.core.annotations.Then;

import static org.junit.Assert.assertTrue;

@Component
public class ShoppingCartPageSteps extends AbstractSteps {

    @Autowired
    private ShoppingCartPage shoppingCartPage;

    @Then("I should see the product in the shopping cart")
    public void IShouldSeeTheProductInTheShoppingCart() {
        assertTrue(shoppingCartPage.checkProductIsInCart());
    }
}
