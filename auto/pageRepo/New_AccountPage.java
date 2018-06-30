package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_AccountPage {

	WebDriver driver;
	public New_AccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="home")WebElement Home;
	@FindBy(xpath ="//*[@id=\"columns\"]/div[1]/a[2]")WebElement authentic;
	@FindBy(id="uniform-id_gender1")WebElement mr;
	@FindBy(id="uniform-id_gender2")WebElement mrs;
	@FindBy(id="customer_firstname")WebElement cust_firstname;
	@FindBy(id="customer_lastname")WebElement cust_lastname;
	@FindBy(id="passwd")WebElement password;
	@FindBy(id="days")WebElement day;
	@FindBy(id="months")WebElement month;
	@FindBy(id="years")WebElement year;
	@FindBy(id="newsletter")WebElement sign_news;
	@FindBy(id="optin")WebElement special_offer;
	@FindBy(id="company")WebElement company;
	@FindBy(id="address1")WebElement address;
	@FindBy(id="address2")WebElement address2;
	@FindBy(id="city")WebElement city;
	@FindBy(id="id_state")WebElement state;
	@FindBy(id="postcode")WebElement postcode;
	@FindBy(id="id_country")WebElement country;
	@FindBy(id="other")WebElement add_info;
	@FindBy(id="phone")WebElement phone;
	@FindBy(id="phone_mobile")WebElement mobile;
	@FindBy(id="alias")WebElement alias_add;
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p")WebElement error;
	@FindBy(id="submitAccount")WebElement register;
	
	public void Home()
	{
		Home.click();
	}
	public void Authentication()
	{
		authentic.click();
	}
	public void Mr()
	{
		mr.click();
	}
	public void Mrs()
	{
		mrs.click();
	}
	public void Fname(String fname)
	{
		cust_firstname.sendKeys(fname);
	}
	public void Lname(String lname)
	{
		cust_lastname.sendKeys(lname);
	}
	public void Password(String pass)
	{
		password.sendKeys(pass);
	}
	public void Day(String dy)
	{
		Actions a = new Actions(driver);
		a.moveToElement(day).click().sendKeys(dy).build().perform();
	}
	public void Month(String mth)
	{
		Actions a = new Actions(driver);
		a.moveToElement(month).click().sendKeys(mth).build().perform();
	}
	public void Year(String yr)
	{
		Actions a = new Actions(driver);
		a.moveToElement(year).click().sendKeys(yr).build().perform();
	}
	public void Sign()
	{
		sign_news.click();
	}
	public void Special()
	{
		special_offer.click();
	}
	public void Company(String comp)
	{
		company.sendKeys(comp);
	}
	public void Add(String add)
	{
		address.sendKeys(add);
	}
	public void Add2(String add2)
	{
		address2.sendKeys(add2);
	}
	public void City(String cty)
	{
		city.sendKeys(cty);
	}
	public void State(String st)
	{
		Actions a = new Actions(driver);
		a.moveToElement(state).click().sendKeys(st).build().perform();
	}
	public void Postcode(String pcode)
	{
		postcode.sendKeys(pcode);
	}
	public void Info(String info)
	{
		add_info.sendKeys(info);
	}
	public void Phone(String phon)
	{
		phone.sendKeys(phon);
	}
	public void Mobile(String mob)
	{
		mobile.sendKeys(mob);
	}
	public void Alias(String alad)
	{
		alias_add.sendKeys(alad);
	}
	public boolean ErrorMsg()
	{
		return error.isDisplayed();
	}
	public void Register()
	{
		register.click();
	}
}
