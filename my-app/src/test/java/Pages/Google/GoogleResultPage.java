package Pages.Google;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class GoogleResultPage {

	public GoogleResultPage(WebDriver driver) { 
		PageFactory.initElements(driver, this); 
	} 

	@FindBy(how = How.CLASS_NAME, using = "LC20lb")
	private List<WebElement> searchResults;
	
	private List<String> GetResults(){
		List<String> results = new ArrayList<String>();
		
		for(WebElement e: searchResults) {
			results.add(e.getText());
		}
		return results;
	}
	
	//simply check if any link has the searching keyword
	public boolean ResultsContains(String text){
		List<String> results =  GetResults();
		
		if (results.size() > 0 ) {
			for (String s: results) {
				if (s.toLowerCase().contains(text.toLowerCase())) return true;
			}
		}
		
		return false;	
	}
		
}