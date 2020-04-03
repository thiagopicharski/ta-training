package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {

    private final String FIRST_RESULT = "//*[@id=\"item-list\"]/div[1]/div[1]/div[2]/a[1]";
    private final String ADD_TO_CART_BUTTON = "buy-button-now";
    private final String ADDED_ITEM_TITLE = "*[qa-auto=product-name]";

    private WebElement getFirstResult() {
        return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT));
    }

    private WebElement getAddToCart() {
        return webDriverProvider.get().findElement(By.id(ADD_TO_CART_BUTTON));
    }

    public void clickFirstResult() {
        getFirstResult().click();
    }

    public void clickAddToCart() {
        getAddToCart().click();
    }

    public String addedItemTitle() {
        String title = webDriverProvider.get().findElement(By.cssSelector(ADDED_ITEM_TITLE)).getText();
        return title;
    }

}
