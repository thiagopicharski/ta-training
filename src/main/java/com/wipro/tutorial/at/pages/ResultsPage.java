package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "//*[@id=\"item-list\"]/div[1]/div[1]/div[2]/a[1]";
	private final String BUY_BUTTON_ID = "buy-button-now";
	
	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_XPATH));
	}
	
	public String firstResultText() {
		return getFirstResult().getText();
	}

	public void clickSearch() {
		waitElementToBeClickable(By.xpath(FIRST_RESULT_XPATH));
	}

	public void clickBuy(){
		waitElementToBeClickable(By.id(BUY_BUTTON_ID));
	}
	
}
