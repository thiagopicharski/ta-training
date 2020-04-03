package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetShoesSteps {

    @Autowired
    private HomePage homePage;

    @Autowired
    protected WebDriverProvider webDriverProvider;

    @Given("the customer access the NetShoes home page")
    public void IAccessNetshoesHomepage() {
        homePage.navigateTo();
    }

    @Then("I should see the search bar")
    public void thenICanSeeSearchBar(){
        WebElement contentDiv = webDriverProvider.get().findElement(By.id("search-input"));
        Assert.assertTrue("The search bar was expected to be displayed, but it was not."
                , contentDiv.isDisplayed());
    }

    @When("I search for product $product")
    public void ISearchFor(@Named("product") String search) {
        WebElement searchBar = webDriverProvider.get().findElement(By.id("search-input"));
        searchBar.sendKeys(search);
    }

    @When("I click on search button")
    public void IClickOnSearchButton() {
        webDriverProvider.get().findElement(By.xpath("//button[@title='Buscar']")).click();
    }

    @When("I click the $index product")
    public void IClickOn3Product(@Named("index") String index) {
        webDriverProvider.get().findElement(By.xpath("(//*[@class='item-card__description__product-name']) ["+index+"]")).click();
    }

    @When ("I click buy")
    public void clickBuy() {
        WebElement buyBtn = webDriverProvider.get().findElement(By.className("buy-button-now"));
        buyBtn.click();
    }

    @When("I search for zip code $zip")
    public void insertZip(@Named("zip") String zip) {
        WebDriverWait wait = new WebDriverWait(webDriverProvider.get(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-input__input")));
        WebElement zipcodesearch = webDriverProvider.get().findElement(By.className("float-input__input"));
        zipcodesearch.sendKeys(zip);
    }

    @When ("I click search zip")
    public void searchZip(){
        webDriverProvider.get().findElement(By.className("freight-form__button")).click();
    }

    @Then("I should see calculated shipping fee")
    public void checkForCalculatedZip(){
        WebDriverWait wait = new WebDriverWait(webDriverProvider.get(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='summary__item-text--positive']")));
        WebElement shippingElement = webDriverProvider.get().findElement(By.xpath("//div[@class='summary__item-text--positive']"));
        Assert.assertNotNull(shippingElement);
    }

}
