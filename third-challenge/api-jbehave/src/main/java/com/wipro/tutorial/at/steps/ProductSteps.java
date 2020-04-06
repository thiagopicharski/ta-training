package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.util.RestUtil;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSteps extends AbstractSteps {

    @Value("${app.cart.product.url}")
    private String productUrl;

    @Autowired
    Cache cache;


    @When("I add '$product' to a cart's products")
    public void addProduct(@Named("product") String productJson) {
        LOGGER.info("Adding product to new cart");
        this.cache.setResponseBody(RestUtil.sendPut(this.productUrl, productJson));
    }


}
