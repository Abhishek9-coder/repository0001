package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException
	{
		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTO();
		ProductCatalogue productCatalogue=landingPage.loginApplication("abhishekmone.12@gmail.com", "Auto@123!");
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
	   driver.close();
	}

}
