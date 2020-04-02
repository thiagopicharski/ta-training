package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_NAME = "as_word";
	private final String SEARCH_BUTTON_XPATH = "//button[@class='nav-search-btn']";

	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}
	
	private WebElement searchField() {
		return webDriverProvider.get().findElement(By.name(SEARCH_FIELD_NAME));
	}
	
	public void search(String strSearch) {
		searchField().sendKeys(strSearch);
	}
	public void clickSearch() {
		waitElementToBeClickable(By.xpath(SEARCH_BUTTON_XPATH));
	}
}



