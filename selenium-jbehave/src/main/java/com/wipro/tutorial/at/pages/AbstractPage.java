package com.wipro.tutorial.at.pages;

import java.lang.reflect.Array;
import java.util.*;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPage {

	@Autowired
	protected WebDriverProvider webDriverProvider;
	private ArrayList<WebElement> list;

	public void waitPageLoad() {
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), 30);		
		wait.until(ExpectedConditions.visibilityOfAllElements(elementsToWait()));
	}
	
	public void waitElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(webDriverProvider.get(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webDriverProvider.get().findElement(locator).click();
	}

	public boolean checkIfIsDisplayedOnScrren(By location) {
		return webDriverProvider.get().findElement(location).isDisplayed();
	}

	public List<WebElement> addElementsToWait(ArrayList<WebElement> elements){
		this.list = elements;
		return this.list;
	}

	protected List<WebElement> elementsToWait() {
		return this.list;
	}
}
