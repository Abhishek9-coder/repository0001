package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends  BaseTest 

{   
	
	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation()
	{
		landingPage.loginApplication("rahul@gmail.com", "45545455weiwwo");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
		
		
	}
	
	@Test
	public void ProdctErrorValidation() throws IOException, InterruptedException
	{
		
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("abhishekmone.12@gmail.com", "Auto@123!");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);    
		CartPage cartPage =productCatalogue.goToCartPage();        
	    boolean match = cartPage.VerifyProductDisplay("ZARA COAT 1");
	    Assert.assertFalse(match);	
	    
	
	}       
	
	
} 


