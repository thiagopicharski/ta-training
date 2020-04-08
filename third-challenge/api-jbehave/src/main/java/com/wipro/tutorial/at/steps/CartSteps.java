package com.wipro.tutorial.at.steps;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.entity.ProductFunctions;
import com.wipro.tutorial.at.entity.RESTFunctions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Component
public class CartSteps extends AbstractSteps {

    @Autowired
    private RESTFunctions restFunctions;

    @Autowired
    private ProductFunctions productFunctions;

    private String response;
    private Integer oneProduct = 1;
    private Integer idProductList;
    private Integer idCart;
    private Integer listProductsSize;

    @Given("an empty cart")
    public void emptyCart(){
    }

    @Given("cart with items containing product ids: '$idproducts'")
    public void aCartContainingProducts(@Named("$idproducts")List<Integer> idproducts){
        List<String> productsJson = new ArrayList<>();

        for (Integer id : idproducts){
            productsJson.add(productFunctions.getProduct(id));
        }

        String response = restFunctions.newCart(productsJson.get(0));
        idCart = restFunctions.getIdCart(response);

        for (String product : productsJson.subList(1, productsJson.size())){
            restFunctions.newProduct(product, idCart);
        }
    }

    @Given("a cart with a list of '$products'")
    public void givenCartWithProducts(@Named("products") String listProducts){
        List<String> list = jsonUtil.loadJson(listProducts).read("$", List.class);
        listProductsSize = list.size();
        response = restFunctions.newCart(list.get(0));
        idCart = restFunctions.getIdCart(response);
        idProductList = restFunctions.getProduct(response,0);
        for (String product : list.subList(1, list.size())){
            restFunctions.newProduct(product, idCart);
        }
    }

    @When("product id '$id' is removed from the cart")
    public void removeProductWithId(@Named("id") Integer idProduct){
        response = restFunctions.deleteProduct(idProduct, idCart);
    }

    @When("I put the '$product' to a cart")
    public void putProduct(@Named("product") String productJson){
        LOGGER.info("Inserting a new product to a cart");
        response = restFunctions.newCart(productJson);
    }

    @When("I delete a product")
    public void deleteProduct(){
        response = restFunctions.deleteProduct(idProductList, idCart);
    }

    @When("I have a cart")
    public void aCart(){
        response = restFunctions.getCart(idCart);
    }

    @When("I call shipment method with the following '$request'")
    public void shippingMethod(@Named("request") String request){
        response = restFunctions.getShipment(request, idCart);
    }

    @Then("I should have only one product on the cart")
    public void productOnCart(){
        DocumentContext cart = jsonUtil.loadJson(response);
        assertEquals(oneProduct, cart.read("$.products.length()", Integer.class));
    }

    @Then("product '$id' won't be found")
    public void productNotFoundNoGivenCart(@Named("id") Integer id){
        DocumentContext json = jsonUtil.loadJson(response);
        List<Map<String, Object>> match = json.read("$.product[@.id == " + id, List.class);
        assertTrue("Product shouldn't be found at this cart", match.size() == 0);
    }

    @Then("cart size is subtracted")
    public void thenOneProductIsGone(){
        assertEquals(listProductsSize - 1, 1);
    }

    @Then("cart price amount is '$total'")
    public void cartAmount(@Named("total") Integer total){
        assertEquals("Cart amount isn't the same", total, restFunctions.getCartAmount(response));
    }

    @Then("the total weight of the requested products is'$weight'")
    public void thenAssertShipment(@Named("weight") Integer weight){
        DocumentContext documentContext = jsonUtil.loadJson(response);
        assertTrue(documentContext.read("$.deadline", Integer.class) > 0);
        assertEquals(weight, documentContext.read("$.totalWeight"));
        assertTrue(documentContext.read("$.deadline", Integer.class) > 0);
    }



}
