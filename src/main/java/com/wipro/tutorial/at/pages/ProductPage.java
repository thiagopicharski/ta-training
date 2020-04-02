package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage {
    public final String ADD_CART_BUTTON_ID ="buy-button-now";

    //Clicar no botão de compra e ver o carrinho
    public void addToCartAndVerify(){
        waitElementToBeClickable(By.id(ADD_CART_BUTTON_ID));
    }



}
