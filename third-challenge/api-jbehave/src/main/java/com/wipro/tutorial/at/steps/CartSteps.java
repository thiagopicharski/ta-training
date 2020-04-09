package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private String appUrl;

    @Given("I a model '$template'")
    public void givenAModel(@Named("template") String template) {
        DocumentContext json = jsonUtil.loadJson(template);
        context.saveResource("payloadTemplate", json);
        LOGGER.info("TEMPLATE_JSON: " + json.jsonString());
    }

    @Given("a product '$product'")
    public void givenAProduct(@Named("product") String product) {
        DocumentContext json = jsonUtil.loadJson(product);
        context.saveResource("jsonProductCreated", json);
        LOGGER.info("PRODUCT_CREATED: " + json.jsonString());
    }

    @Given("I put it on the cart")
    public void putOnTheCart() {
        DocumentContext json = (DocumentContext)context.getResource("jsonProductCreated");
        String restResult = RestUtil.sendPost(appUrl + "/cart/product", json.jsonString());
    }

    @When("I get the product by '$id'")
    public void getProductById(@Named("id") int id) {
        String restResult = RestUtil.sendGet(appUrl + "/product" + id);
        DocumentContext json = jsonUtil.loadJson(restResult);
        context.saveResource("jsonGet", json);
        DocumentContext jsonProductCreated = (DocumentContext)context.getResource("jsonProductCreated");
        LOGGER.info("PRODUCT_GET: " + json.jsonString());
        Assert.assertEquals(json.jsonString(), jsonProductCreated.jsonString());
    }

    @Then("I want se '$result'")
    public void checkGetResult(@Named("result") String result) {
        String jsonResult = jsonUtil.loadJson(result).jsonString();
        DocumentContext jsonGet = (DocumentContext)context.getResource("jsonGet");
        LOGGER.info("RESULT: " + jsonResult);
        Assert.assertEquals(jsonResult, jsonGet.jsonString());
    }

}
