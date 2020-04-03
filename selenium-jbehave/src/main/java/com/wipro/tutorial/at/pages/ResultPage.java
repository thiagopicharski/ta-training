package com.wipro.tutorial.at.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ResultPage extends AbstractPage{
    private static final String RESULT_PAGE_XPATH = "//*[@id=\"item-list\"]/div[1]/div[1]/div[2]/a[1]/span";

    public void clickOnFirstResult(){waitElementToBeClickable(By.xpath(RESULT_PAGE_XPATH));}
}
