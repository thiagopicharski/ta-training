package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends AbstractPage{

    private final String CART_RESULT_CSS = "body > div.main > div.cart.breakpoint.main > div.cart__items > div.product-items > div > div.product-item__details > div > div > h3";

    public WebElement checkText(){
        return webDriverProvider.get().findElement(By.cssSelector(CART_RESULT_CSS));
    }

}
