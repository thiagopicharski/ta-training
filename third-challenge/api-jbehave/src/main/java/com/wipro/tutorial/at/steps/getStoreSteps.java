package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.text.Document;

@Component
public class getStoreSteps extends AbstractSteps {

    // @Value("$(app.base.url)cart")
    private String cartUrl = "http://admin:password@training.33b096.rest.picz.com.br:8197/api/cart/";

    @Value("$(app.base.url)product/")
    private String productUrl;

    @Given("I am on the store")
    public void onTheStore() {

    }

    @When("I make a request to a cart with id '$id'")
    public void requestCart(@Named("id") String id) {
        String requestResult = RestUtil.sendGet("http://admin:password@training.33b096.rest.picz.com.br:8197/api/cart/" + id);
        DocumentContext documentContext = JsonPath.parse(requestResult);
        context.saveResource("requestResult", documentContext);
        LOGGER.info("Returning the cart with an id " + id);
    }

    @When("I make a request to a list of carts")
    public void requestCartList() {
        String requestResult = RestUtil.sendGet(cartUrl);
        DocumentContext documentContext = JsonPath.parse(requestResult);
        context.saveResource("requestResult", documentContext);
    }

    @When("I make a request to a product with id '$id'")
    public void requestProduct(@Named("id") String id) {
        String resultProduct = RestUtil.sendGet("http://admin:password@training.33b096.rest.picz.com.br:8197/api/product/" + id);
        DocumentContext documentContext = JsonPath.parse(resultProduct);
        context.saveResource("resultProduct", documentContext);
        LOGGER.info("Returning the cart with an id " + id);
    }

    @When("I request some product list that's in a cart with id '$id'")
    public void requestProductList(@Named("id") String id) {
        String resultProductList = RestUtil.sendGet(cartUrl + id + "/products");
        DocumentContext documentContext = JsonPath.parse(resultProductList);
        context.saveResource("resultProductList", documentContext);
        LOGGER.info("Returning the cart with an id " + id);
    }

    @Then("I should receive the cart")
    public void receiveCart() {
        DocumentContext resultCart = (DocumentContext) context.getResource("requestResult");
        Assert.assertNotNull(resultCart.read("$.id"));
        LOGGER.info("The cart: " + resultCart.jsonString());
    }

    @Then("I should receive the list of carts")
    public void receiveCartList() {
        DocumentContext resultCartList = (DocumentContext) context.getResource("requestResult");
        Assert.assertNotNull(resultCartList);
        LOGGER.info("The cart list of size: " + resultCartList.jsonString());
    }

    @Then("I should receive the product")
    public void receiveProduct() {
        DocumentContext resultProduct = (DocumentContext) context.getResource("resultProduct");
        Assert.assertNotNull(resultProduct);
        LOGGER.info("The product: " + resultProduct.jsonString());
    }

    @Then("I should see the product list")
    public void receiveProductList() {
        DocumentContext receiveProductList = (DocumentContext) context.getResource("resultProductList");
        Assert.assertNotNull(receiveProductList);
        LOGGER.info("The product list :" + receiveProductList.jsonString());
    }
}