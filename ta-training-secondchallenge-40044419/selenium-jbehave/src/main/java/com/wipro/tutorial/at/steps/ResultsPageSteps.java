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
	
	@Then("I should see first result as '$result'")
	public void IShouldSeeFirstResultAs(@Named("result") String titleExpected) {
		assertEquals(titleExpected, resultsPage.getFirstResultText());
	}

	@When("I select the first item")
	public void selectFirstItem(){
		resultsPage.clickFirstResult();
	}



}
