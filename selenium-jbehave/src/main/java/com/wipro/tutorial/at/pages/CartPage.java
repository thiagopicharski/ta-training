package com.wipro.tutorial.at.pages;

import org.springframework.stereotype.Component;

@Component

public class CartPage extends AbstractPage {
    private final String CART_URL = "https://www.netshoes.com.br/novo-cart";
    public boolean cartPageCheck(){
     String currentUrl = webDriverProvider.get().getCurrentUrl();
     if (currentUrl.equals(CART_URL)) return true;
     else return false;
    }

}
