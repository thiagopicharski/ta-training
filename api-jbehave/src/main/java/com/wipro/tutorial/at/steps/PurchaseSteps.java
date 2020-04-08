package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.support.CartSupport;
import com.wipro.tutorial.at.support.ProductSupport;
import com.wipro.tutorial.at.support.UtilsSupport;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Component
public class PurchaseSteps extends AbstractSteps {
    @Autowired
    private ProductSupport productSupport;

    @Autowired
    private CartSupport cartSupport;

    @Autowired
    private UtilsSupport utilsSupport;

    private String response;
    private int cartId;
    private int productsLen;
    private int firstProductId;

    @Given("an empty cart")
    public void noop(){

    }

    @When("I add a'$prod' to the cart")
    public void addProduct(@Named("prod") String productJson) {
        LOGGER.info("Adding product to new cart");
        this.response = cartSupport.newCart(productJson);
    }

    @Then("the cart should have one product inside")
    public void cartWithOneProduct(){
        DocumentContext cart = jsonUtil.loadJson(this.response);
        assertEquals(Integer.valueOf(1), cart.read("$.products.length()", Integer.class));
    }

    @Given("a cart filled with products which their ids are '$prodIds'")
    public void cartWithProducts(@Named("prodIds") List<Integer> productIds){
        List<String> productsJson = new ArrayList<>();
        for (Integer id : productIds)
            productsJson.add(productSupport.getProduct(id));

        String response = cartSupport.newCart(productsJson.get(0));
        this.cartId = utilsSupport.getCartId(response);

        for (String product : productsJson.subList(1, productsJson.size()))
            cartSupport.addProduct(product, cartId);
    }

    @When("I remove a product with the following '$id' from the cart")
    public void RemoveAProduct(@Named("id") int productId){
        this.response = cartSupport.removeProduct(productId, cartId);
    }

    @Then("the cart no long contain the product with '$id'")
    public void verifyCartAfterRemoval(@Named("id") int id){
        DocumentContext json = jsonUtil.loadJson(this.response);
        List<Map<String, Object>> matches = json.read("$.products[@.id == " + id, List.class);
        Assert.assertTrue("The removed item shouldn't be in the cart", matches.size() == 0);
    }


    @Given("a new cart with the following products '$prod'")
    public void createANewCart(@Named("prod") String listProductsJson){
        List<String> jsons = jsonUtil.loadJson(listProductsJson).read("$", List.class);
        this.productsLen = jsons.size();
        this.response = cartSupport.newCart(jsons.get(0));
        this.cartId = utilsSupport.getCartId(this.response);
        this.firstProductId = utilsSupport.getNthProductId(this.response, 0);
        for (String product : jsons.subList(1, jsons.size())){
            cartSupport.addProduct(product, this.cartId);
        }
    }

    @When("I remove the first element from the cart")
    public void removeTheFirstProduct(){
        this.response = cartSupport.removeProduct(this.firstProductId, this.cartId);
    }

    @Then("the cart needs to have one less element")
    public void verifyCartAfterRemoval(){
        assertEquals(this.productsLen -1, utilsSupport.getProductsLen(this.response));
    }


    @When("I proceed to checkout")
    public void goToCheckout(){
        this.response = cartSupport.getCart(this.cartId);
    }

    @Then("the total amount should be '$total'")
    public void verifyPurchaseTotal(@Named("total") int total){
        assertEquals("Cart total does not equal expected", total, utilsSupport.getCartTotal(this.response));
    }

    @When("I receive the shipment value through '$shipment'")
    public void verifyShipmentTotal(@Named("shipment") String shipment){
        this.response = cartSupport.determineShipment(shipment, this.cartId);
    }

    @Then("the shipment cost should correspond to the weight '$weight'")
    public void shipmentWithWeight(@Named("weight") int weight){
        DocumentContext dc = jsonUtil.loadJson(this.response);
        assertTrue(dc.read("$.deadline", Integer.class) > 0);
        assertEquals(weight, dc.read("$.totalWeight", Integer.class).intValue());
        assertTrue(dc.read("$.deadline", Integer.class) > 0);
    }
}

