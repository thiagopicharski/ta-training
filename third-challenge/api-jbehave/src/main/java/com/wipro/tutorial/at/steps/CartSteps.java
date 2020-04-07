package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.entities.CartOperations;
import com.wipro.tutorial.at.entities.EntityUtils;
import com.wipro.tutorial.at.entities.ProductOperations;
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

import static org.junit.Assert.assertEquals;

@Component
public class CartSteps extends AbstractSteps {

    @Autowired
    private ProductOperations productOperations;

    @Autowired
    private CartOperations cartOperations;

    @Autowired
    private EntityUtils entityUtils;

    private String response;
    private int cartId;
    private int productsLen;
    private int firstProductId;

    @Given("no cart")
    public void noop(){

    }


    @When("I add '$product' to a cart's products")
    public void addProduct(@Named("product") String productJson) {
        LOGGER.info("Adding product to new cart");
        this.response = cartOperations.createCart(productJson);
    }


    @Then("I should get a cart with a single product in it")
    public void cartHasProduct(){
        DocumentContext cart = jsonUtil.loadJson(this.response);
        assertEquals(new Integer(1), cart.read("$.products.length()", Integer.class));
    }


    @Given("cart with populated with the following product ids: '$productIds'")
    public void createCartWithProducts(@Named("productIds") List<Integer> productIds){
        List<String> productsJson = new ArrayList<>();
        for (Integer id : productIds)
            productsJson.add(productOperations.getProduct(id));

        String response = cartOperations.createCart(productsJson.get(0));
        this.cartId = entityUtils.getCartId(response);

        for (String product : productsJson.subList(1, productsJson.size()))
            cartOperations.addProduct(product, cartId);
    }

    @When("I remove the product with id '$id' from the cart")
    public void removeItem(@Named("id") int productId){
        this.response = cartOperations.removeItem(productId, cartId);
    }

    @Then("cart no longer contains product '$id'")
    public void assertCartDoesNotContain(@Named("id") int id){
        DocumentContext json = jsonUtil.loadJson(this.response);
        List<Map<String, Object>> matches = json.read("$.products[@.id == " + id, List.class);
        Assert.assertTrue("The removed item shouldn't be in the cart", matches.size() == 0);
    }


    @Given("a new cart with the following products '$products'")
    public void createCart(@Named("products") String listProductsJson){
        List<String> jsons = jsonUtil.loadJson(listProductsJson).read("$", List.class);
        this.productsLen = jsons.size();
        this.response = cartOperations.createCart(jsons.get(0));
        this.cartId = entityUtils.getCartId(this.response);
        this.firstProductId = entityUtils.getNthProductId(this.response, 0);
        for (String product : jsons.subList(1, jsons.size())){
            cartOperations.addProduct(product, this.cartId);
        }
    }

    @When("I remove the first item from created cart")
    public void removeFirst(){
        this.response = cartOperations.removeItem(this.firstProductId, this.cartId);
    }

    @Then("cart has one less element")
    public void elementRemoved(){
        assertEquals(this.productsLen -1, entityUtils.getProductsLen(this.response));
    }


    @When("I get cart")
    public void getCart(){
        this.response = cartOperations.getCard(this.cartId);
    }

    @Then("response has '$total' as the total")
    public void assertTotal(@Named("total") int total){
        assertEquals("Cart total does not equal expected", total, entityUtils.getCartTotal(this.response));
    }
}
