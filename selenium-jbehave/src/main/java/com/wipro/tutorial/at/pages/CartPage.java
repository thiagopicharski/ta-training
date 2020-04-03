package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartPage extends AbstractPage{

     private final String CART_ITEM_TEXT_CSS = ".cart-congrats__item-title";

     public List<String> getCartItems(){
         List<WebElement> cartElements = webDriverProvider.get().findElements(By.className(CART_ITEM_TEXT_CSS));
         List<String> texts = new ArrayList<>();
         for (WebElement element : cartElements)
             texts.add(element.getText());
         return texts;
     }

}
