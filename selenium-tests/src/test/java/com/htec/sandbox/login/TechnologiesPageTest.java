package com.htec.sandbox.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverCloseExtension;
import com.htec.sandbox.WebDriverInitExtension;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.dashboard.playground.TechnologiesPage;

@ExtendWith({ //
		WebDriverInitExtension.class, //
		LoginExtension.class, //
		WebDriverCloseExtension.class, //
		LogoutExtension.class //
})
public class TechnologiesPageTest {

	private WebDriver driver = WebDriverInstance.get();

	/**
	 * Test case: Create Technology
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testCreateTechnology() throws InterruptedException {

		// GIVEN
		String title = "Virtual reality" + System.currentTimeMillis();

		// WHEN
		TechnologiesPage technologiesPage = new TechnologiesPage(driver);
		technologiesPage.openPlaygroundCard();		
		technologiesPage.navigateToTechnologiesPage();
		technologiesPage.clickCreateTechnologyButton();
		technologiesPage.enterTechnologyTitle(title);
		technologiesPage.clickSubmitButton();

		assertThat(technologiesPage.checkIfTechnologyExists(title)).isTrue();
	}
}
