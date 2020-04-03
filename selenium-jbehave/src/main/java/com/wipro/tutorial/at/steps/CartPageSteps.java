package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.CartPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;

@Component
public class CartPageSteps extends AbstractSteps {

    @Autowired
    private CartPage cartPage;

    @Then("I should see the '$item' at the cart")
    public void IShouldSeeItemAtCart(@Named("item") String nameExpected) {
        assertEquals(nameExpected, cartPage.firstItemText());
    }
}
