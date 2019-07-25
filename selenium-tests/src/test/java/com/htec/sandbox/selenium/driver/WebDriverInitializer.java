package com.htec.sandbox.selenium.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInitializer {

	public static WebDriver init() {
		String geckoDriverPath = Thread.currentThread().getContextClassLoader()
				.getResource("com/htec/sandbox/selenium/drivers/geckodriver.exe").getPath();
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);

		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
}
