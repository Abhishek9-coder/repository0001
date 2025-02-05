package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent
{
    WebDriver driver;
    
    public OrdersPage(WebDriver driver)
    {
    	super(driver);
    	 this.driver =driver;
    	 PageFactory.initElements(driver, this);
    }
    
    //Locators
  
       
     @FindBy(css ="tr td:nth-child(3)" )
     List<WebElement>  productNames;
    
	 @FindBy(css = ".mb-3")
     List <WebElement> products;
    //.ng-animating
    
    
    //Actions Methods
    
    public boolean VerifyOrdersDisplay(String productName)
    {
    	
	    boolean match = productNames.stream().anyMatch(Product ->Product.getText().equalsIgnoreCase(productName));
        return match;
    	
    }

}


