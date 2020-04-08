package at.steps;

import at.util.RestUtil;
import com.jayway.jsonpath.DocumentContext;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostStoreSteps extends AbstractSteps {
    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Given("A product model '$template'")
    public void givenAShipment(@Named("template") String template) {
        DocumentContext json = jsonUtil.loadJson(template);
        context.saveResource("payload", json);
        LOGGER.info("Loading shipment template");
    }

    @Given("I set my cep to '$cep'")
    public void setShipmentCep(@Named("cep") String cep){
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("cep", cep);
    }

    @When("I want to calculate the total price in the cart with id '$id'")
    public void calculateShipment(@Named("id") String id){
        DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPost(cartUrl +id+ "/shipment", json.jsonString());
        context.saveResource("result", result);
    }

    @Then("I should see the total price for shipment")
    public void receiveShipmentTotalCosts(){
        String result = (String) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result);
    }
}
