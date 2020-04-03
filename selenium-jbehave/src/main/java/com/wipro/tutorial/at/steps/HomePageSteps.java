package com.wipro.tutorial.at.steps;

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
	
	@Given("I m in the netshoes online store")
	public void IAmInTheNetshoesStore() {
		homePage.navigateTo();
	}
	
	@When("I search in the search bar for '$product'")
	public void ISearchIn(@Named("product") String product) {
		homePage.search(product);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}
	
	

}
