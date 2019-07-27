package com.htec.sandbox.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverCloseExtension;
import com.htec.sandbox.WebDriverInitExtension;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.dashboard.playground.SenioritiesPage;

@ExtendWith({ //
		WebDriverInitExtension.class, //
		LoginExtension.class, //
		WebDriverCloseExtension.class, //
		LogoutExtension.class //
})
public class SenioritiesPageTest {
	
	private WebDriver driver = WebDriverInstance.get();

	/**
	 * Test case: Create Seniority
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testCreateSeniority() throws InterruptedException {

		// GIVEN
		String title = "Seniority " + System.currentTimeMillis();

		// WHEN
		SenioritiesPage senioritiesPage = new SenioritiesPage(driver);
		senioritiesPage.openPlaygroundCard();		
		senioritiesPage.navigateToSenioritiesPage();
		senioritiesPage.clickCreateSeniorityButton();
		senioritiesPage.enterSeniorityTitle(title);
		senioritiesPage.clickSubmitButton();

		assertThat(senioritiesPage.checkIfSeniorityExists(title)).isTrue();
	}
}
