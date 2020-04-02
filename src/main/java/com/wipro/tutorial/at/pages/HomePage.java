package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {

	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}
	
	private WebElement searchField() {
		String SEARCH_FIELD_NAME = "q";
		return webDriverProvider.get().findElement(By.name(SEARCH_FIELD_NAME));
	}
	
	public void search(String strSearch) {
		searchField().sendKeys(strSearch);
	}
	public void clickSearch() {
		String SEARCH_BUTTON_NAME = "button";
		waitElementToBeClickable(By.className(SEARCH_BUTTON_NAME));
	}
}



