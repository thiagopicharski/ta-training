package com.wipro.tutorial.at.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage {
    private final String FIRST_BUTTON_ID = "buy-button-now";

    private WebElement getBuyButton () {
        return webDriverProvider.get().findElement(By.id(FIRST_BUTTON_ID));

    }
    public void clickButton () {
        getBuyButton().click();
    }
}

