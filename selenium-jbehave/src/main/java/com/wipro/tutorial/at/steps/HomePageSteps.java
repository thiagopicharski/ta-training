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
	
	@Given("I am on Netshoes page")
	public void IAmOnNetshoesPage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$search'")
	public void ISearchFor(@Named("search") String search) {
		homePage.search(search);
	}

	@When("I select the first result")
	public void selectFistResult() {
		homePage.clickFirstResult();
	}

	@When("I click on add produtc to cart")
	public void clickButtonAddCart() {
		homePage.clickAddCart();
	}

	@Given("I searched on Netshoes for '$search'")
	@Composite(steps = {
			"Given I am on Netshoes page"})
	public void ISearchedOnNetShoesFor(@Named("search") String search) {

	}
}
