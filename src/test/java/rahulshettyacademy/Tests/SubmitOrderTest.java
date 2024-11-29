package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.HashMap;
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
	public void submitOrder(HashMap <String , String > input) throws IOException, InterruptedException
	{		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
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
		HashMap <String, String> map = new HashMap <String, String>();
		map.put("email","abhishekmone.12@gmail.com");
		map.put("password","Auto@123!");
		map.put("productName", "ZARA COAT 3");
		
		HashMap <String, String> map1 = new HashMap <String, String>();
		map1.put("email","t4163200@gmail.com");
		map1.put("password","Auto@123!");
		map1.put("productName", "ADIDAS ORIGINAL");
		
		
		return new Object [][] {{map},{map1}};
		
	}
	

	

	 
}