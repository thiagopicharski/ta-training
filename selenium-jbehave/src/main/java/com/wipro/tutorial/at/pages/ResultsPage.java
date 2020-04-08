package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String BUY_BTN_ID = "buy-button-now";

	public void addToCar(){
		webDriverProvider.get().findElement(By.id(BUY_BTN_ID)).click();
	}
	

	
}
