package sivaramtesting.Tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		String productName= "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("naidu.sivaram007@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Akhil@9963");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		////body//app-root//select[1]
		Select month = new Select(driver.findElement(By.xpath("//select[@class='input ddl']")));
	    month.selectByVisibleText("12");
	    Select day = new Select(driver.findElement(By.xpath("//select[@class='input ddl'][2]")));
	    day.selectByVisibleText("12");
	    driver.findElement(By.cssSelector("input[class='input txt']")).sendKeys("786");
	    //driver.findElement(By.xpath("//div[@class='row']/input[1]")).sendKeys("SivaRam");
	  //input[@placeholder='Select Country']
	    Actions a=new Actions(driver);
	    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	    driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
	    String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
	    Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
//        List<WebElement> options= driver.findElements(By.cssSelector("[placeholder='Select Country']"));
//		
//		for (WebElement option : options)
//		{
//			if(option.getText().equalsIgnoreCase("India"))
//			{
//			option.click();
//			break;
//		}

	}

}

