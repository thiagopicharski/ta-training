package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_NAME = "q";
	private final String SEARCH_BUTTON_NAME = "//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button";
	private final String SEARCH_CARD_PRODUCT = "//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a";
	private final String SEARCH_KART_BUTTON = "buy-button-now";
	
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
		waitElementToBeClickable(By.xpath(SEARCH_BUTTON_NAME));
	}
	public void clickProduct() {
		waitElementToBeClickable(By.xpath(SEARCH_CARD_PRODUCT));
	}
	public void clickAddKart() {
		waitElementToBeClickable(By.id(SEARCH_KART_BUTTON));
	}
}


