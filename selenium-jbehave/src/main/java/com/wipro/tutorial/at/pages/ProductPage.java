package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage{
    
    private final String ADD_CART_BTN_XPATH = "//div[@class='vip-action-primary']/input[3]";

    private WebElement getAddButton(){
        return webDriverProvider.get().findElement(By.xpath(ADD_CART_BTN_XPATH));
    }

    public void clickAddButton(){
        getAddButton().click();
    }
}
