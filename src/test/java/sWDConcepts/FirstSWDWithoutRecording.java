package sWDConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSWDWithoutRecording {

	@Test
	public void eBaySearch() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver 2");
		ChromeDriver oBrowser = new ChromeDriver();
		//<Class Name> <obj Name> = new <Constructor/Class Name>();
		
		//launch www.ebay.com
		oBrowser.get("https://www.ebay.com/");
		
		//Enter "laptop" into search text-box 
		//a. Identify the Object + //b. perform the action
		oBrowser.findElement(By.id("gh-ac")).sendKeys("laptop");
		
		//Click on Search button
		//a. Identify the Object 
		WebElement uiSearchBtn = oBrowser.findElement(By.id("gh-btn"));
		uiSearchBtn.click();
		//oBrowser.findElement(By.id("gh-btn")).click();
		
		//Click on 'Advanced' link
		oBrowser.findElement(By.linkText("Advanced")).click();
		
		//Select 'Search including -  Title and description" checkbox
		/*if(oBrowser.findElement(By.id("LH_TitleDesc")).isSelected())
		{
			//do nothing
		}
		else
		{
			oBrowser.findElement(By.id("LH_TitleDesc")).click();
		}*/
		if(!oBrowser.findElement(By.id("LH_TitleDesc")).isSelected())
		{
			oBrowser.findElement(By.id("LH_TitleDesc")).click();
		}
		
		//Select "Location - Located In" radio button
		String sLocation = "Located In";
		
		if(sLocation.contains("Located"))
		{
			oBrowser.findElement(By.id("LH_Located")).click();
		}
		else if(sLocation.contains("From Preferred Locations"))
		{
			oBrowser.findElement(By.id("LH_PrefLocRadio")).click();
		}
		else if(sLocation.contains("Located In"))
		{
			oBrowser.findElement(By.id("LH_LocatedInRadio")).click();
		}
		
		//Select 'Canada' as country in Located In drop down
		//a. Identify the Object 
		WebElement uiCountry = oBrowser.findElement(By.id("_salicSelect"));
		//perform the action
		Select uiCountryDropDown = new Select(uiCountry);
		uiCountryDropDown.selectByVisibleText("Canada");
		Thread.sleep(3000);
		
		//Index
		uiCountryDropDown.selectByIndex(5);	//Albania
		Thread.sleep(3000);
		
		//Value
		uiCountryDropDown.selectByValue("16");	//Austria
	}
	
}







