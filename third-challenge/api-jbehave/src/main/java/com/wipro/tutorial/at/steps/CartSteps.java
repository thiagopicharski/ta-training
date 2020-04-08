package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.entities.CartOperations;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Component
public class CartSteps extends AbstractSteps{

    @Autowired
    CartOperations cartOperations;

    private String product;
    private String response;
    private int productId;
    private int cartId;

    @Given("a product '$product'")
    public void givenProduct(@Named("product") String product){
        this.product = product;

    }

    @When("I call PUT on the cart endpoint")
    public void createCart(){
        this.response = cartOperations.createCart(this.product);

    }

    @Then("response contains cart with product with '$price'")
    public void assertCartContains(@Named("price")int price){;
        DocumentContext dc = jsonUtil.loadJson(this.response)
       int cartId =  dc.read("$, id", Integer.class).intValue();
        assertTrue(cartId>0);
       int productPrice = dc.read("$.product[0], value", Integer.class).intValue();
        assertEquals("Product in cart has different value", price, productPrice);

    }
    @Given("A cart with '$product'")
    public void createCart(@Named("product")String product){
        this.givenProduct(product);
        this.createCart();
        this.productId = jsonUtil.loadJson(this.response).read("$.product[0].id", Integer.class);
        this.cartId = jsonUtil.loadJson(this.response).read("$.id", Integer.class);
    }
    @When("I call delete on cart")
        public void removeItem(){
        this.response = cartOperations.removeItem(this.productId, this.cartId);

    }

    @Then("response contains cart without product")
    public void cartIsEmpty(){
        assertEquals(0, jsonUtil.loadJson(this.response).read("$.product.length()", Integer.class).intValue());
    }




}
