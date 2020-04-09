package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private String appUrl;

    @Given("I a model '$template'")
    public void givenAModel(@Named("template") String template) {
        DocumentContext json =  jsonUtil.loadJson(template);
        context.saveResource("payloadCart", json);
    }

    @Given("a product '$product'")
    public void givenAProduct(@Named("product") String product) {
        DocumentContext json = (DocumentContext)context.getResource("payloadCart");
        System.out.println(json.toString() + "   ====================        ================       ==============");
        json.jsonString();
    }

    @Given("I put it on the cart")
    public void putOnTheCart() {

    }

    @When("I get the product by '$id'")
    public void getProductById(@Named("id") int id) {
        System.out.println(id + " =======   ID    =======");
    }

    @Then("I want se '$result'")
    public void checkGetResult(@Named("result") String product) {
        System.out.println(product + " ===================    Product    ============");
    }

}
