package com.htec.sandbox.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverCloseExtension;
import com.htec.sandbox.WebDriverInitExtension;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.dashboard.playground.TeamsPage;


@ExtendWith({ //
		WebDriverInitExtension.class, //
		LoginExtension.class, //
		WebDriverCloseExtension.class, //
		LogoutExtension.class //
})
public class TeamsPageTest {
	
	private WebDriver driver = WebDriverInstance.get();

	/**
	 * Test case: Create Team
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testCreateSeniority() throws InterruptedException {

		// GIVEN
		String title = "Team " + System.currentTimeMillis();

		// WHEN
		TeamsPage teamsPage = new TeamsPage(driver);
		teamsPage.openPlaygroundCard();		
		teamsPage.navigateToTeamsPage();
		teamsPage.clickCreateTeamButton();
		teamsPage.enterTeamTitle(title);
		teamsPage.clickSubmitButton();

		assertThat(teamsPage.checkIfTeamExists(title)).isTrue();
	}
}
