package com.wipro.tutorial.at.steps;

import com.google.gson.Gson;
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
public class HeroSteps extends AbstractSteps {
    @Value("${app.base.url}")
    private String appUrl;


    private Gson changeToString;

    @Value("${app.base.auth}")
    private String userAuth;

    @Given("I am on a product store with model '$template'")
    public void givenAProduct(@Named("template") String template) {
        DocumentContext json = jsonUtil.loadJson(template);
        RestUtil.setUserAuth(userAuth);
        context.saveResource("payload", json);
    }

    @When("I request the product with the '$id'")
    public void requestProduct(@Named("id") String id) {
        String result = RestUtil.sendGet(appUrl + "api/product/"+id);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @When("I patch the product with the '$id' with '$description' and '$weight' and '$value'")
    public void patchProduct(@Named("id") int id,
                             @Named("description") String description,
                             @Named("weight") double weight,
                             @Named("value") double value) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("id", id);
        json.set("description", description);
        json.set("weight", weight);
        json.set("value", value);
        LOGGER.info("JSON: " + json.jsonString());

        String result = RestUtil.sendPatch(appUrl + "api/product/"+id,json.jsonString());


        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @Then("I should not see any error")
    public void thenNoErrors() {
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result.jsonString());
    }
    @Then("I should see a 404 error")
    public void thenAreErrors() {
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result.jsonString());
    }

    @Then("I should receive a list of heroes")
    public void thenReceiveHeroes() {
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("Result: " + result.jsonString());
    }
}
