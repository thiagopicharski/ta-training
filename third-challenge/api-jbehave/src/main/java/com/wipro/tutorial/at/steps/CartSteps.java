package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.entities.CartOperations;
import com.wipro.tutorial.at.entities.EntityUtils;
import com.wipro.tutorial.at.entities.ProductOperations;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartSteps extends AbstractSteps {

    @Autowired
    private ProductOperations productOperations;

    @Autowired
    private CartOperations cartOperations;

    @Autowired
    private EntityUtils entityUtils;

    private String response;

    @Given("no cart")
    public void noop(){

    }


    @When("I add '$product' to a cart's products")
    public void addProduct(@Named("product") String productJson) {
        LOGGER.info("Adding product to new cart");
        this.response = cartOperations.createCart(productJson);
    }


    @Then("I should get a cart with a single product in it")
    public void cartHasProduct(){
        DocumentContext cart = jsonUtil.loadJson(cache.getResponseBody());
        Assert.assertEquals(new Integer(1), cart.read("$.products.length()", Integer.class));
    }


}
