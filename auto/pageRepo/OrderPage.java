package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="block-history")WebElement ord_alert;
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/a")WebElement my_acct;
	
	
	public String Ord_Alert()
	{
		return ord_alert.getText();
	}
	public void MyAccount()
	{
		my_acct.click();
	}
	
}
