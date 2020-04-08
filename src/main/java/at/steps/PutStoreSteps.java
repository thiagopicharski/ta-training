package at.steps;

import at.util.RestUtil;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PutStoreSteps extends AbstractSteps {

    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Given("A shipment model '$template'")
    public void givenAProduct(@Named("template") String template) {
        DocumentContext json = jsonUtil.loadJson(template);
        context.saveResource("payload", json);
        LOGGER.info("Loading template");
    }

    @When("I set product description to '$description'")
    public void setProductDescription(@Named("description") String description) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("description", description);
    }

    @When("I set product value to '$value'")
    public void setProductValue(@Named("value") double value) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        json.set("value", value);
    }

    @When("I set product weight to '$weight'")
    public void setProductWeight(@Named("weight") double weight) {
        DocumentContext json = (DocumentContext) context.getResource("payload");
        json.set("weight", weight);
    }

    @When("I add the product to the cart")
    public void setProductCart() {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPut(cartUrl + "product", json.jsonString());
        context.saveResource("result", result);
    }

    @When("I add the product to the cart '$id'")
    public void setProductToSpecificCart(@Named("id") String id) {
        DocumentContext json = (DocumentContext)context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPut(cartUrl +id+ "/product", json.jsonString());
        context.saveResource("result", result);
    }

    @Then("I should not see any error")
    public void thenNoErrors() {
        String result = (String) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result);
    }
}