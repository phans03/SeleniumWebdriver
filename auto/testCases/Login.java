/*
 Test Participant: Onyinye Phina A.
 
 Test Steps:
 1.	Go to Homepage and navigate to LoginPage
 2.	Login -Enter wrong credentials and Sign in. Expected error message is displayed
 3. Verify error message
 4.	Login -Enter valid credentials and Sign in. Expected error message is displayed
 */
package testCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageRepo.HomePage;
import pageRepo.LoginPage;

public class Login {
	private WebDriver driver;
	private String baseUrl;
	private String e ="lucky@yahoo.com";
	private String p ="lucky55";
	private String f = "luc@yahoo.com";
	private String g ="luc@yahoo";
	
	
	@BeforeTest
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\OOM\\chromedriver.exe");
		driver=new ChromeDriver();
		baseUrl = "http://automationpractice.com/index.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void SignIn()
	{
		//1.	Go to Homepage and navigate to LoginPage
		driver.get(baseUrl);
		HomePage hp =new HomePage(driver);
		hp.SignIn();
		String handle=driver.getWindowHandle();
		driver.switchTo().window(handle);
		
		//2.	Login -Enter non-valid credentials. Expected error message is displayed
		LoginPage lp =new LoginPage(driver);
		lp.email(f);
		lp.password(p);
		lp.Login();	
		
		// 3. Verify error message
		String ExpMsg = lp.Error_Mess();
		String DispMsg = ("Authentication failed.");
		try
		{
			assertEquals(ExpMsg,DispMsg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//4.	Login -Enter wrong credentials. Expected error message is displayed
		lp.email(g);
		lp.password(p);
		lp.Login();
		
		//5.	Verify error message
		String ExpMsg1 = lp.Error_Mess();
		String DispMsg1 = ("Invalid email address.");
		try
		{
			assertEquals(ExpMsg1,DispMsg1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//6.	Login -Enter valid credentials and Sign in
		lp.Signin();
		lp.email(e);
		lp.password(p);
		lp.Login();
	}
	@AfterTest
	public void EndTest()
	{
		driver.quit();
	}
		
}
