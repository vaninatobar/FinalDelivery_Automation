package selenium.finalDelivery.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.finalDelivery.pages.AccountCustomerPage;
import selenium.finalDelivery.pages.CustomerAccountLogout;
import selenium.finalDelivery.pages.LoginPage;

@RunWith(JUnitParamsRunner.class)
public class Test2 extends BaseTest{

		@Test
		@FileParameters("data/accounts.csv")
		public void loginTest(String email, String password) {
			LoginPage login;
			homePage.clickOptionAccount();
			login = homePage.clickOptionLogin();
			AccountCustomerPage account;
			account = login.signUp(email, password);
			homePage.clickOptionAccount();
			CustomerAccountLogout logout;
			logout = account.clickLogout();
			

		}
	
}
