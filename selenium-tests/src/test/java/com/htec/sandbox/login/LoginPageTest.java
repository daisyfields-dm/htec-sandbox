package com.htec.sandbox.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.dashboard.DashboardPage;
import com.htec.sandbox.selenium.driver.WebDriverInitializer;

@RunWith(BlockJUnit4ClassRunner.class)
public class LoginPageTest {

	private static WebDriver driver;

	@BeforeClass
	public static void initDriver() {
		driver = WebDriverInitializer.init();
	}

	/**
	 * Test case: Login to the QA Sandbox Application
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testSuccessfullLogin() throws InterruptedException {

		// GIVEN
		String email = "daisyfields.dm@gmail.com";
		String password = "blabla123";

		// WHEN
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();

		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSubmitButton();

		// THEN
		// wait for 5 seconds
		Thread.sleep(5 * 1000);
		assertThat(driver.getCurrentUrl()).isEqualTo(DashboardPage.PAGE_URL);
	}

	@AfterClass
	public static void releaseDriver() {
		driver.close();
	}
}
