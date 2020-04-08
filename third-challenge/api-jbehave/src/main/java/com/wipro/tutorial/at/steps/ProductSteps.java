package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ProductSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private String appUrl;

    @Given("A product in the API'")
    public void givenAProduct( String template) {
        DocumentContext json = jsonUtil.loadJson(template);
        context.saveResource("payload", json);
    }

    @Given("A product in the cart ")
    public void productInCart() {
    	
    }
    
    @Given("A product in the cart ")
    public void productInCartUpdate() {
    }

    
    
    @When("I  add a product  to the  cart")
    public void addToCart() {
    	DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPost(appUrl, json.jsonString());
        context.saveResource("result", result);
    }
    
    @When(" I remove the  product to  the cart")
    public void removeToCart() {
    	DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPost(appUrl, json.jsonString());
        context.removeResource("result", result);
    }
    
    @When("I update the product ")
    public void uptadeProduct() {
    	DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPost(appUrl, json.jsonString());
        context.updateResource("result", result);
    	
    }
    
    
    
    @Then("I  should see the product in the cart")
    public void thenSeeTheProducts() {
    	 String result = (String) context.getResource("result");
         LOGGER.info("REST_RESULT: " + result);
    }
    
    @Then("I  get the cart empty")
    public void cartEmpty() {
    	LOGGER.info("REST_RESULT: " + appUrl);
    }
    
    @Then("I  changed the cart")
    public void updateCart() {
    	LOGGER.info("REST_RESULT: " + appUrl);
    }
    
   
}
