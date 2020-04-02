package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage {
    public final String ADD_CART_PATH ="/html/body/main/div[2]/section/section[3]/section[3]/div[2]/button";

    //Clicar no botão de compra e ver o carrinho
    public void addToCartAndVerify(){
        waitElementToBeClickable(By.xpath(ADD_CART_PATH));
    }



}
