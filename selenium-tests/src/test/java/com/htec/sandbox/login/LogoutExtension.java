package com.htec.sandbox.login;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.Pageheader;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.welcome.WelcomePage;

public class LogoutExtension implements AfterAllCallback {

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		WebDriver driver = WebDriverInstance.get();

		Pageheader pageHeader = new Pageheader(driver);
		pageHeader.clickLogoutLink();

		// wait for 1 second
		Thread.sleep(1 * 1000);
		if (!WelcomePage.PAGE_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Logout was unsuccessfull!");
		}
	}
}
