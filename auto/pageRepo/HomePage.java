package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated method stub

		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="login")WebElement SignIn;
	
	public void SignIn()
	{
		SignIn.click();
	}
	
}
