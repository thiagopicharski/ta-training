package at.steps;

import at.util.RestUtil;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetStoreSteps  extends AbstractSteps {

    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Value("${app.base.url}product/")
    private String productUrl;

    @Given("I am on the store")
    public void onTheStore() {
    }

    @When("I request a product list in a cart with id '$id'")
    public void requestProductList(@Named("id") String id){
        String result = RestUtil.sendGet(cartUrl+id + "/products");
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
        LOGGER.info("Returning cart with id: " + id);
    }

    @When("I request a list of carts")
    public void requestCarts() {
        String result = RestUtil.sendGet(cartUrl);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
    }

    @When("I request a cart with id '$id'")
    public void requestCart(@Named("id") String id) {
        String result = RestUtil.sendGet(cartUrl+id);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
        LOGGER.info("Returning cart with id: " + id);
    }

    @When("I request a product with id '$id'")
    public void requestProduct(@Named("id") String id){
        String result = RestUtil.sendGet(productUrl+id);
        DocumentContext documentContext = JsonPath.parse(result);
        context.saveResource("result", documentContext);
        LOGGER.info("Returning product with id: " + id);
    }

    @Then("I should see the product")
    public void thenSeeProduct(){
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("The product: " + result.jsonString());
    }

    @Then("I should see the cart")
    public void thenSeeCart() {
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("The Cart: " + result.jsonString());
    }

    @Then("I should see a product list")
    public void thenReceiveProductList(){
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("The product list: " + result.jsonString());
    }

    @Then("I should receive a list of carts")
    public void thenReceiveCarts() {
        DocumentContext result = (DocumentContext) context.getResource("result");
        LOGGER.info("Cart list: " + result.jsonString());
    }
}
