package com.wipro.tutorial.at.steps;
import org.springframework.beans.factory.annotation.Value;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CartSteps extends AbstractSteps {

    @Value("${app.base.url}")
    private  String baseUrl;

    private String newCartUrl = "/cart/product";

    private String addProductUrl  ="/cart/%s/product";

    private String cartUrl = "/cart/%s";

    private String cartProductsUrl ="/cart/%s/products";

    private String deleteProductUrl ="/cart/%s/product/%s";

    private String productUrl = "/product/%s";

    private String shipmentUrl = "/cart/%s/shipment";

    private String allCartsUrl = "/cart";



    @Given("i don't have a cart yet")
    public void doenstHaveCart() {
        LOGGER.info("don't have a cart yet");
    }
    @Given("I have a '$id' of a Product")
    public void iHaveAProductId(@Named("id")Long id){
        context.saveResource("productId", id);
        LOGGER.info("saving in context the productId");
    }
    @Given("i have  a cart with products")
    public void newCartWithProducts() {

        String response = RestUtil.sendPut(baseUrl+newCartUrl, cartUtil.createProducts().get(0) );
        int cartId = JsonPath.parse(response).read("$.id", Integer.class);
        int productId = JsonPath.parse(response).read("$.products[0].id", Integer.class);
        context.saveResource("productId", productId);
        List<String> payloads =  cartUtil.createProducts().subList(1, cartUtil.createProducts().size());
        for (String payload : payloads) {
            RestUtil.sendPut(baseUrl+String.format(addProductUrl,cartId), payload);
        }
        String result = RestUtil.sendGet(baseUrl+String.format(cartUrl,cartId));

        DocumentContext documentContext = JsonPath.parse(result);
        LOGGER.info("Adding products to  a cart(Id: "+cartId+ ")");
        context.saveResource("newCartWithProducts", documentContext);
    }

    @When("i want to add a '$product' to a new cart")
    public void addProductNewCart(@Named("product") String product) {

        String response = RestUtil.sendPut(baseUrl+newCartUrl, product);
        DocumentContext documentContext = JsonPath.parse(response);
        context.saveResource("socks", documentContext);
        LOGGER.info("Creating a new cart with a product inside");
    }
    @When("i  want to see all products in my cart")
    public void getAllProductsOfCart(){
        DocumentContext result = (DocumentContext) context.getResource("newCartWithProducts");
        int cartId = result.read("$.id");
        String response = RestUtil.sendGet(baseUrl+String.format(cartProductsUrl,cartId));
        DocumentContext documentContext = JsonPath.parse(response);
        context.saveResource("cartProducts", documentContext);
        LOGGER.info("Getting all products of a given cart");
    }
    @When("i want to remove a product from the cart")
    public void removeProduct() {
        DocumentContext result = (DocumentContext) context.getResource("newCartWithProducts");
        int cartId = result.read("$.id");
        int productId = (Integer) context.getResource("productId");
        String response = RestUtil.sendDelete(baseUrl+String.format(deleteProductUrl,cartId,productId));
        DocumentContext documentContext = JsonPath.parse(response);
        context.saveResource("deletedResponse", documentContext);
        LOGGER.info("Removing product (Id: "+productId+" )");
    }
    @When("i want to see product details")
    public void getProductDetails(){
        long id = (Long)context.getResource("productId");
        String response = RestUtil.sendGet(baseUrl+String.format(productUrl,id));
        DocumentContext documentContext = JsonPath.parse(response);
        context.saveResource("productDetails" ,documentContext);
        LOGGER.info("getting product details");
    }
    @When("i  add a '$product' to a existing cart")
    public void addProductExistingCart(@Named("product") String product) {
        DocumentContext result = (DocumentContext) context.getResource("newCartWithProducts");
        int cartId = result.read("$.id",Integer.class);
        String response = RestUtil.sendPut(baseUrl+String.format(addProductUrl,cartId), product);
        DocumentContext documentContext = JsonPath.parse(response);
        context.saveResource("productAdded", documentContext);
        DocumentContext productAdded = (DocumentContext) context.getResource("productAdded");
        int indexOfLastAddedProduct = result.read("$.products.length()",Integer.class)-1 ;
        LOGGER.info("Adding product(Description:  "+productAdded.read("$.products["+indexOfLastAddedProduct+"].description",String.class)  +" ) to a existing cart(id:"+cartId+")");
    }
    @When("i want to have the sum of all items")
    public void sumOfAllItemsInTheCart() {
        DocumentContext result = (DocumentContext) context.getResource("newCartWithProducts");
        Double cartSum = result.read("$.total", Double.class);
        context.saveResource("cartSum",cartSum );
        LOGGER.info("Sum of all items in the cart: "+ cartSum);
    }
    @When("i want to have the total cost  and the weight of my '$shipment'")
    public void costAndWeightOfShipment(@Named("shipment") String shipment) {
        DocumentContext result = (DocumentContext) context.getResource("newCartWithProducts");
        int cartId = result.read("$.id", Integer.class);
        String response = RestUtil.sendPost(baseUrl+String.format(shipmentUrl,cartId), shipment);
        DocumentContext documentContext = JsonPath.parse(response);
        context.saveResource("shipment", documentContext);
        LOGGER.info("Creating Shipment for cart(Id: "+cartId+" )");

    }
    @Then("the '$numberOfProducts' in the cart should be the same as the initial cart")
    public void shouldSeeAllProductsInTheCart(@Named("numberOfProducts") Long numberOfProducts) {
        DocumentContext result = (DocumentContext) context.getResource("cartProducts");
        Long actual = result.read("$.length()", Long.class);
        LOGGER.info("Expected number of products: "+ numberOfProducts +"/Actual  number of products: "+actual);
        Assert.assertEquals(numberOfProducts, actual);
    }
    @Then("i should see '$expectedDescription' in the cart")
    public void shouldSeeProductInTheCart(@Named("expectedDescription") String expectedDescription) {
        DocumentContext result = (DocumentContext) context.getResource("socks");
        int indexOfLastAddedProduct = result.read("$.products.length()",Integer.class)-1 ;
        String actualDescription = result.read("$.products["+indexOfLastAddedProduct+"].description", String.class);
        Assert.assertEquals(expectedDescription,actualDescription );
        LOGGER.info("Expected description: "+ expectedDescription +"/Actual Description: "+actualDescription);
    }
    @Then("i should see '$expectedDescription' in the existing cart")
    public void shouldSeeProductInTheExistingCart(@Named("expectedDescription") String expectedDescription) {
        DocumentContext result = (DocumentContext) context.getResource("productAdded");
        int indexOfLastAddedProduct = result.read("$.products.length()",Integer.class)-1 ;
        String actualDescription = result.read("$.products["+indexOfLastAddedProduct+"].description", String.class);
        Assert.assertEquals(expectedDescription, actualDescription);
        LOGGER.info("Expected description: "+ expectedDescription +"/Actual Description: "+actualDescription);
    }
    @Then("the '$numberOfProducts' in the cart should have one less product")
    public void shouldSeeOneLessProductInTheCart(@Named("numberOfProducts") Long numberOfProducts) {
        DocumentContext result = (DocumentContext) context.getResource("deletedResponse");
        Long actual = Long.valueOf(result.read("$.products.length()", Integer.class));
        Assert.assertEquals(numberOfProducts, actual);
        LOGGER.info("Expected number of products: "+ numberOfProducts +"/Actual  number of products: "+actual);

    }
    @Then("the product description should be equals to '$expectedDescription'")
    public void shouldGetExpectedDescription(@Named("expectedDescription") String expectedDescription ){
        DocumentContext result = (DocumentContext) context.getResource("productDetails") ;
        String actualDescription = result.read("$.description");
        Assert.assertEquals(expectedDescription,actualDescription);
        LOGGER.info("Expected product description: "+ expectedDescription +"/Actual  product description: "+actualDescription);

    }
    @Then("the product weight should be equals to '$expectedWeight'")
    public void shouldGetExpectedWeight(@Named("expectedWeight") Double expectedWeight ){
        DocumentContext result = (DocumentContext) context.getResource("productDetails") ;
        Double actualWeight = result.read("$.weight",Double.class);
        Assert.assertEquals(expectedWeight,actualWeight);
        LOGGER.info("Expected product weight: "+ expectedWeight +"/Actual  product weight: "+actualWeight);
    }
    @Then("the product value should be equals to '$expectedValue'")
    public void shouldGetExpectedValue(@Named("expectedValue") Double expectedValue ){
        DocumentContext result = (DocumentContext) context.getResource("productDetails") ;
        Double actualValue = result.read("$.value",Double.class);
        Assert.assertEquals(expectedValue,actualValue);
        LOGGER.info("Expected product value: "+ expectedValue +"/Actual  product value: "+actualValue);
    }
    @Then("i should see the '$expectedSum'")
    public void shouldGetExpectedSum(@Named("expectedSum") Double expectedSum) {
        Double cartSum = (Double) context.getResource("cartSum");
        Assert.assertEquals(expectedSum, cartSum);
        LOGGER.info("Expected sum: "+ expectedSum +"/Actual  sum: "+cartSum);
    }
    @Then("the cost should be equals to '$cost'")
    public void shouldSeeTheCorrectCostOfShipment(@Named("cost") Double expectedCost) {
        DocumentContext response = (DocumentContext) context.getResource("shipment");
        Double actualCost = response.read("$.value", Double.class);
        Assert.assertEquals(expectedCost, actualCost);
        LOGGER.info("Expected Shipment cost: "+ expectedCost +"/Shipment cost: "+actualCost);

    }
    @Then("the weight should be equals to '$weight'")
    public void shouldSeeTheCorrectWeightOfShipment(@Named("weight") Double expectedWeight) {
        DocumentContext response = (DocumentContext) context.getResource("shipment");
        Double actualWeight = response.read("$.totalWeight", Double.class);
        Assert.assertEquals(expectedWeight, actualWeight);
        LOGGER.info("Expected Shipment weight: "+ expectedWeight +"/Shipment weight: "+actualWeight);
    }
    @Then("i should see the cart id in cart list")
    public void getCarts(){
        DocumentContext result = (DocumentContext) context.getResource("socks");
        int cartId = result.read("$.id");
        String response = RestUtil.sendGet(baseUrl+allCartsUrl);
        List<Integer>idsList =  JsonPath.parse(response).read("$..id",List.class);
        boolean flag = false;
        for (Integer id :idsList ){
            if (cartId == id){flag=true;}
        }
        Assert.assertTrue(flag);
        LOGGER.info("checking if a new cart is in the cart list");
    }
}