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

	@Given("I open netshoes page")
	public void OpenNetshoesPage() {
		homePage.navigateTo();
	}

	@Given("I search for '$product'")
	public void ISearchFor(@Named("product") String product) {
		homePage.search(product);
	}

	@When("I click on the product")
	public void ClickTheProduct() {
		homePage.clickProduct();
	}

}
