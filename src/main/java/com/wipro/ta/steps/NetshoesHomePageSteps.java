package com.wipro.ta.steps;

import com.wipro.ta.pages.NetshoesPage;
import com.wipro.ta.utils.Utils;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.*;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class NetshoesHomePageSteps extends AbstractSteps {
    protected final WebDriverProvider webDriverProvider;
    final
    NetshoesPage netshoesPage;
    @Value("${home.url}")
    private String NETSHOES_HOMEPAGE_URL;

    protected Logger LOG = Logger.getLogger(this.getClass());
    final
    Utils utils;

    public NetshoesHomePageSteps(NetshoesPage netshoesPage, Utils utils, WebDriverProvider webDriverProvider) {
        this.netshoesPage = netshoesPage;
        this.utils = utils;
        this.webDriverProvider = webDriverProvider;
    }

    @Given("the customer access the NetShoes home page")
    public void givenCustomerAccessHomePage() {
        LOG.info("Navigating user to page: " + NETSHOES_HOMEPAGE_URL);
        webDriverProvider.get().get(NETSHOES_HOMEPAGE_URL);
    }

    @Then("I should see the search bar")
    public void thenProductListIsDisplayed() {
        Assert.assertTrue("The search bar was expected to be displayed, but it was not."
                , netshoesPage.searchBar.isDisplayed());
    }

    @Then("I should search for $something")
    public void searchForSomething(@Value("something") String item) {
        netshoesPage.searchBar.sendKeys(item);
        netshoesPage.searchBar.submit();

    }

    @Then("I should see the something's listing")
    public void seeSomethingsList() {
        WebElement list = utils.waitForElement(By.id("item-list"));
        Assert.assertTrue("Something was expected to be displayed, but it was not."
                , list.isDisplayed());
    }

    @When("I click on a random item")
    public void iClickOnAItem() {
        Random random = new Random();
        netshoesPage.resultsFromSearch.get(random.nextInt(netshoesPage.resultsFromSearch.size())).click();
    }

    @Then("I should select a random $available item's size")
    public void iShouldSelectTheItemsSize(@Value("available") String sizeOption) {
        Random random = new Random();
        if (sizeOption.equals("available")) {
            utils.hardWaitForElement(By.xpath(netshoesPage.productSizeOptionsXpath));
            List<WebElement> productSizeList = utils.waitForElements(By.xpath(netshoesPage.productSizeOptionsXpath));
            if (productSizeList.size() > 0)
                productSizeList.get(random.nextInt(productSizeList.size())).click();
            else
                Assert.fail("Product size list is empty");
        } else if (sizeOption.equals("unavailable")) {
            utils.hardWaitForElement(By.xpath(netshoesPage.unavailableProductSizeOptionsXpath));
            List<WebElement> productSizeList = utils.waitForElements(By.xpath(netshoesPage.unavailableProductSizeOptionsXpath));
            if (productSizeList.size() > 0)
                productSizeList.get(random.nextInt(productSizeList.size())).click();
            else
                Assert.fail("Product size list is empty");
        }


    }

    @Then("I should add a item to the cart")
    @Alias("I should try to add a item to the cart")
    public void iShouldAddAItemToTheCart() {
        utils.hardWaitForElement(By.id("buy-button-now"));
        //used sendKeys instead of click because it was unable to click on element
        netshoesPage.buyNowButton.sendKeys(Keys.RETURN);
    }

    @When("I fill the CEP field with the value $cep")
    public void iFillTheCEPField(@Value("cep") String zipCode) {
        WebElement cep = utils.waitForElement(By.id("cep"));
        cep.sendKeys(zipCode);
        cep.submit();

    }

    @Then("I should see the shipping value")
    public void iShouldSeeTheShippingValue() {
        Assert.assertTrue("Buy now button was expected to be displayed, but it was not."
                , netshoesPage.shippingValue.isDisplayed());
    }

    @Then("I should see a error message")
    public void iShouldSeeAErrorMessage() {
        Assert.assertEquals("Error message was expected to be displayed, but it was not", "Produto indisponível", netshoesPage.unavailableProductMessage.getText());
    }

}
