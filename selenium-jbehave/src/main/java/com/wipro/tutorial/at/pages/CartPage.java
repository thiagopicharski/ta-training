package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartPage extends AbstractPage {
    private final String  PRODUCT_ADDED_XPATH  ="/html/body/main/div[1]/div/div/div[1]/div/p";
    private final String CART_ITEM_CLASS_NAME = "item__title--link";

    public boolean isIteminTheCart(String itemText){
        List<WebElement> elements = webDriverProvider.get().findElements(By.className(CART_ITEM_CLASS_NAME));

        for (WebElement element : elements){
            if (element.getText() .equals(itemText)){

                return true;
            }
        }
        return false;
    }

    private WebElement getProductAdded() {
        return webDriverProvider.get().findElement(By.xpath(PRODUCT_ADDED_XPATH));
    }

    public String productAddedText(){
        return getProductAdded().getText();
    }
}
