package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.HomePage;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on Netshoes")
	public void IAmOnGooglePage() {
		homePage.navigateTo();
	}
	
	@When("I search for '$search'")
	public void ISearchFor(@Named("search") String search) {
		homePage.search(search);
	}

	@When("I click on search button")
	public void IClickOnSearchButton() { homePage.clickSearch();
	}

	@When("I click on the first product")
	public void IClickOnTheFProduct() { homePage.clickOnProduct();

	}
}