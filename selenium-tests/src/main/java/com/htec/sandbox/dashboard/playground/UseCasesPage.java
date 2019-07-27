package com.htec.sandbox.dashboard.playground;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UseCasesPage {

	private WebDriver webDriver;
	
	public UseCasesPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(partialLinkText = "CREATE USE CASE")
	private WebElement btnCreateUseCase;
	
	@FindBy(className = "text-primary")
	private WebElement btnAddStep;
	
	@FindBy(xpath = "//*[text() = 'Use Cases']")
	private WebElement useCaseCard;
	
	@FindBy(name = "title")
	private WebElement tfTitle;
	
	@FindBy(name = "description")
	private WebElement tfDescription;
	
	@FindBy(name = "expected_result")
	private WebElement tfExpectedResult;
	
	@FindBy(name = "testStepId-0")
	private WebElement tfTestStep;
	
	@FindBy(xpath = "//input[starts-with(@name,'testStepId')]")
	private List<WebElement> tfTestSteps;
	
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement submitButton;
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void openUseCasesCard() {
		useCaseCard.click();
	}
	
	public void clickCreateUseCaseButton() {
		btnCreateUseCase.click();
	}
	
	public void createTestCase(String title, String descritpion, String expectedResult, String steps) {
		tfTitle.sendKeys(title);
		tfDescription.sendKeys(descritpion);
		tfExpectedResult.sendKeys(expectedResult);
		tfTestStep.sendKeys(steps);
	}
	
	public String getTitle() {
		return tfTitle.getAttribute("value");
	}
	
	public void setTitle(String title)
	{
		tfTitle.clear();
		tfTitle.sendKeys(title);
	}
	
	public String getDescription() {
		return tfDescription.getAttribute("value");
	}
	
	public void setDescription(String description) {
		tfDescription.clear();
		tfDescription.sendKeys(description);
	}
	
	public String getExpectedResult() {
		return tfExpectedResult.getAttribute("value");
	}
	
	public void setExpectedResult(String expectedResult) {
		tfExpectedResult.clear();
		tfExpectedResult.sendKeys(expectedResult);
	}
	
	public String[] getSteps() {
		
		String[] steps = new String[tfTestSteps.size()];
		
		for(int i = 0; i < tfTestSteps.size(); i++) {
			steps[i] = tfTestSteps.get(i).getAttribute("value");
		}
		
		return steps;
	}
	
	public void setSteps(String[] steps) {
		for(int i = 0; i < steps.length; i++) {
			tfTestSteps.get(i).clear();
			tfTestSteps.get(i).sendKeys(steps[i]);
		}
	}
	
	public void clickAddStepButton() {
		btnAddStep.click();
	}
	
	public void selectUseCase(String useCaseName) {
		webDriver.findElement(By.linkText(useCaseName)).click();
	}
}
