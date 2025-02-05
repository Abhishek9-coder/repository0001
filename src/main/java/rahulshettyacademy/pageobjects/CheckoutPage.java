package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent
{
    WebDriver driver;
    
    public CheckoutPage(WebDriver driver)
    {
    	super(driver);
    	 this.driver =driver;
    	 PageFactory.initElements(driver, this);
    }
    
    //Locators
    
    @FindBy(css ="[placeholder ='Select Country']")
    WebElement country;
    
    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    WebElement SelectCountry;
    
    @FindBy(css = ".action__submit")
    WebElement submit;
    
    By results =  By.cssSelector(".ta-results");
   
   
         
    //Actions Methods
    
    public void SelectCountry(String countryName)
    {
    	

    	Actions a = new Actions(driver);
	    a.sendKeys(country, countryName).build().perform();
	    WaitForElementToAppear(results);
	    SelectCountry.click();
    	
    	
    }
    
    public ConfirmationPage submitOrder()
    {
    	submit.click();
        return new ConfirmationPage(driver);
    }
   
    
   

}


