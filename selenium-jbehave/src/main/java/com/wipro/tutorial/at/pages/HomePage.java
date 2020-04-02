package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_XPATH = "/html/body/header/div/form/input";
	private final String SEARCH_BUTTON_XPATH = "/html/body/header/div/form/button/div";
	
	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}
	
	private WebElement searchField() {
		return webDriverProvider.get().findElement(By.xpath(SEARCH_FIELD_XPATH));
	}
	
	public void search(String strSearch) {
		searchField().sendKeys(strSearch);
	}
	public void clickSearch() {
		waitElementToBeClickable(By.xpath(SEARCH_BUTTON_XPATH));
	}
}



