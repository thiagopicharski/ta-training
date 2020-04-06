package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage {
    private final String ADD_TO_CART_BUTTON_ID = "buy-button-now";
    private final String PRODUCT_NAME_SELECTOR = "#content > div:nth-child(3) > section > section.short-description > h1";

    public void addToCart() {
        waitElementToBeClickable(By.id(ADD_TO_CART_BUTTON_ID));
    }
}
