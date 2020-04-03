package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.CartPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Component
public class CartPageSteps extends AbstractSteps{

    @Autowired
    CartPage cartPage;

    @Then("cart contains '$result'")
    public void containsItem(@Named("result") String itemTitle){
        List<String> itemTitles = cartPage.getCartItems();
        assertTrue(itemTitles.contains(itemTitle));
    }

}
