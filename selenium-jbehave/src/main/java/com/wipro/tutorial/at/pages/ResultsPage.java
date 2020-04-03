package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage extends AbstractPage {
	
	private final String FIRST_RESULT_XPATH = "//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img";
	
	public void getFirstResult() {
		waitElementToBeClickable(By.xpath(FIRST_RESULT_XPATH));
	}

}
