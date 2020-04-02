package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends AbstractPage {
    private final String  PRODUCT_ADDED_XPATH  ="/html/body/main/div[1]/div/div/div[1]/div/p";

    private WebElement getProductAdded() {
        return webDriverProvider.get().findElement(By.cssSelector(PRODUCT_ADDED_XPATH));
    }

    public String productAddedText(){
        return getProductAdded().getText();
    }
}
