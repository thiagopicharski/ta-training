package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "//li[@class='results-item highlighted article stack '][1]";
	private final String FIRST_RESULT_CLICKABLE_XPATH = FIRST_RESULT_XPATH + "/div/div[1]";
	private final String FIRST_RESULT_SPAM_XPATH = FIRST_RESULT_XPATH + "//span[1]";

	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_CLICKABLE_XPATH));
	}

	public String getFirstResultText() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_SPAM_XPATH)).getText();
	}

	public void clickFirstResult() {
		getFirstResult().click();
	}


	
}
