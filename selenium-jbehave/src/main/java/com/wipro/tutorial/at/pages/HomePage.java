package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_XPATH = "//*[@id=\"search-input\"]";
	private final String SEARCH_BUTTON_XPATH = "//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button";
	
	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}

	public String titlePage() {
		return webDriverProvider.get().getTitle();
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

	public void clickInTheFirstItem() {
		waitElementToBeClickable(By.xpath("//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a"));
	}

	public void clickInSize() {
		waitElementToBeClickable(By.xpath("//*[@id=\"buy-box\"]/section[2]/div/ul/li[3]/a"));
	}

	public void clickInBuy() {
		waitElementToBeClickable(By.xpath("//*[@id=\"buy-button-now\"]"));
	}

	public void clickToGoToBag() {
		waitElementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a"));
		waitElementToBeClickable(By.xpath("//*[@id=\"header-content\"]/header/div[1]/section[5]/a"));
	}

	public boolean checkTheBag() {
		return checkIfIsDisplayedOnScrren(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]"));
	}

	public String titleSearchPage(){
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		list.add(webDriverProvider.get().findElement(By.xpath("//*[@id=\"content\"]/section/section[2]")));
		addElementsToWait(list);
		waitPageLoad();
		return titlePage();
	};
}



