package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_NAME = "//*[@id=\"search-input\"]";
	private final String SEARCH_BUTTON_NAME = "//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button";
	private final String CLICK_PRODUCT = "//*[@id=\"quick-view-button\"]";
	private final String ADD_CART = "//*[@id=\"buy-button-now\"]/span";
	
	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}
	
	private WebElement searchField() {
		return webDriverProvider.get().findElement(By.xpath(SEARCH_FIELD_NAME));
	}
	
	public void search(String strSearch) {
		searchField().sendKeys(strSearch);
	}
	public void clickSearch() {
		waitElementToBeClickable(By.xpath(SEARCH_BUTTON_NAME));
		
	}
	
	public void clickProduct() {
		waitElementToBeClickable(By.xpath(CLICK_PRODUCT));
	}
	
	public void addCart() {
		waitElementToBeClickable(By.xpath(ADD_CART));
	}
}



