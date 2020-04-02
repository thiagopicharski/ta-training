package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
	public final String SEARCH_BAR_NAME = "q";

	@Value("${URL}")
	private String URL;

	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}

	private WebElement searchBar() {
		return webDriverProvider.get().findElement(By.name(SEARCH_BAR_NAME));
	}

	public void search(String strSearch) {
		searchBar().sendKeys(strSearch);
	}

	public void clickSearch() {
		waitElementToBeClickable(By.xpath("//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button"));
	}


}
//




