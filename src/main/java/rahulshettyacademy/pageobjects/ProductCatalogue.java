package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{
    WebDriver driver;
    
    public ProductCatalogue(WebDriver driver)
    {
    	super(driver);
    	 this.driver =driver;
    	 PageFactory.initElements(driver, this);
    }
    
    //Locators
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    @FindBy(css = ".mb-3")
     List <WebElement> products;
    //.ng-animating
    
    @FindBy(css =".ng-animating")
    WebElement spinner;
    
    By productBy = By.cssSelector(".mb-3");
    
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    //Action methods
   
    By toastMessage = By.cssSelector("#toast-container");
    
    public List<WebElement> getProductList()
    {
    	WaitForElementToAppear(productBy);
    	return products;
    	
    }
          
   
    
    public WebElement getProductName(String productName)
    {
    	
    	WebElement prod = getProductList().stream().filter(product -> 
	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    	return prod;
    }
    
    public void addProductToCart(String productName) throws InterruptedException
    {
    	  
	    WebElement prod = getProductName(productName);
	    prod.findElement(addToCart).click();   
        WaitForElementToAppear(toastMessage);
        WaitForElementToDisAppear(spinner);
    }
    
}


