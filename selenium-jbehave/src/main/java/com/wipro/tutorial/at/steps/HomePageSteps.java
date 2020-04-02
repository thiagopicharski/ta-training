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

	@Given("I am on Mercado Livre")
	public void IAmOnGooglePage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$item'")
	public void ISearchFor(@Named("item") String item) {
		homePage.search(item);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}
	
	
	@Given("I search for '$item'")
	@Composite(steps = {
			"Given I am on Mercado Livre",
			"When I search for '$item'",
			"When I click on search button"})
	public void ISearchedOnGoogleFor(@Named("item") String item) {

	}
}
