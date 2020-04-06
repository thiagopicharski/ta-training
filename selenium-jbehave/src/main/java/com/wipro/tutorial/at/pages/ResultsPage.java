package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "//div[@data-position='0']/div";
	private	final String FIRST_RESULT_SPAN_XPATH = "(//div[@data-position='0']//span)[2]";

	private WebElement getFirstResult() {
		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_XPATH));
	}
	private	WebElement getResultText(){
		return	webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_SPAN_XPATH));

	}
	public String firstResultText() {
		return getResultText().getText();
	}
	public void clickFirstResult (){
		getFirstResult().click();
	}
}
