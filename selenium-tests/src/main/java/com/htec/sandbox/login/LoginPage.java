package com.htec.sandbox.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static final String PAGE_URL = "https://qa-sandbox.apps.htec.rs/login";

	private WebDriver webDriver;

	@FindBy(name = "email")
	private WebElement emailInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement submitButton;

	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void navigateToLoginPage() {
		webDriver.get(PAGE_URL);
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}
}
