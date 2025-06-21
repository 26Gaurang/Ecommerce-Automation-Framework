package testClasses;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import RegisterJourneyPages.AccountInfo;
import RegisterJourneyPages.RegisterHome;

public class RegisterUser extends BaseTest {



	@Test
	public void LoginFlow() {

		RegisterHome l = new RegisterHome(driver);
		l.SignUpFlow("Dhonibhai","Dhoni2443@gmail.com");

		AccountInfo ai = new AccountInfo(driver);
		ai.SignUpPage("abc@123");
		ai.DateOfBirth("12","December","2000");
		ai.AddressDetails("Mahi", "Thala", "Canada");
		ai.SignInSuccess();

	}


}
