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
public class DeleteStoreSteps extends AbstractSteps {
    @Value("${app.base.url}cart/")
    private String cartUrl;

    @Given("A cart on the store")
    public void theCart(){}

    @When("I remove the product with id '$productId' from my cart with id '$cartId'")
    public void removeProductFromCart(@Named("cartId") String cartId, @Named("productId") String productId){
        RestUtil.sendDelete(cartUrl + cartId + "/product/" + productId);
//        DocumentContext documentContext = JsonPath.parse(result);
//        context.saveResource("result", documentContext);
    }

    @Then("I should not see any error")
    public void thenNoErrors() {
        String result = (String) context.getResource("result");
        LOGGER.info("REST_RESULT: " + result);
    }
}
