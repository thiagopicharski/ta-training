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

	@When("I click on the first product")
	public void IClickOnFirstProduct() {
		resultsPage.clickProduct();
	}
	
}
