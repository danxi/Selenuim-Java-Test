package Pages.Google;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleInputTool {

	private WebDriver driver;
	private static String PAGE_URL="https://www.google.com/inputtools/try/";

	public GoogleInputTool(WebDriver driver) { 
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this); 
	} 

	@FindBy(how = How.CLASS_NAME, using = "vk-btn") 
	private List<WebElement> keyboardButtons;
	
	@FindBy(how = How.ID, using = "demobox") 
	private WebElement textArea;
	
	private WebElement FindKeyboardButtonByLetter(String letter) {
		for(WebElement ele: keyboardButtons){
				if (ele.getText().equals(letter)  ) {
					return ele;
				}
		}
		
		return null;
	}
	
	public void TypeWithKeyboardInputTool(String inputText) {
		char[] chars = inputText.toCharArray();
		for(char c: chars)
		{
			WebElement btn = FindKeyboardButtonByLetter(String.valueOf(c));
			if (btn != null) {
				 Actions ac = new Actions(driver);
				 ac.click(btn).perform();;
			}	
		}
	}
	
	public String GetInputText() {
		return textArea.getAttribute("value");
	}
	
}
