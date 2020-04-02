package com.wipro.tutorial.at.configuration;

import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

public class CustomWebDriverProvider extends PropertyWebDriverProvider {
    @Value("${DATA_PATH}")
    private String DATA_PATH;

    @Override
    protected ChromeDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(String.format("user-data-dir="+DATA_PATH));
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}
