package com.wipro.tutorial.at.steps;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.wipro.tutorial.at.json.Cart;
import com.wipro.tutorial.at.util.RestUtil;
import org.checkerframework.checker.units.qual.C;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private String appUrl;
    private static String PRODUCT = "/product";
    private static String CART = "/cart";
    private String productJson;
    private String cartJson;
    private Gson gson;

    @Given("a cart")
    public void aCart(){

    }
    @When("I add a product with '$id' to the cart")
    public void addProductsToTheCart(@Named("id") String id){
        productJson = RestUtil.sendGet(appUrl + PRODUCT + "/" +id);
        cartJson = RestUtil.sendPut(appUrl + CART + PRODUCT, productJson);
    }
    @Then("I should see the product on the cart")
    public void returnCart(){
        Cart cart = new Cart();
        cart = gson.fromJson(cartJson, Cart.class);
        System.out.println(cart.getId());
        System.out.println(cart.getTotal());
        System.out.println(cart.getProducts().toString());
    }
}
