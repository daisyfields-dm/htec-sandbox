package com.htec.sandbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageheader {

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	public Pageheader(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	public void clickLogoutLink() {
		logoutLink.click();
	}
}
