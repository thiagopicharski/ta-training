package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ResultPage extends AbstractPage {

    // Identificador do produto
    public final String PRODUCT_PATH = "//*[@id=\"item-list\"]/div[1]/div/div[1]";

    public void clickProduct(){
        waitElementToBeClickable(By.xpath(PRODUCT_PATH));
    }

}
