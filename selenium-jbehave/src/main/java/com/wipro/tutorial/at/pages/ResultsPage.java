package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT = "//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img";
	private final String BUY_PRODUCT = "/html/body/main/div[2]/section/section[3]/section[3]/div[2]/button";

	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT));
	}

	public String firstResultText() {
		return getFirstResult().getText();
	}

	public void getBuyProduct() {
		waitElementToBeClickable(By.xpath(BUY_PRODUCT));
	}
}