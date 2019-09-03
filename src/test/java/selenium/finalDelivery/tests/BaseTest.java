package selenium.finalDelivery.tests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.finalDelivery.pages.HomePage;
import selenium.finalDelivery.utils.GetProperties;

public abstract class BaseTest {
		
		public WebDriver driver;
		public HomePage homePage;
		public GetProperties prop = new GetProperties();

		@Before
		public void SetUp() {

			//System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
			//driver = new ChromeDriver();	

			System.setProperty("webdriver.gecko.driver","src/resources/geckodriver");
			driver = new FirefoxDriver();		
			
			//driver.get("http://opencart.abstracta.us"); 
			driver.get(prop.getString("BASE_URL"));
			homePage = PageFactory.initElements(driver, HomePage.class);	
	    	}
			
		@After
		public void tearDown() {
			driver.quit();
		}
			
		public void focusElementScroll(String element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement actualElement = driver.findElement(By.id(element));		
			js.executeScript("arguments[0].scrollIntoView(true);", actualElement);
		}
		
		public void removeBanner() {
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			WebElement banner = driver.findElement(By.id("bitnami-close-banner-button"));	
			js.executeScript("arguments[0].click();", banner);
		}
		
		public void waitPage() {
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		
		public WebElement waitElement(String element) {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement webElement;
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			return webElement;		
		}
			
		public void waitElementWithOutReturn(String element) {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));		
		}

}
