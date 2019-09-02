package selenium.finalDelivery.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import selenium.finalDelivery.pages.SearchResults;
import selenium.finalDelivery.pages.ShoppingCartPage;

@RunWith(JUnitParamsRunner.class)
public class Test5 extends BaseTest {

	@Test
	@FileParameters("data/productRemove.csv")
	public void removeProductTest(String product) throws Exception {
		SearchResults search;
		homePage.searchProduct(product);
		search = homePage.clickSearchButton();
		String resultExpected = search.getProductName();
		assertTrue("This Product is not correct: " + product, resultExpected.contains(product));
		search.addCartShopping();
		assertTrue("Alert: Do not have added Product. ", search.getAlertSuccessAddCart());
		ShoppingCartPage cart;
		cart = search.optionShoppingCart();
		cart.removeProductShoppingCart(product);
		waitElementWithOutReturn("//p[contains(.,'Your shopping cart is empty!')]");
		assertTrue("The Shopping Cart is not empty: ", cart.checkEmptyShoppingCart().contains("Your shopping cart is empty!"));
	}
	
}
