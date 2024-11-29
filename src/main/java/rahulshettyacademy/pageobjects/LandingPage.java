package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent
{
    WebDriver driver;
    
    public LandingPage(WebDriver driver)
    {
    	super(driver);
    	 this.driver =driver;
    	 PageFactory.initElements(driver, this);
    }
    
    //Locators
   // WebElement userEmail = driver.findElement(By.id("userEmail"));
    @FindBy(id = "userEmail")
        WebElement userEmail;
    
    @FindBy(id = "userPassword")
    WebElement userPassword;
    
    @FindBy(id = "login")
    WebElement submit;
    
    @FindBy(css ="[class*='flyInOut']")
    WebElement errorMessage;
// .ng-tns-c4-2.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error   
    
    
    //Action methods
    public ProductCatalogue loginApplication(String email,String password)
    {
    	
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(password);
    	submit.click();	
		return new ProductCatalogue(driver);
        
    }
    
    public WebElement getErrorMessage()
    {
    	WaitForWebElementToAppear(errorMessage);
    	errorMessage.getText();
    	return errorMessage;
    	
    }
                                                                         
    public void goTO()
    {
		driver.get("https://rahulshettyacademy.com/client/");
    }
    
    
     
    
}


