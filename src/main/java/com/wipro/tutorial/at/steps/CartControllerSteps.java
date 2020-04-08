package com.wipro.tutorial.at.steps;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.wipro.tutorial.at.util.Cart;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
    public void verifyIfProductHasBeenAdded(@Named("description") String description) {
        String result = RestUtil.sendGet(cartApi);
        List<Cart> carts = Arrays.asList(gson.fromJson(result, Cart[].class));
        Assert.assertTrue("The product is present", carts.stream().anyMatch(cart -> Arrays.stream(cart.getProducts()).anyMatch(product -> {
            return product.getDescription().equals(description);
        })));
    }

    @Then("I verify if the cart with id $id has been added")
    @Given("the cart with id $id is present")
    public void verifyIfCartIsPresent(@Named("id") int id) {
        String result = RestUtil.sendGet(cartApi + "/" + id);
        if (result.contains("httpStatus") || result.contains("not found")) {
            throw new AssertionError();
        } else {
            Cart carts = gson.fromJson(result, Cart.class);
            Assert.assertEquals("The cart is present", carts.getId(), id);
        }
    }

    @Then("I add a product with description $description, value $value and weight $weight to the cart with id $id")
    public void addProductToCart(@Named("description") String description, @Named("value") int value, @Named("weight") int weight, @Named("id") int id) {
        DocumentContext json = (DocumentContext) context.getResource("payload");
        json.set("description", description);
        json.set("value", value);
        json.set("weight", weight);
        LOGGER.info("JSON: " + json.jsonString());
        String result = RestUtil.sendPut(cartApi + "/" + id + "/product", json.jsonString());
        LOGGER.info("PUT Response " + result);
        context.saveResource("result", result);
    }

    @Then("Then I delete the product with id $id inside cart with id $cartId")
    public void deleteProductWithIdInsideCart(@Named("id") int productId, @Named("cartId") int cartId) {
        String result = RestUtil.sendGet(cartApi + "/" + cartId);
        if (result.contains("httpStatus") || result.contains("not found")) {
            throw new AssertionError();
        } else {
            Cart carts = gson.fromJson(result, Cart.class);
            Arrays.stream(carts.getProducts()).filter(product -> product.getId() == productId).findAny().ifPresent(product -> {
                String res = RestUtil.sendDelete(cartApi + "/" + cartId + "/product" + "/" + productId);
                if (result.contains("httpStatus") || result.contains("not found")) {
                    throw new AssertionError();
                }
            });
        }
    }

    @Then("I remove everything with description $description")
    public void removeEverythingWithDescription(@Named("description") String description) {
        String result = RestUtil.sendGet(cartApi);
        List<Cart> carts = Arrays.asList(gson.fromJson(result, Cart[].class));
        carts.forEach(cart -> {
            Arrays.stream(cart.getProducts()).filter(product -> product.getDescription().equals(description)).forEach(product -> {
                String res = RestUtil.sendDelete(cartApi + "/" + cart.getId() + "/product" + "/" + product.getId());
                if (res.contains("httpStatus") || res.contains("not found")) {
                    throw new AssertionError();
                }
            });
        });
    }

}
