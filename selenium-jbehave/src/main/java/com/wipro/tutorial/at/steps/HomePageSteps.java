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

	@Given("I am on MercadoLivre page")
	public void IAmOnMercadoLivrePage() {
		homePage.navigateTo();
	}

	@When("I search for '$search'")
	public void ISearchFor(@Named("search") String search) {
		homePage.search(search);
	}

	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}

	@When("I click on the first product")
	public void IClickOnTheFirstProduct() {
		homePage.clickProduct();
	}

	@When("I add to cart")
	public void IAttCart() {
		homePage.addCart();
	}

}
