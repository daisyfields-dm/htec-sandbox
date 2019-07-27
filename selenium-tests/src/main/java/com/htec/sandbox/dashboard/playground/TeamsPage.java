package com.htec.sandbox.dashboard.playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamsPage {
	private WebDriver webDriver;

	@FindBy(xpath = "//*[text() = 'TEAMS']")
	private WebElement tbTeams;

	@FindBy(xpath = "//span[contains(text(), 'CREATE TEAM')]")
	private WebElement btnCreateTeam;

	@FindBy(name = "role_name")
	private WebElement tfTitle;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/a[1]")
	private WebElement team;

	@FindBy(xpath = "//*[text() = 'Playground']")
	private WebElement playgroundCard;

	public TeamsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void navigateToTeamsPage() {
		tbTeams.click();
	}

	public void clickCreateTeamButton() {
		btnCreateTeam.click();
	}

	public void enterTeamTitle(String title) {
		tfTitle.sendKeys(title);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public String getTeam() {
		return team.getText();
	}

	public boolean checkIfTeamExists(String team) {
		WebElement element = webDriver.findElement(By.linkText(team));
		return element != null;
	}

	public void openPlaygroundCard() {
		playgroundCard.click();
	}
}
