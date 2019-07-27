package com.htec.sandbox.dashboard.playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SenioritiesPage {
	//public static final String DASHBOARD_PAGE_URL = "https://qa-sandbox.apps.htec.rs/dashboard";
	public static final String PROJECTS_PAGE_URL = "https://qa-sandbox.apps.htec.rs/projects";
	//public static final String PAGE_URL = "https://qa-sandbox.apps.htec.rs/technologies";

	private WebDriver webDriver;

	@FindBy(xpath = "//*[text() = 'SENIORITIES']")
	private WebElement tbSeniorities;

	@FindBy(xpath = "//span[contains(text(), 'CREATE SENIORITY')]")
	private WebElement btnCreateSeniority;

	@FindBy(name = "seniority_title")
	private WebElement tfTitle;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/a[1]")
	private WebElement seniority;

	@FindBy(xpath = "//*[text() = 'Playground']")
	private WebElement playgroundCard;

	public SenioritiesPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void navigateToSenioritiesPage() {
		tbSeniorities.click();
	}

	public void clickCreateSeniorityButton() {
		btnCreateSeniority.click();
	}

	public void enterSeniorityTitle(String title) {
		tfTitle.sendKeys(title);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public String getSeniority() {
		return seniority.getText();
	}

	public boolean checkIfSeniorityExists(String seniority) {
		WebElement element = webDriver.findElement(By.linkText(seniority));
		return element != null;
	}

	public void openPlaygroundCard() {
		playgroundCard.click();
		//webDriver.get(PROJECTS_PAGE_URL);
	}
}
