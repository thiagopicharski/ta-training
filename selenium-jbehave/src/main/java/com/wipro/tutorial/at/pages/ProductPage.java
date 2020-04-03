package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends AbstractPage{
    private static final String PRODUCT_PAGE_SIZE_XPATH = "//*[@id=\"buy-box\"]/section[2]/div/ul/li[7]/a";
    private static final String PRODUCT_PAGE_BUY_BUTTON_XPATH = "//*[@id=\"buy-button-now\"]";


    public void chooseSize(){waitElementToBeClickable(By.xpath(PRODUCT_PAGE_SIZE_XPATH));}

    public void clickBuyButton(){waitElementToBeClickable(By.xpath(PRODUCT_PAGE_BUY_BUTTON_XPATH));}
}
