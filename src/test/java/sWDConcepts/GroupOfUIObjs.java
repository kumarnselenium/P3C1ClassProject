package sWDConcepts;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupOfUIObjs {

	@Test
	public void exForGroupOfUIObjs()
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		ChromeDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("https://www.redflagdeals.com/");
		
		//Brands Names
		List<WebElement> uiAllDealsBrands = oBrowser.findElements(By.className("block__title"));

		//Deals
		List<WebElement> uiAllDeals = oBrowser.findElements(By.xpath("//h4[@class='block__title']/a"));
		
		int iTotalNOfDeals = uiAllDeals.size();
		
		System.out.println(iTotalNOfDeals);
		
		for(int i=0; i<iTotalNOfDeals; i++)
		{
			System.out.println(uiAllDeals.get(i).getText());
		}
	}
		
		public void exForGroupOfUIObjsByTagNames()
		{
			//open Chrome browser
			System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
			ChromeDriver oBrowser = new ChromeDriver();
			
			oBrowser.get("https://www.redflagdeals.com/");
		
			//Links
			List<WebElement> uiAllLinks = oBrowser.findElements(By.tagName("a"));
			
			//Drop downs
			List<WebElement> uiAllDropDown = oBrowser.findElements(By.tagName("select"));
			
			//Buttons
			List<WebElement> uiAllButton = oBrowser.findElements(By.tagName("button"));
			
			//Text Boxes
			List<WebElement> uiAllTextBoxes = oBrowser.findElements(By.xpath("//input[@type='text']"));

			//Check Boxes
			List<WebElement> uiAllCheckBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
			
			//Radiobuttons
			List<WebElement> uiAllRadio = oBrowser.findElements(By.xpath("//input[@type='radio']"));
			//*[@id="js-promo-code"]
	}
	
}




