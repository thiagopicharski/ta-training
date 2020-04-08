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

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Component
public class CartSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private String cartDetailUrl;
    @Value("${cart.add}")
    private String cartAddUrl;
    @Value("${cart.create}")
    private String cartCreateUrl;
    @Value("${cart.delete}")
    private String cartDeleteUrl;
    @Value("${cart.shipment}")
    private String cartShipmentUrl;
    @Value("${product.detail}")
    private String productDetailUrl;

    private String result;
    private int cartId;

    @Given("A product")
    public void givenProduct(){
    }

    @When("I add a '$product' in a cart")
    public void addProductInCart(@Named("cart") String product){
        this.result = RestUtil.sendPut(cartCreateUrl, product);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @Then("The product should be on cart")
    public void productOnCart(String json){
        DocumentContext cart = jsonUtil.loadJson(this.result);
        assertEquals(new Integer(1), cart.read("$.products.length()", Integer.class));
    }

    @Given("A cart with the product id '$id'")
    public void cartWithProduct(@Named("id") Integer id){
        String product = RestUtil.sendGet(String.format(productDetailUrl, id));
        this.result = RestUtil.sendPut(cartCreateUrl, product);
        this.cartId = jsonUtil.loadJson(result).read("$.id", Integer.class);
        RestUtil.sendPut(String.format(cartAddUrl, cartId), product);
    }

    @When("I remove the product id '$id'")
    public void removeProduct(@Named("product") int productId){
        this.result = RestUtil.sendDelete(String.format(cartDeleteUrl, cartId, productId));
    }

    @Then("The cart should be empty")
    public void cartEmpty(){
        DocumentContext cart = jsonUtil.loadJson(this.result);
        assertEquals(new Integer(0), cart.read("$.products.length()", Integer.class));
    }

    @Given("A cart with a '$product'")
    public void cartWithProduct(@Named("product") String product){
        this.result = RestUtil.sendPut(cartCreateUrl, product);
        this.cartId = jsonUtil.loadJson(result).read("$.id", Integer.class);
        RestUtil.sendPut(cartCreateUrl, product);
    }

    @When("I calculate the shipment '$shipment'")
    public void calculateShipment(@Named("shipment") String shipment){
        this.result = RestUtil.sendPost(String.format(cartShipmentUrl, cartId), shipment);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @Then("The value should be equals to '$value'")
    public void finalValue(@Named("value") double value){
        DocumentContext dc = jsonUtil.loadJson(this.result);
        assertEquals(value, dc.read("$.value", Double.class).doubleValue());
    }

}
