package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage {

    private final String ADD_CART_BUTTON_ID = "buy-button-now";

    public void clickBuyButton() {
        waitElementToBeClickable(By.id(ADD_CART_BUTTON_ID));
    }
}
