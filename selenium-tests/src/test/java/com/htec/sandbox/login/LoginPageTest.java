package com.htec.sandbox.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverCloseExtension;
import com.htec.sandbox.WebDriverInitExtension;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.dashboard.DashboardPage;

@ExtendWith({ //
		WebDriverInitExtension.class, //
		WebDriverCloseExtension.class, //
})
@TestMethodOrder(OrderAnnotation.class)
public class LoginPageTest {

	private WebDriver driver = WebDriverInstance.get();

	@Test
	@Order(1)
	public void testUnsuccessfullLoginEmailOnly() throws InterruptedException {

		// GIVEN
		String email = "daisyfields.dm@gmail.com";

		// WHEN
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();

		loginPage.enterEmail(email);
		loginPage.clickSubmitButton();

		// THEN
		// wait for 1 second
		Thread.sleep(1000);
		assertThat(driver.getCurrentUrl()).isEqualTo(LoginPage.PAGE_URL);
		assertThat(loginPage.getErrorMessage()).isEqualTo("Password is required");
	}

	/**
	 * Test case: Login to the QA Sandbox Application With Wrong Credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test
	@Order(2)
	public void testUnsuccessfullLoginWrongPassword() throws InterruptedException {

		// GIVEN
		String email = "daisyfields.dm@gmail.com";
		String password = "blabla12";

		// WHEN
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();

		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSubmitButton();

		// THEN
		// wait for 1 second
		Thread.sleep(1000);
		assertThat(driver.getCurrentUrl()).isEqualTo(LoginPage.PAGE_URL);
		assertThat(loginPage.getErrorMessage()).isEqualTo("Password incorrect");
	}

	@Test
	@Order(3)
	public void testUnsuccessfullLoginWrongEmail() throws InterruptedException {

		// GIVEN
		String email = "duska.miloradovic@gmail.com";
		String password = "blabla123";

		// WHEN
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();

		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSubmitButton();

		// THEN
		// wait for 1 second
		Thread.sleep(1000);
		assertThat(driver.getCurrentUrl()).isEqualTo(LoginPage.PAGE_URL);
		assertThat(loginPage.getErrorMessage()).isEqualTo("User not found");
	}

	/**
	 * Test case: Login to the QA Sandbox Application
	 * 
	 * @throws InterruptedException
	 */
	@Test
	@Order(4)
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
		// wait for 1 second
		Thread.sleep(1 * 1000);
		assertThat(driver.getCurrentUrl()).isEqualTo(DashboardPage.PAGE_URL);
	}
}
