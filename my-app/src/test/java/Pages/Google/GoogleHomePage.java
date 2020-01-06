package Pages.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

		private static String PAGE_URL="https://www.google.com/";

		public GoogleHomePage(WebDriver driver) { 
			driver.get(PAGE_URL);
			PageFactory.initElements(driver, this); 
		} 

		@FindBy(how = How.XPATH, using = "//input[@name='q' and @type='text']") 
		WebElement searchTextBox; 
		
		public void searchFor(String text) { 
			searchTextBox.sendKeys(text);
			searchTextBox.submit(); 
		} 		
}
