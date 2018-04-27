package sWDConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExForXPATH {

	@Test
	public void xPATHEx()
	{
		
		String sCompanySymbol = "AGLE";
		
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		ChromeDriver oBrowser = new ChromeDriver();
		//<Class Name> <obj Name> = new <Constructor/Class Name>();
		
		//launch https://www.nasdaq.com/
		oBrowser.get("https://www.nasdaq.com/");
		
		//Stock Activity Table -click on AGLE & find out Share Volume
		//AGLE ==> //a[contains(.,'AGLE')]
		//AGLE => Parent ==> //a[contains(.,'AGLE')]/ancestor::td
		//AGLE => Parent ==> 175257//a[contains(.,'AGLE')]/ancestor::td/following-sibling::td[3]
		//String sText = oBrowser.findElement(By.xpath("//a[contains(.,'AGLE')]/ancestor::td/following-sibling::td[3]")).getText();
		String sText = oBrowser.findElement(By.xpath("//a[contains(.,'TLGT')]/ancestor::td/following-sibling::td[3]")).getText();
		// in case if we have a text-box ==> oBrowser.findElement(By.xpath("//a[contains(.,'TLGT')]/ancestor::td/following-sibling::td[3]/input")).sendKeys("3");
		System.out.println(sText);
	}
	
}
