package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated method stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="login")WebElement signIn;
	@FindBy(id="email")WebElement email;
	@FindBy(id="passwd")WebElement password;
	@FindBy(id="SubmitLogin")WebElement login;
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/ol/li")WebElement err_Mess;
	@FindBy(xpath="//*[@id=\"create_account_error\"]/ol/li")WebElement acct_err;
	@FindBy(id="email_create")WebElement newemail;
	@FindBy(id="SubmitCreate")WebElement create;
	
	public void Signin()
	{
		signIn.click();
	}
	public void email(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void password(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void Login()
	{
		login.click();
	}
	
	public String Error_Mess()
	{
		return err_Mess.getText();
	}
	
	public String Acct_Err()
	{
		return acct_err.getText();
	}
	
	public void new_account(String New_email)
	{
		newemail.sendKeys(New_email);
	}
	public void create_account()
	{
		create.click();
	}
}
