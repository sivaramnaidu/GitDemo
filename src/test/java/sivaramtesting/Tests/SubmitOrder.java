package sivaramtesting.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sivaramtesting.SeleniumFrameworkDesign.pageobjects.CartPage;
import sivaramtesting.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import sivaramtesting.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import sivaramtesting.SeleniumFrameworkDesign.pageobjects.LandingPage;
import sivaramtesting.SeleniumFrameworkDesign.pageobjects.productCatalogue;
import sivaramtesting.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		
		String productName= "ZARA COAT 3";
		
		productCatalogue productCatalogue=landingPage.loginApplication("naidu.sivaram007@gmail.com", "Akhil@9963");
		//productCatalogue productCatalogue= new productCatalogue(driver);
//		List<WebElement>products=productCatalogue.getProductsList();
//		
//		productCatalogue.addProductToCart(productName);
//		CartPage cartPage=productCatalogue.goToCartPage();
//		//productCatalogue.goToCartPage();
//		
//		Boolean match=cartPage.VerifyProductDisplay(productName);
//	    Assert.assertTrue(match);
//	    CheckoutPage checkoutPage=cartPage.goToCheckout();
//	    checkoutPage.selectCountry("India");
//	    ConfirmationPage confirmationPage= checkoutPage.submitOrder();
//	    
//	    
//	    String confirmMessage=confirmationPage.getConfirmationMessage();
//	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	    


	}

}

