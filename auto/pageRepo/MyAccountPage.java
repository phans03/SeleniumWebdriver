package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")WebElement my_order;
	@FindBy(className="home")WebElement home;
	
	public void Order()
	{
		my_order.click();
	}
	public void Home()
	{
		home.click();
	}
}
