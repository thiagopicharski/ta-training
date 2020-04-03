package com.wipro.tutorial.at.steps;

import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.tutorial.at.pages.HomePage;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on Netshoes Home Page")
	public void IAmOnNetshoesPage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$product'")
	public void ISearchFor(@Named("product") String product) {
		homePage.searchProduct(product);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}

	@When("I click the first product")
	public void ISearchedOnNetshoesFor() {
		homePage.clickFirstProduct();
	}

	@When("I add the product to the cart")
	public void IAddTheProductToTheCart() {
		homePage.clickAddProduct();
	}

	@Then("I check if the product is in the cart")
	public void ICheckTheProductInTheCart() {
		homePage.checkProductInTheCart();
	}
}
