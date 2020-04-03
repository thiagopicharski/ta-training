package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends AbstractPage {

    private final String FIRST_ITEM_XPATH= "//h3[@qa-auto=\"product-name\" and @class=\"name\"]";

    private WebElement getFirstItem() {
        waitElementLoad(By.xpath(FIRST_ITEM_XPATH));
        return webDriverProvider.get().findElement(By.xpath(FIRST_ITEM_XPATH));
    }
    public String firstItemText() {
        return getFirstItem().getText();
    }
}
