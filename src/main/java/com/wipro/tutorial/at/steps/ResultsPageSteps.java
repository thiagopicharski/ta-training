package com.wipro.tutorial.at.steps;

import static org.junit.Assert.assertEquals;

import com.wipro.tutorial.at.pages.CartPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.tutorial.at.pages.ResultsPage;

@Component
public class ResultsPageSteps extends AbstractSteps {
	
	@Autowired
	private ResultsPage resultsPage;

	@Autowired
	CartPage cartPage;

	@Then("I should see first result as '$firstResult'")
	public void IShouldSeeFirstResultAs(@Named("firstResult") String titleExpected) {
		assertEquals(titleExpected, resultsPage.firstResultText());
	}

	@When("I click on the first product")
	public void IClickOnForstProduct(){
		resultsPage.clickSearch();
	}

	@Then("Click on buy")
	public void clickOnBuy(){
		resultsPage.clickBuy();
	}

	@Then("the product should be on cart")
	public void productOnCart(){
		assertEquals(cartPage.checkText().getText(), "Mochila Nike Brasilia Academy Team - 22 Litros");
	}
}
