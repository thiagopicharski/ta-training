package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ResultsPage;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.tutorial.at.pages.HomePage;

import static org.junit.Assert.assertEquals;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on ML page")
	public void IAmOnGooglePage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$search'")
	public void ISearchFor(@Named("search") String search) {
		homePage.search(search);
	}

	@When("I select the fist result")
	public void selectFistResult() {
		homePage.clickFirstResult();
	}

	@When("I click on add produtc to cart")
	public void clickButtonAddCart() {
		homePage.clickAddCart();
	}

	@Given("I searched on ML for '$search'")
	@Composite(steps = {
			"Given I am on ML page"})
	public void ISearchedOnGoogleFor(@Named("search") String search) {

	}
}
