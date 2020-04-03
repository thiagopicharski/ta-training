package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_PRODUCT = "//*[@id=\"item-list\"]/div[1]/div[1]/div[2]/a[1]/span";
	private final String SEARCH_BUTTON_IMAGE = "//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img";
	private final String BUTTON_BUY = "//*[@id=\"buy-button-now\"]";
	private final String SEARCH_BUTTON_BUY = "//*[@id=\"buy-button-now\"]";
	private final String FINAL_PRODUCT = "/html/body/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div/h3";
	
	private WebElement getFirstProduct() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_PRODUCT));
		
	}
	
	public String firstProductText() {
		return getFirstProduct().getText();
	}
	
	public void clickImage() {
		waitElementToBeClickable(By.xpath(SEARCH_BUTTON_IMAGE));
	}
	
	public WebElement getButton() {
		return webDriverProvider.get().findElement(By.xpath(BUTTON_BUY));
		
	}

	public String buttonText() {
		return getButton().getText();
	}
	
	public void clickBuy() {
		waitElementToBeClickable(By.xpath(SEARCH_BUTTON_BUY));
		
	}
		
	public String finalProductText() {
		return getFinalProduct().getText();
	}
	
	private WebElement getFinalProduct() {
		return webDriverProvider.get().findElement(By.xpath(FINAL_PRODUCT));
	}

	public WebElement productCart() {
		return webDriverProvider.get().findElement(By.xpath(FINAL_PRODUCT));
	}
	
}
