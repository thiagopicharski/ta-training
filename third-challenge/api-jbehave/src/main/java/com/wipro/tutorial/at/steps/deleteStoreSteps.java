package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class deleteStoreSteps extends AbstractSteps {
    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Given("Some cart on the Store")
    public void theCart(){

    }

    @When("I delete the product with id '$productId' from my cart with id '$cartId'")
    public void deleteProductFromTheCart(@Named("cartId") String cartId, @Named("productId") String productId){
        RestUtil.sendDelete(cartUrl + cartId + "/product/" + productId);
    }

    @Then("I should see the deleted product from the cart")
    public void deletedProduct(){
        String deleteResult = (String) context.getResource("deleteResult");
        LOGGER.info("REST_RESULT: " + deleteResult);
    }
}
