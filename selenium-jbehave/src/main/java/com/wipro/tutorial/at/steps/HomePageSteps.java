package com.wipro.tutorial.at.steps;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.tutorial.at.pages.HomePage;

@Component
public class HomePageSteps extends AbstractSteps {

	@Autowired
	private HomePage homePage;
	
	@Given("I am on netshoes page")
	public void IAmOnNetshoesPage() {
		homePage.navigateTo();
		Assert.assertTrue(homePage.titlePage().contains("Netshoes"));
	}
	
	@When("I search for '$search'")
	public void ISearchFor(@Named("search") String search) {
		homePage.search(search);
	}
	
	@When("I click on search button")
	public void IClickOnSearchButton() {
		homePage.clickSearch();
	}

	@When("I select an item")
	public void ISelectAnItem() { homePage.clickInTheFirstItem(); }

	@When("I select a size")
	public void ISelectASize() { homePage.clickInSize(); }

	@When("I click in buy")
	public void IClickInBuy(){ homePage.clickInBuy(); }

	@Then("I want go to my bag")
	public void GoToBag() { homePage.clickToGoToBag(); }

	@Then("I should see the item on my bag")
	public void checkTheBag(){
		Assert.assertTrue(homePage.checkTheBag());
	};
}
