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

    @Value("${app.base.url}/product")
    private String appUrl;

    @Given("A product '$template'")
    public void givenAHero(@Named("template") String template) {
        DocumentContext json = jsonUtil.loadJson(template);
        context.saveResource("payload", json);
    }

    @When("I request the list of heroes")
    public void requestHeroes() {
        String result = RestUtil.sendGet(appUrl);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @When("I set the product's description to '$description'")
    public void setProductDescription(@Named("description") String description) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("description", description);
    }

    @When("And I set product value to '$value'")
    public void setProductValue(@Named("value") String value) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("value", value);
    }

    @When("And I set product weight to '$weight'")
    public void setProductWeight(@Named("weight") String weight) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("weight", weight);
    }

    @When("I add the product to the cart")
    public void setHeroStore() {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPost(appUrl, json.jsonString());
        context.saveResource("result", result);
    }

    @Then("I should not see any error")
    public void thenNoErrors() {
        String result = (String) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result);
    }
}
