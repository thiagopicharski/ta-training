package com.wipro.tutorial.at.steps;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.wipro.tutorial.at.util.Cart;
import com.wipro.tutorial.at.util.Product;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
public class CartControllerSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private String appUrl;
    @Value("${app.base.url}/api/cart")
    private String cartApi;
    @Value("${app.base.url}/api/cart/product")
    private String productApi;
    Gson gson = new Gson();
    @Given("I am on a store with model '$template'")
    public void givenAHero(@Named("template") String template) {
        LOGGER.info(appUrl + '\n' + cartApi + '\n' + productApi);
        DocumentContext json = jsonUtil.loadJson(template);
        context.saveResource("payload", json);
    }

    @Then("I get the list of products")
    public void getListOfProducts() {
        String result = RestUtil.sendGet(cartApi);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @Given("I add a product to the store with description $description, value $value and weight $weight")
    public void addProductToList(@Named("description") String description, @Named("value") int value, @Named("weight") int weight) {
        DocumentContext json = (DocumentContext) context.getResource("payload");
        json.set("description", description);
        json.set("value", value);
        json.set("weight", weight);
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPut(productApi, json.jsonString());
        LOGGER.info("PUT Response " + result);
        context.saveResource("result", result);
    }
    @Then("I verify if the product with description $description has been added")
    public void verifyIfProductHasBeenAdded(@Named("description") String description){
        String result = RestUtil.sendGet(cartApi);
        List<Cart> carts = Arrays.asList(gson.fromJson(result, Cart[].class));
        carts.forEach(cart -> {
            Arrays.asList(cart.getProducts()).forEach(product -> {
                LOGGER.info(product.toString());
            });
        });
        //Assert.assertTrue("The product is present", products.stream().anyMatch(product -> product.getDescription().equals(description)));
    }

    @When("I set the hero's superpower to '$superpower'")
    public void setHeroSuperpower(@Named("superpower") String superpower) {
        DocumentContext json = (DocumentContext) context.getResource("payload");
        json.set("superpower", superpower);
    }

    @When("I add the hero to store")
    public void setHeroStore() {
        DocumentContext json = (DocumentContext) context.getResource("payload");
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPost(appUrl, json.jsonString());
        context.saveResource("result", result);
    }

    @Then("I should not see any error")
    public void thenNoErrors() {
        String result = (String) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result);
    }

    @Then("I should receive a list of heroes")
    public void thenReceiveHeroes() {
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("Result: " + result.jsonString());
    }
}
