package sivaramtesting.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	public productCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		productCatalogue productCatalogue= new productCatalogue(driver);
		return productCatalogue;
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");


		 

	}

}
