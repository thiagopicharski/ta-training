package com.wipro.tutorial.at.steps;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wipro.tutorial.at.pages.HomePage;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on netshoes page")
	public void IAmOnGooglePage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$search'")
	public void ISearchFor(@Value("search") String search) {
		homePage.search(search);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}

	@When("click on the first product")
	public void IClickOnFirstProduct() {
		homePage.clickProduct();
	}

	@When("I click on add my cart button")
	public void IClickOnAddKartButton() {
		homePage.clickAddKart();
	}

}
