package selenium.finalDelivery.tests;

import static org.junit.Assert.assertTrue;

import javax.naming.directory.SearchResult;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.finalDelivery.pages.AccountCustomerPage;
import selenium.finalDelivery.pages.LoginPage;
import selenium.finalDelivery.pages.SearchResults;
import selenium.finalDelivery.pages.WishListPage;

@RunWith(JUnitParamsRunner.class)
public class Test4 extends BaseTest{
	
	
	@Test
	@FileParameters("data/productsWishList.csv")
	public void addWishListTest(String product, String email, String password)  {	
		SearchResults search;
		homePage.searchProduct(product);
		search = homePage.clickSearchButton();
		String productExpected = search.getProductName();
		assertTrue("This Product is not correct: " + productExpected, productExpected.contains(product));
		search.addWishList();
		assertTrue("Alert: Do not have added Product to wish List. ", search.getAlertSuccessAddWishList());		
		LoginPage login;
		homePage.clickOptionAccount();
		login = homePage.clickOptionLogin();			
		AccountCustomerPage account;
		account = login.signUp(email,password);
		WishListPage list;
		list = search.optionWishList();		
		assertTrue(list.getSavedProduct(product));			
	
	}

}
