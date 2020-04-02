package com.wipro.tutorial.at.steps;

import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.tutorial.at.pages.HomePage;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	public HomePage homePage;
	
	@Given("I am at the Netshoes homepage")
	public void IAmOnNetshoes() {

		homePage.navigateTo();
	}
	
	@When("I search for '$prod' at the searchbar")
	public void ISearchProd(@Named("prod") String prod) {

		homePage.search(prod);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {

		homePage.clickSearch();
	}
}
