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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Component
public abstract class ProductSteps extends AbstractSteps {

    private String product;
    private String response;
    private int productId;
    private int cartId;

    @Value("${api.cart.create}")
    private String createCart;
    @Value("${api.cart.product.add}")
    private String addProduct;

    @Given("a '$product'")
    public void givenAProduct(@Named("product") String product) {
        this.product = product;
    }

    @When("I create a cart and put a product")
    public void createNewCartWithProduct() {
        this.response = RestUtil.sendPut(this.createCart, this.product);
    }

    @Then("I should see the response with a product of '$price' in the cart")
    public void thenISeeResponse(@Named("price") int price) {
        DocumentContext context = jsonUtil.loadJson(this.response);
        int cartId = context.read("$.id", Integer.class).intValue();
        assertTrue(cartId > 0);
        int productPrice = context.read("$.products[0].value", Integer.class).intValue();
        assertEquals("The price of product in the car is", price, productPrice);
    }

    @Given("a '$product' in the cart")
    public void createNewCartWithProduct(@Named("product") String product) {
        this.givenAProduct(product);
        this.createCart();
        this.productId = jsonUtil.loadJson(this.response).read("$.products[0].id", Integer.class);
    }

    @When("I delete the product")
    public void whenDeleteProduct() {
        this.response = RestUtil.sendDelete(product);
    }

    @Then("I should see the response without product")
    public void thenISeeResponseWithoutProduct() {
        assertEquals(0, jsonUtil.loadJson(this.response)
                .read("$.products.length{}", Integer.class).intValue());
    }
}
