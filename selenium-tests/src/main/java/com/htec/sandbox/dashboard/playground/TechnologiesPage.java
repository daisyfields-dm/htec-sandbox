package com.htec.sandbox.dashboard.playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechnologiesPage {
	public static final String DASHBOARD_PAGE_URL = "https://qa-sandbox.apps.htec.rs/dashboard";
	public static final String PROJECTS_PAGE_URL = "https://qa-sandbox.apps.htec.rs/projects";
	public static final String PAGE_URL = "https://qa-sandbox.apps.htec.rs/technologies";

	private WebDriver webDriver;

	@FindBy(xpath = "//*[text() = 'TECHNOLOGIES']")
	private WebElement tbTechnologies;

	@FindBy(xpath = "//span[contains(text(), 'CREATE TECHNOLOGY')]")
	private WebElement btnCreateTechnology;

	@FindBy(name = "technology_title")
	private WebElement tfTitle;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/a[1]")
	private WebElement technology;

	@FindBy(xpath = "//*[text() = 'Playground']")
	private WebElement playgroundCard;

	public TechnologiesPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void navigateToTechnologiesPage() {
		tbTechnologies.click();
	}

	public void clickCreateTechnologyButton() {
		btnCreateTechnology.click();
	}

	public void enterTechnologyTitle(String title) {
		tfTitle.sendKeys(title);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public String getTechnology() {
		return technology.getText();
	}

	public boolean checkIfTechnologyExists(String technology) {
		WebElement element = webDriver.findElement(By.linkText(technology));
		return element != null;
	}

	public void openPlaygroundCard() {
		playgroundCard.click();
		//webDriver.get(PROJECTS_PAGE_URL);
	}
}
