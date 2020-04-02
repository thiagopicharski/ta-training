package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage  extends  AbstractPage{

    private final String ADD_TO_CART_BUTTON_XPATH = "//*[@id=\"productInfo\"]/div[6]/div/div/input[3]";

    public void clickfirstResult() {
        waitElementToBeClickable(By.xpath(ADD_TO_CART_BUTTON_XPATH));
    }

}
