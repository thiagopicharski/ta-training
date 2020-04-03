package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_NAME = "q";
	private final String SEARCH_BUTTON_NAME = "//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button";
	private final String BUY_BUTTON_NAME = "//*[@id=\"buy-button-now\"]";
	private final String CONTINUE_BUTTON_NAME = "/html/body/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/a";
	private final String CONTINUE_SHOPPING_BUTTON_NAME = "/html/body/div[1]/div[2]/div[3]/div[1]/div[2]/a[2]";

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

	public void clickBuy() {
		waitElementToBeClickable(By.xpath(BUY_BUTTON_NAME));
	}

	public void clickContinue() {
		waitElementToBeClickable(By.xpath(CONTINUE_BUTTON_NAME));
	}

	public void clickContinueShopping(){
		waitElementToBeClickable(By.xpath(CONTINUE_SHOPPING_BUTTON_NAME));
	}

}



