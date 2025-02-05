package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrdersPage;

public class AbstractComponent
{
      WebDriver driver ;
	
	public AbstractComponent(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	
     public CartPage goToCartPage()
	    {
	      cartHeader.click(); 
		  CartPage cartPage = new CartPage(driver);
          return cartPage;
	    }
     
     public OrdersPage goOrdersPage()
	    {
	      orderHeader.click(); 
		   OrdersPage ordersPage= new OrdersPage(driver);
       return ordersPage;
	    }  
     
     

	public void WaitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void WaitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	
	public void WaitForElementToDisAppear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.invisibilityOf(ele));
        
        
        
	}
	
	
	
	
	
	
}