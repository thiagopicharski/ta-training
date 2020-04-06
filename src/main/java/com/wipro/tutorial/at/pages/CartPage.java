package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends AbstractPage {
    private final String PRODUCT_IN_CART = "body > div.main > div.cart.breakpoint.main > div.cart__items > div.product-items > div > div.product-item__details > div > div > h3";

    public Boolean checkProductIsInCart() {
        return waitToFindElement(By.cssSelector(PRODUCT_IN_CART));
    }
}
