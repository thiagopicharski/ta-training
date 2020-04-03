package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.CartPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartPageSteps {

    @Autowired
    private CartPage cartPage;

    @Then ("I should see the '$product' added in cart")
    public void iShouldSeeTheProductAddedToTheCart(@Named("product") String product){
        Assert.assertTrue(cartPage.isIteminTheCart(product));

    }
}
