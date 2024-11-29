package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends  BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData" , groups = {"Purchase"})
	public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException
	{
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(email, password);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);    
		CartPage cartPage =productCatalogue.goToCartPage();        
	    boolean match = cartPage.VerifyProductDisplay(productName);
	    Assert.assertTrue(match);	
	    CheckoutPage  checkoutPage = cartPage.goToCheckout();
	    checkoutPage.SelectCountry("india");
	    ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	    String confirmationMessage = confirmationPage.getConfirmationMessage();
	    Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
	
	
	}    
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("abhishekmone.12@gmail.com", "Auto@123!");
		OrdersPage ordersPage =productCatalogue.goOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrdersDisplay(productName));
		
	}
	 
	@DataProvider
	public Object[][] getData()
	{
		
		return new Object [][] {{"abhishekmone.12@gmail.com","Auto@123!", "ZARA COAT 3"},{"t4163200@gmail.com", "Auto@123!","ADIDAS ORIGINAL"}};
		
	}
	

	

	 
}