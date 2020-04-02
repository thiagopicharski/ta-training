package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_NAME = "search-input";
	private final String FIRST_RESULT = "item-card__images";
	private final String ID_BUTTON_CART = "buy-button-now";
	private final String CLASS_BUTTON_CONTINUE = "/html/body/div[1]/div[2]/div[3]/div[1]/div[2]/a[1]";

	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}
	
	private WebElement searchField() {
		return webDriverProvider.get().findElement(By.id(SEARCH_FIELD_NAME));
	}
	
	public void search(String strSearch) {
		searchField().sendKeys(strSearch);
		searchField().sendKeys(Keys.ENTER);
	}

	public void clickFirstResult() {
		List<WebElement> li = webDriverProvider.get().findElements(By.className(FIRST_RESULT));
		li.get(0).click();
	}
	public void clickAddCart() {
		webDriverProvider.get().findElement(By.id(ID_BUTTON_CART)).click();
	}
}



