package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "//li[@class='results-item highlighted article stack '][1]/div/div[1]";
	
	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.cssSelector(FIRST_RESULT_XPATH));
	}
	
	public void clickFirstResult() {
		getFirstResult().click();
	}
	
}
