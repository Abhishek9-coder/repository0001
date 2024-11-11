package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent
{
    WebDriver driver;
    
    public CartPage(WebDriver driver)
    {
    	super(driver);
    	 this.driver =driver;
    	 PageFactory.initElements(driver, this);
    }
    
    //Locators
  
     @FindBy(css =".cartSection h3" )
        List<WebElement>  cartProducts;
    
	   // driver.findElement(By.cssSelector(".totalRow button")).click();
     @FindBy(css=".totalRow button")
      WebElement checkOutEle;
    
    
    @FindBy(css = ".mb-3")
     List <WebElement> products;
    //.ng-animating
    
    @FindBy(css =".ng-animating")
    WebElement spinner;
    
    //Actions Methods
    
    public boolean VerifyProductDisplay(String productName)
    {
    	
	    boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
         return match;
    	
    }
    
    public CheckoutPage goToCheckout()
    {
    	checkOutEle.click();
        return new CheckoutPage(driver);
    	
    }
   
    
   

}


