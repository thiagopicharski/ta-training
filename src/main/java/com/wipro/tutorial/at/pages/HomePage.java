package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_NAME = "q";
	private final String SEARCH_BUTTON_CLASS = "button";
	private final String GORRO_XPATH = "//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img";
	private final String SHOE_SIZE_XPATH = "//*[@id=\"buy-box\"]/section[2]/div[1]/ul/li[2]/a";
	private final String CART_BUTTON_XPATH = "//*[@id=\"buy-button-now\"]";
	
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
		waitElementToBeClickable(By.className(SEARCH_BUTTON_CLASS));
	}
	public void clickGorro() {
		waitElementToBeClickable(By.xpath(GORRO_XPATH));
	}
	public void addGorroToCart(){
		waitElementToBeClickable(By.xpath(CART_BUTTON_XPATH));
	}
}