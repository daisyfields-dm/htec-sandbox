import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.htec.sandbox.WebDriverCloseExtension;
import com.htec.sandbox.WebDriverInitExtension;
import com.htec.sandbox.WebDriverInstance;
import com.htec.sandbox.login.LoginExtension;
import com.htec.sandbox.login.LogoutExtension;

@ExtendWith({ //
	WebDriverInitExtension.class, //
	LoginExtension.class, //
	WebDriverCloseExtension.class, //
	LogoutExtension.class //
})
public class EditTestCase {
	
	public WebDriver driver = WebDriverInstance.get();
	
	public void openUseCasesCard() {
		driver.findElement(By.xpath("//*[text() = 'Use Cases']")).click();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditTestCase editTestCases = new EditTestCase();
		editTestCases.openUseCasesCard();
	}

}
