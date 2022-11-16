package sivaramtesting.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import sivaramtesting.SeleniumFrameworkDesign.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//sivaramtesting//resources//GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.get("https://rahulshettyacademy.com/client");
	}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
	
