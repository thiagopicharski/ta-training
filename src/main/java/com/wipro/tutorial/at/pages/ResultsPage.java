package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String RESULT_XPATH = "//*[@id='item-list']/div[1]/div[1]/div[1]/a/img"; //id="MLB1420706127" xpath=//*[@id="MLB1420706127"]/div/div
	private final String BUY_BTN = "buy-button-now";

	private WebElement getResult() {
		return webDriverProvider.get().findElement(By.xpath(RESULT_XPATH));
	}

	private WebElement addToMyCart(){
		return webDriverProvider.get().findElement(By.id(BUY_BTN));
	}

	public void clickProduct() {
		waitElementToBeClickable(By.xpath(RESULT_XPATH));
		getResult().click();
	}
	public void clickBuy() {
		waitElementToBeClickable(By.id(BUY_BTN));
		addToMyCart().click();
	}

	public WebElement message(){
		return webDriverProvider.get().findElement(By.tagName("h1"));
	}
	
}
