package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ItemPage extends AbstractPage {

    private final String BUY_BUTTOM_XPATH = "buy-button-now";

    public void buyItem(){
        waitElementToBeClickable(By.id(BUY_BUTTOM_XPATH));
    }
}
