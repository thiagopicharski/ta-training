package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ItemPage;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPageSteps extends AbstractSteps {

    @Autowired
    ItemPage itemPage;

    @When("Add the item to cart")
    public void addItemToCart(){
        itemPage.buyItem();
    }
}
