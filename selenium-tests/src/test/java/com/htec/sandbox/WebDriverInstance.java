package com.htec.sandbox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInstance {

	private static WebDriverInstance INSTANCE;

	private WebDriver webDriver;

	private WebDriverInstance() {
		webDriver = initWebDriver();
	}

	public static WebDriver get() {
		if (INSTANCE == null) {
			INSTANCE = new WebDriverInstance();
		}
		return INSTANCE.webDriver;
	}

	public static void closeWebDriver() {
		WebDriver webDriver = get();
		webDriver.close();
	}

	private static WebDriver initWebDriver() {
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
