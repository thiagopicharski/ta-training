package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_CSS = "#rso > div:nth-child(1) > div > div.r > a > h3";
	
	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.cssSelector(FIRST_RESULT_CSS));
	}
	
	public String firstResultText() {
		return getFirstResult().getText();
	}
	
}
