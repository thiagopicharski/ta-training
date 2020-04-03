package com.wipro.tutorial.at.steps;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.tutorial.at.pages.ResultsPage;

@Component
public class ResultsPageSteps extends AbstractSteps {

    @Autowired
    private ResultsPage resultsPage;

    @When("I click in the first result of the search '$searchResult'")
    public void IClickInFirstResult(@Named("searchresult") String searchResult) {
        resultsPage.clickFirstResult();
    }

    @When("then click on add to cart button")
    public void IClickOnAddButton() {
        resultsPage.clickAddToCart();
    }

    @Then("I should see '$addedProduct' on items list")
    public void IShouldSeeAddedProductOnList(@Named("addedProduct") String expectedAddedItem) {
        String result = resultsPage.addedItemTitle();
        assertEquals("Values are not the same", expectedAddedItem, result);
    }

}
