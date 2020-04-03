package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "/html/body/div[1]/div[2]/div[3]/div[2]/div/div[1]/div/div/h3";
	
	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_XPATH));
	}
	
	public String firstResultText() {
		return getFirstResult().getText();
	}
	
}
