package com.wipro.tutorial.at.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.tutorial.at.pages.ResultsPage;

@Component
public class ResultsPageSteps extends AbstractSteps {
	
	@Autowired
	private ResultsPage resultsPage;

	@When("I click on the first item")
	public void IClickOnFirstItem(){
		resultsPage.getFirstResult();
	}

	
}
