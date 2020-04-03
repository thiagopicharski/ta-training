package com.wipro.tutorial.at.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class FinalPage extends AbstractPage{
    private static final String FINAL_PAGE_PRODUCT_NAME_XPATH = "//*[@id=\"content\"]/div[2]/section/section[1]/h1";
    private static final String FINAL_PAGE_PRODUCT_NAME_CART_XPATH = "/html/body/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div/h3";
    private static final String FINAL_PAGE_CART_XPATH = "//*[@id=\"header-content\"]/header/div[1]/section[5]/a";

    public void clickOnCart(){
        waitElementToBeClickable(By.xpath(FINAL_PAGE_CART_XPATH));
    }

    private WebElement findProductNameElement(){
        return webDriverProvider.get().findElement(By.xpath(FINAL_PAGE_PRODUCT_NAME_XPATH));
    }

    public String getProductName(){
        return findProductNameElement().getText();
    }

    private WebElement findProductNameOnCartElement(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriverProvider.get(), 30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FINAL_PAGE_PRODUCT_NAME_CART_XPATH)));
        return webDriverProvider.get().findElement(By.xpath(FINAL_PAGE_PRODUCT_NAME_CART_XPATH));
    }

    public String getProductNameOnCart(){
        return findProductNameOnCartElement().getText();
    }
}
