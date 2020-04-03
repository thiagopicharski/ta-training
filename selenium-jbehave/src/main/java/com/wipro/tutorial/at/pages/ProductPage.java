package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage  extends  AbstractPage{

    private final String ADD_TO_CART_BUTTON_XPATH = "//*[@id=\"productInfo\"]/div[6]/div/div/input[3]";
    private final String CART_BUTTON_XPATH = "/html/body/main/div[1]/div/div/div[2]/div[2]/a[1]";


    public void clickFirstResult() {
        waitElementToBeClickable(By.xpath(ADD_TO_CART_BUTTON_XPATH));
    }
    public void clickCartButton() {
        waitElementToBeClickable(By.xpath(CART_BUTTON_XPATH));
    }


}
