package com.wipro.ta.pages;

import com.wipro.ta.configuration.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PageObject
public class NetshoesPage {
    @FindBy(id = "search-input")
    public WebElement searchBar;
    @FindBy(id = "item-list")
    public WebElement itemList;
    @FindBy(xpath = "//a[@class='item-card__description__product-name']")
    public List<WebElement> resultsFromSearch;
    @FindBy(xpath = "//section[@class='product-size-selector' and not(p)]/div/ul/li[@class=not(contains(@class,'unavailable'))]")
    public List<WebElement> productSizeOptions;
    @FindBy(xpath = "//section[@class='product-size-selector' and not(p)]/div/ul/li[@class=(contains(@class,'unavailable'))]")
    public List<WebElement> unavailableProductSizeOptions;
    public String productSizeOptionsXpath = "//section[@class='product-size-selector' and not(p)]/div/ul/li[@class=not(contains(@class,'unavailable'))]";
    public String unavailableProductSizeOptionsXpath = "//section[@class='product-size-selector' and not(p)]/div/ul/li[@class=(contains(@class,'unavailable'))]";
    @FindBy(xpath = "//div[@class='tell-me-button-wrapper' and span and strong and not(contains(@style,'overflow: hidden'))]/strong[text()='Produto indisponível']")
    public WebElement unavailableProductMessage;
    @FindBy(id = "buy-button-now")
    public WebElement buyNowButton;
    @FindBy(className = "summary__item-value")
    public WebElement shippingValue;
}
