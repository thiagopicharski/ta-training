package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartSteps extends AbstractSteps {

    @Autowired
    Cache cache;

    private DocumentContext product;

    private String resultBody;


    @Given("no cart")
    public void nop(){

    }

    @Then("I should get a cart with a single product in it")
    public void cartHasProduct(){
        DocumentContext cart = jsonUtil.loadJson(cache.getResponseBody());
        Assert.assertEquals(new Integer(1), cart.read("$.products.length()", Integer.class));
    }

}
