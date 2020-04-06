package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.CartPage;
import com.wipro.tutorial.at.pages.HomePage;
import com.wipro.tutorial.at.pages.ProductPage;
import com.wipro.tutorial.at.pages.ResultsPage;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Step;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetshoesSearchSteps extends AbstractSteps {

    @Autowired
    private HomePage homePage;
    @Autowired
    private ResultsPage resultsPage;
    @Autowired
    private ProductPage productPage;
    @Autowired
    private CartPage cartPage;


    @Given("I access the Netshoes page")
    public void givenIAccessTheNetshoesPage() {
    homePage.navigateTo();
    }

    @When("I searched for '$search' on the search field")
    public void thenISearchedForProduct(@Named("search") String search) {
    homePage.search(search);
    }

    @Then("the first result is '$result'")
        public void firstResult (@Named("result")String result){
            String actualResult = resultsPage.firstResultText();
            Assert.assertEquals(result,actualResult);
    }


    @Given("I '$search' for a product")
    @Composite (steps = {"Given I access the Netshoes page", "When I searched for '$search' on the search field"})
    public void givenISearchForAProduct() {
    }

    @When("I click on first result")
    public void whenIClickOnFirstResult() {
    resultsPage.clickFirstResult();
    }

    @When("I click in buy button")
    public void whenIClickInBuyButton() {
    productPage.clickButton();
    }

    @Then("I should see the shopping cart page")
    public void thenIShouldSeeTheShoppingCartPage() {
        cartPage.cartPageCheck();
        Assert.assertTrue(cartPage.cartPageCheck());
    }
}
