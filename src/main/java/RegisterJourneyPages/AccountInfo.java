package RegisterJourneyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComp.AbstractComponents;
//import org.testng.Assert;

public class AccountInfo extends AbstractComponents{

@FindBy(xpath = "//input[@value='Mr']")
WebElement Salutation;

@FindBy(xpath = "//input[@data-qa='name']")
WebElement Name;

@FindBy(xpath = "//input[@data-qa='email']")
WebElement Email;

@FindBy(xpath = "//input[@data-qa='password']")
WebElement Password;

@FindBy(xpath = "//select[@data-qa='days']")
WebElement DaysDOB;

@FindBy(xpath = "//select[@data-qa='months']")
WebElement MonthsDOB;

@FindBy(xpath = "//select[@data-qa='years']")
WebElement YearsDOB;

@FindBy(xpath = "//input[@id='optin']")
WebElement SpecOffers;

@FindBy(xpath = "//input[@data-qa='first_name']")
WebElement FirstName;

@FindBy(xpath = "//input[@data-qa='last_name']")
WebElement LastName;

@FindBy(xpath = "//input[@data-qa='address']")
WebElement Address;


@FindBy(xpath = "//select[@data-qa='country']")
WebElement Country;

@FindBy(xpath = "//input[@data-qa='state']")
WebElement State;

@FindBy(xpath = "//input[@data-qa='city']")
WebElement City;

@FindBy(xpath = "//input[@data-qa='zipcode']")
WebElement ZipCode;

@FindBy(xpath = "//input[@data-qa='mobile_number']")
WebElement Mobile;

@FindBy(xpath = "//button[@data-qa='create-account']")
WebElement SignInButton;

@FindBy(xpath = "//h2[@data-qa='account-created']")
WebElement SignInVerify;

@FindBy(xpath = "//a[@data-qa='continue-button']")
WebElement SignInContinue;


	public AccountInfo(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void SignUpPage(String Pswd) {

		Salutation.click();
		Password.sendKeys(Pswd);

	}

	public void DateOfBirth(String Day, String Month, String Year) {

		Select sd = new Select(DaysDOB);
		sd.selectByVisibleText(Day);

		Select sm = new Select(MonthsDOB);
		sm.selectByContainsVisibleText(Month);

		Select sy = new Select(YearsDOB);
		sy.selectByVisibleText(Year);
		
		CaptureScreen("2.Register Details");

	}

	public void AddressDetails(String fname, String lname, String country) {

		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);

		Address.sendKeys("Wankhede");

		Select sc = new Select(Country);
		sc.selectByVisibleText(country);
		
		CaptureScreen("3.Register Details");

		State.sendKeys("Maharashta");
		City.sendKeys("Mumbai");
		ZipCode.sendKeys("400098");
		Mobile.sendKeys("1234567890");

		CaptureScreen("4.Register Details");
		
		SignInButton.click();

	}

	public void SignInSuccess() {

		//Assert.assertEquals(SignInVerify,"Account Created!");
		SignInContinue.click();

	}


}
