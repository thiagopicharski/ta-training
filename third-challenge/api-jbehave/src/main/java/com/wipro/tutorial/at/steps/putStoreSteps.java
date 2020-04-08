package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.text.Document;

public class putStoreSteps  extends AbstractSteps {

    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Given("Some product with  model '$template'")
    public void someProduct(@Named("template") String template) {
        DocumentContext productJson = jsonUtil.loadJson(template);
        context.saveResource("payload", productJson);
    }

    @When("I set the product description to '$description'")
    public void setSomeProductDescription(@Named("description") String description) {
        DocumentContext descriJson = (DocumentContext) context.getResource("payload");
        descriJson.set("description", descriJson);
    }

    @When("I set the product value to '$value'")
    public void setSomeProductValue(@Named("value") double value) {
        DocumentContext valueJson = (DocumentContext) context.getResource("payload");
        valueJson.set("value", valueJson);
    }

    @When("I set the product weight to '$weight'")
    public void setSomeProductWeight(@Named("weight") double weight) {
        DocumentContext weightJson = (DocumentContext) context.getResource("payload");
        weightJson.set("weight", weightJson);

    }

    @When("I add the product to the cart")
    public void setSomeProductCart() {
        DocumentContext cartJson = (DocumentContext) context.getResource("payload");
        LOGGER.info("JSON: " + cartJson.jsonString());
        String cartResult = RestUtil.sendPut(cartUrl + "product", cartJson.jsonString());
        context.saveResource("cartResult", cartResult);

    }

    @When("I add the product to the cart'")
    public void setSomeProductToCart(@Named("id") String id) {
        DocumentContext toCartJson = (DocumentContext) context.getResource("payload");
        LOGGER.info("JSON: " + toCartJson.jsonString());
        String toCartResult = RestUtil.sendPut(cartUrl + "/product", toCartJson.jsonString());
        context.saveResource("toCartResult", toCartResult);

    }

    @Then("I shoul see product added to the cart")
    public void addedToCart(){
        String addedResult = (String) context.getResource("result");
        LOGGER.info("REST_RESULT: " + addedResult);
    }
}