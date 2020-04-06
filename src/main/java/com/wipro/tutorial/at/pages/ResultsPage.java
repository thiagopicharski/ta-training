package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	private final String FIRST_RESULT_CSS = "#item-list > div.wrapper > div:nth-child(1) > div.item-card__description > a.item-card__description__product-name";

	public void clickProduct() {
		waitElementToBeClickable(By.cssSelector(FIRST_RESULT_CSS));
	}

}
