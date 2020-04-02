package com.wipro.tutorial.at.steps;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.tutorial.at.pages.HomePage;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on mercado livre page")
	public void iAmOnGooglePage() {
		homePage.navigateTo();
	}

	@When("I search for '$search'")
	public void iSearchFor(@Named("search") String search) {
		homePage.search(search);
	}
	
	@When("I click on search button")
	public void iClickOnSearchButton() {
		homePage.clickSearch();
	}
	
	
//	@Given("I searched on google for '$search'")
//	@Composite(steps = {
//			"Given I am on google page",
//			"When I search for '$search'",
//			"When I click on search button"})
//	public void ISearchedOnGoogleFor(@Named("search") String search) {
//
//	}
}
