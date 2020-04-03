package com.wipro.tutorial.at.configuration;

import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

class ParametrizedWebDriverProvider extends PropertyWebDriverProvider {

    @Value("${chromeDataDir}")
    String userData;

    @Override
    protected ChromeDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + userData);
        options.addArguments("--profile-directory=Default");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}
