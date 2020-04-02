package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	public String finish() {
		//waitPageLoad();
		return webDriverProvider.get().getCurrentUrl();
	}
}
