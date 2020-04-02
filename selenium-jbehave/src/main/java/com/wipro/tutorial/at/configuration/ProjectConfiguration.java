package com.wipro.tutorial.at.configuration;

import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ComponentScan({"com.wipro.tutorial"})
@PropertySource("classpath:configs/env.properties")
public class ProjectConfiguration {


	@Value("${DATA_PATH}")
	private String DATA_PATH;

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public WebDriverProvider webDriverProvider() {
		WebDriverProvider webDriverProvider = new CustomPropertyWebDriver();
		System.setProperty("browser", "chrome");
		if (System.getProperty("webdriver.chrome.driver") == null ) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		}
		return webDriverProvider;
	}

	@Bean
	public WebDriverScreenshotOnFailure screenshotOnFailureDriver() {
		return new WebDriverScreenshotOnFailure(webDriverProvider());
	}
	class CustomPropertyWebDriver implements WebDriverProvider{
		private WebDriver driver;
		public CustomPropertyWebDriver(){
			this.driver = createChromeDriver();
		}
		protected ChromeDriver createChromeDriver() {
			//String dataPath = "C:\\Users\\RE40044402\\AppData\\Local\\Google\\Chrome\\User Data";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--user-data-dir="+DATA_PATH);
			options.addArguments("--profile-directory=Default");
			options.addArguments("--disable-extensions");
			options.addArguments("--start-maximized");
			return new ChromeDriver(options);
		}
		@Override
		public WebDriver get() {
			return driver;
		}
		@Override
		public void initialize() {
		}
		@Override
		public boolean saveScreenshotTo(String path) {
			return true;
		}
		@Override
		public void end() {
			this.driver.quit();
		}
	}

}
