package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "/html/body/main/div[1]/div/section/ol/li[1]/div/div[1]/div/div/a/img";
	
//	private WebElement getFirstResult() {
//		return webDriverProvider.get().findElement(By.xpath(FIRST_RESULT_XPATH));
//	}
	
//	public void firstResultText() { getFirstResult().click();}

	public void clickfirstResult() {
		waitElementToBeClickable(By.xpath(FIRST_RESULT_XPATH));
	}
}
