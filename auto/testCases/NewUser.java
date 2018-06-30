/*
 Test Participant: Onyinye Phina A.
 
 Test Steps:
 1.	Go to Homepage and navigate to LoginPage
 2.	Create new account - Enter no data. Expected error message is displayed
 3.	Verify error message
 4. Create new account -Enter wrong data. Expected error message is displayed
 5.	Verify error message
 6.	Create new account with correct data and navigate to Register page
 7. Register new account -Enter no credentials. Expected error messages are displayed
 8. Verify error message
 9.	Register new account -Enter incomplete credentials. Expected error message are displayed
 10	Verify error message
 11	Register new account -Enter wrong credentials. Expected error messages are displayed
 12	Verify error message
 13	Register new account -Enter all required credentials and register
 14 Register new account -Enter existing account credentials. Expected error messages are displayed
 15	Verify error message
 */
package testCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageRepo.HomePage;
import pageRepo.LoginPage;
import pageRepo.New_AccountPage;

public class NewUser {
	private WebDriver driver;
	private String BaseUrl;
	private String e ="lucky@yahoo.com";
	private String p ="lucky55";
	private String f = "lucky";
	private String l = "john";
	//private String add = "2 Johnson street";
	//private String pc ="00244";
	private String d = "23";
	private String m ="sep";
	private String y = "1998";
	//private String cty = "Oxford";
	//private String s = "al";
	//private String mob = "0123456789";
	
	@BeforeTest
	public void Startup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\OOM\\chromedriver.exe");
		driver = new ChromeDriver();
		BaseUrl = "http://automationpractice.com/index.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void CreateAccount()
	{
		//1.	Go to Homepage and navigate to LoginPagedriver.get(BaseUrl);
		driver.get(BaseUrl);
		HomePage hp =new HomePage(driver);
		hp.SignIn();
		String handle=driver.getWindowHandle();
		driver.switchTo().window(handle);
		
		//2.	Create new account - Enter no data. Expected error message is displayed
		LoginPage lp =new LoginPage(driver);
		lp.create_account();
		
		//3.	Verify error message
		String ExpMsg1 = lp.Acct_Err();
		String DispMsg1 = ("Invalid email address.");
		try
		{
			assertEquals(ExpMsg1,DispMsg1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//4. Create new account -Enter wrong data. Expected error message is displayed
		lp.new_account(f);
		lp.create_account();
		
		//5.	Verify error message
		String ExpMsg2 = lp.Acct_Err();
		String DispMsg2 = ("Invalid email address.");
		try
		{
			assertEquals(ExpMsg2,DispMsg2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
						
		//6.	Create new account with correct data and navigate to Register page
		lp.new_account(e);		//f+e = luckylucky@yahoo.com
		lp.create_account();
		
		//7.	Register new account -Enter no credentials. Expected error messages are displayed
		String handle1=driver.getWindowHandle();
		driver.switchTo().window(handle1);
		New_AccountPage na =new New_AccountPage(driver);
		na.Register();
		
		//8.	Verify error message
		Boolean ExpMsg = na.ErrorMsg();
		Boolean DispMsg = (true);
		try
		{
			assertEquals(ExpMsg,DispMsg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//9.	Register new account -Enter incomplete credentials. Expected error message are displayed
		na.Mr();
		na.Fname(f);
		na.Lname(l);
		na.Password(p);
		//na.Home();
		na.Register();
		
		//10.	Verify error message
		Boolean ExpMsg0 = na.ErrorMsg();
		Boolean DispMsg0 = (true);
		try
		{
			assertEquals(ExpMsg0,DispMsg0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//11.	Register new account -Enter wrong credentials. Expected error messages are displayed
		na.Day(d);
		na.Month(m);
		na.Year(y);
		na.Postcode(d); 	//wrong credential
		na.Mobile(m); 		//wrong credential
		na.Register();
		
		//12.	Verify error message
		Boolean ExpMsg3 = na.ErrorMsg();
		Boolean DispMsg3 = (true);
		try
		{
			assertEquals(ExpMsg3,DispMsg3);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		/*13.	Register new account -Enter all required credentials and register
		na.Authentication();
		String handle2=driver.getWindowHandle();
		driver.switchTo().window(handle2);
		lp.new_account(e);
		lp.create_account();
		String handle3=driver.getWindowHandle();
		driver.switchTo().window(handle3);
		
		na.Mr();
		na.Fname(f);
		na.Lname(l);
		na.Password(p);
		na.Day(d);
		na.Month(m);
		na.Year(y);
		na.Special();
		na.Add(add);
		na.City(cty);
		na.State(s);
		na.Postcode(pc);
		na.Mobile(mob);
		na.Register();		*/
		
		//14. 	Register new account -Enter existing account credentials. Expected error messages are displayed
		na.Authentication();
		String handle4=driver.getWindowHandle();
		driver.switchTo().window(handle4);
		lp.new_account(e);
		lp.create_account();
				
		//15.	Verify error message
		String ExpMsg4 = lp.Acct_Err();
		String DispMsg4 = ("An account using this email address has already been registered. Please enter a valid password or request a new one.");
		try
		{
			assertEquals(ExpMsg4,DispMsg4);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@AfterTest
	public void EndTest()
	{
		driver.quit();
	}
			
}
