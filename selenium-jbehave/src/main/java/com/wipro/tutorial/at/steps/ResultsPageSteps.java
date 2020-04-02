package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ResultsPage;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultsPageSteps extends AbstractSteps {
	
	@Autowired
	private ResultsPage resultsPage;
	
	@When("I click on the first product")
	public void clickFirstProduct() {
		resultsPage.clickOnProduct();
	}
	
}
