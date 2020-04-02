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

	@When("I click on the product $whatIGet")
	public void clickOnTheDesiredProduct(@Named("whatIGet") String desiredProduct){
		resultsPage.clickProduct();
	}

	@When("add to my cart")
	public void clickAddToMyCart(){
		resultsPage.clickBuy();
	}

	@Then("I should see the message $msg")
		public void IShouldSeeFirstResultAs(@Named("msg") String message) {
		System.out.println(message);
		System.out.println(resultsPage.message().getText());
		assertEquals(message, resultsPage.message().getText());
	}
	
}
