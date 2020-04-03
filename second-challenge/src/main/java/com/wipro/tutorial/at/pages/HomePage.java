package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import static org.junit.Assert.assertEquals;

@Component
public class HomePage extends AbstractPage {
	private final String SEARCH_FIELD_XPATH = "//*[@id=\"search-input\"]";
	private final String SEARCH_BUTTON_XPATH = "//*[@id=\"header-content\"]/header/div[1]/section[2]/section/form/div/button";
	private final String CLICK_PRODUCT_XPATH = "//*[@id=\"item-list\"]/div[1]/div[1]/div[1]/a/img";
	private final String CLICK_ADD_XPATH = "//*[@id=\"buy-button-now\"]/span";
	private final String VERIFY_PRODUCT_XPATH = "/html/body/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div/h3";
	
	@Value("${URL}")
	private String URL;
	
	public void navigateTo() {
		webDriverProvider.get().get(URL);
	}
	
	private WebElement searchField() {
		return webDriverProvider.get().findElement(By.xpath(SEARCH_FIELD_XPATH));
	}

	private WebElement searchBtn() {
		return webDriverProvider.get().findElement(By.xpath(SEARCH_BUTTON_XPATH));
	}

	private WebElement searchFirstProduct() {
		return webDriverProvider.get().findElement(By.xpath(CLICK_PRODUCT_XPATH));
	}

	private WebElement searchProductInTheCart() {
		return webDriverProvider.get().findElement(By.xpath(VERIFY_PRODUCT_XPATH));
	}
	
	public void searchProduct(String searchProduct) {
		searchField().sendKeys(searchProduct);
	}

	public void clickSearch() {
		searchBtn().click();
	}

	public void clickFirstProduct() {
		searchFirstProduct().click();
	}

	public void clickAddProduct() {
		waitElementToBeClickable(By.xpath(CLICK_ADD_XPATH));
	}

	public void checkProductInTheCart() {
		assertEquals(searchProductInTheCart().getText(), "Meia Olympikus Sem Cano Pacote Com 3 Masculina");
	}


}



