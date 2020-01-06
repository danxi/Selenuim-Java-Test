package GoogleTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Google.GoogleHomePage;
import Pages.Google.GoogleInputTool;
import Pages.Google.GoogleResultPage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		//use firefox driver
		System.setProperty("webdriver.gecko.driver",
				"C://Selenium//Selenium Environment Files//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait( 
	             10, TimeUnit.SECONDS); 
	}
		
	@Test 
	public void searchResultsAppears() {
		String text = "test";
		
		GoogleHomePage page = new GoogleHomePage(driver); 
		page.searchFor(text);
	  
		GoogleResultPage pageResult = new GoogleResultPage(driver);
		assert pageResult.ResultsContains(text);
	}
	
	@Test 
	public void searchResultsAppears_WithInputTool() {
		String text = "auto";
		
		GoogleInputTool pageInput = new GoogleInputTool(driver); 
		pageInput.TypeWithKeyboardInputTool(text);
		
		String realText = pageInput.GetInputText();
		assert realText.equals(text);
		
		GoogleHomePage page = new GoogleHomePage(driver); 
		page.searchFor(realText);
	  
		GoogleResultPage pageResult = new GoogleResultPage(driver);
		assert pageResult.ResultsContains(realText);		
	}
	
	@AfterClass
    public void TeardownTest() { 
        driver.quit(); 
    } 
}
