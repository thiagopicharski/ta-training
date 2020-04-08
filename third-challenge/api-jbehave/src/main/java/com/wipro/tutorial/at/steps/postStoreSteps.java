package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;

public class postStoreSteps extends AbstractSteps {
    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Given("Some shipment with model '$template'")
    public void someShipment(@Named("template") String template){
        DocumentContext tempJson = jsonUtil.loadJson(template);
        context.saveResource("payload", tempJson);
        LOGGER.info("The shipment template");
    }

    @Given("I set my cep to '$cep")
    public void someShipmentSetCep(@Named("cep") String cep){
        DocumentContext cepJson = (DocumentContext)context.getResource("payload");
        cepJson.set("cep", cep);
    }

    @When("I want to make a count of the total in the cart with id '$id'")
    public void countShipment(@Named("id") String id){
        DocumentContext countJson = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + countJson.jsonString());
        String countResult = RestUtil.sendPost(cartUrl + id + "/shipment", countJson.jsonString());
        context.saveResource("countResult", countResult);
    }

    @Then("I should see the total count of the shipment")
    public void receiveShipmentTotal(){
        String shipResult = (String) context.getResource("shipResult");
        LOGGER.info("REST_RESULT: " + shipResult);
    }
}