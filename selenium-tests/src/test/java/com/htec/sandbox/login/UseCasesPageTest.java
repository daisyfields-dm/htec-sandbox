package com.htec.sandbox.login;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverCloseExtension;
import com.htec.sandbox.WebDriverInitExtension;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.dashboard.playground.UseCasesPage;

@ExtendWith({ //
	WebDriverInitExtension.class, //
	LoginExtension.class, //
	WebDriverCloseExtension.class, //
	LogoutExtension.class //
})
@TestMethodOrder(OrderAnnotation.class)
public class UseCasesPageTest {
	
	private WebDriver driver = WebDriverInstance.get();

	@Test
	@Order(1)
	public void create4UseCases() throws InterruptedException {
		
		// GIVEN
		int testCasesCount = 5;
		int stepCount = 2;
		
		UseCasesPage useCasePage = new UseCasesPage(driver);
		useCasePage.openUseCasesCard();
		
		// Create Use Cases
		for (int testIndex = 1; testIndex <= testCasesCount; testIndex++){
			
			useCasePage.clickCreateUseCaseButton();
			
			String title = "Title " + Integer.toString(testIndex);
			String description = "Description " + Integer.toString(testIndex);
			String expectedResult = "Expected Result " + Integer.toString(testIndex);
			String steps = "";
			
			// Create steps
			for (int stepIndex = 1; stepIndex <= stepCount; stepIndex++){
				
				steps = steps + "Step " + Integer.toString(testIndex) + "." + Integer.toString(stepIndex);
				
				if (stepIndex != stepCount)
					steps = steps + ", ";	
			}
			
			useCasePage.createTestCase(title, description, expectedResult, steps);
			useCasePage.clickSubmitButton();
		}
	}

	@Test
	@Order(2)
	public void modifyUseCase() throws InterruptedException {
		
		// GIVEN
		String useCaseName = "Title 5";
		
		UseCasesPage useCasePage = new UseCasesPage(driver);
		useCasePage.openUseCasesCard();
		useCasePage.selectUseCase(useCaseName);
		
		// Modify Title
		String title = useCasePage.getTitle();
		useCasePage.setTitle(getModifiedText(title));
		
		// Modify Description
		String description =  useCasePage.getDescription();
		useCasePage.setDescription(getModifiedText(description));
		
		// Modify Expected Result
		String expectedResult = useCasePage.getExpectedResult();
		useCasePage.setExpectedResult(getModifiedText(expectedResult));
		
		// Modify steps
		String[] steps = useCasePage.getSteps();
		for(int i = 0; i < steps.length; i++) {
			steps[i] = getModifiedText(steps[i]);
		}
		useCasePage.setSteps(steps);
		
		useCasePage.clickSubmitButton();
	}
	
	private String getModifiedText(String text)
	{
		return "This field previously had " + Integer.toString(text.length()) + " characters.";
	}
}
