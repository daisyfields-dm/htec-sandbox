package com.htec.sandbox.login;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.dashboard.DashboardPage;

public class LoginExtension implements BeforeAllCallback {

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		WebDriver driver = WebDriverInstance.get();

		String email = "daisyfields.dm@gmail.com";
		String password = "blabla123";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();

		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSubmitButton();

		// wait for 1 second
		Thread.sleep(1 * 1000);
		if (!DashboardPage.PAGE_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Login was unsuccessfull!");
		}
	}
}
