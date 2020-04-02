package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartPage extends AbstractPage {

    private final String PRODUCT_IN_CART_CSS_SELECTOR = "body > div.main > div.cart.breakpoint.main > div.cart__items > div.product-items > div > div.product-item__details > div > div > h3";

    public Boolean checkProductIsInCart() {
        return waitToFindElement(By.cssSelector(PRODUCT_IN_CART_CSS_SELECTOR));
    }
}
