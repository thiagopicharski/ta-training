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
	
	@Then("I should see first result as '$firstProduct'")
	public void IShouldSeeFirstProductAs(@Named("firstProduct") String titleExpected) {
		assertEquals(titleExpected, resultsPage.firstProductText());
		
	}
	@When("I click on Product Image")
	public void IClickOnProductImage() {
		resultsPage.clickImage();
	}
	
	
	@Then("And I get product page '$button'")
	public void IGetProductPage(@Named("button") String titleExpected) {
		assertEquals(titleExpected, resultsPage.buttonText());
	}
	
	@When("And I click on buy button")
	public void IClickOnBuyButton() {
		resultsPage.clickBuy();
	}
	
	
	@Then("I should add the product to cart'$finalProduct'")
	public void TheProductCart(@Named("finalProduct") String titleExpected) {
		assertEquals(titleExpected, resultsPage.finalProductText());
	}

	
}
