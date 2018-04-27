package automationConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ExcelReadByJXL;
import utilities.ExcelReadByPOI;

public class EMICalculator {

	public void emiCalc() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		
		oBrowser.findElement(By.id("Loan_Amount")).clear();
		oBrowser.findElement(By.id("Loan_Amount")).sendKeys("50000");
		
		oBrowser.findElement(By.name("rate")).clear();
		oBrowser.findElement(By.name("rate")).sendKeys("5");
		
		oBrowser.findElement(By.name("months")).clear();
		oBrowser.findElement(By.name("months")).sendKeys("60");
		
		oBrowser.findElement(By.xpath("//input[@value='Calculate']")).click();
		
	}
	
	public void emiCalcParameterization() throws InterruptedException
	{
		ExcelReadByJXL oExcel = new ExcelReadByJXL("/Users/narkandukuri/Documents/Personal/Sel/P3C1/Deal4Loan.xls", "emiCalc");
		
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		
		oBrowser.findElement(By.id("Loan_Amount")).clear();
		oBrowser.findElement(By.id("Loan_Amount")).sendKeys(oExcel.getCellData("LoanAmount", 1));
		
		oBrowser.findElement(By.name("rate")).clear();
		oBrowser.findElement(By.name("rate")).sendKeys(oExcel.getCellData("IntRate", 1));
		
		oBrowser.findElement(By.name("months")).clear();
		oBrowser.findElement(By.name("months")).sendKeys(oExcel.getCellData("Tenure", 1));
		
		oBrowser.findElement(By.xpath("//input[@value='Calculate']")).click();
		
	}
	
	@Test
	public void emiCalcParameterizationDataDriven() throws InterruptedException
	{
		//ExcelReadByJXL oExcel = new ExcelReadByJXL("/Users/narkandukuri/Documents/Personal/Sel/P3C1/Deal4Loan.xls", "emiCalc");
		ExcelReadByPOI oExcel = new ExcelReadByPOI("/Users/narkandukuri/Documents/Personal/Sel/P3C1/Deal4Loan.xls", "emiCalc");
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		
		for(int i=1; i<oExcel.rowCount(); i++)
		{
			oBrowser.findElement(By.id("Loan_Amount")).clear();
			oBrowser.findElement(By.id("Loan_Amount")).sendKeys(oExcel.getCellData("LoanAmount", i));
			
			oBrowser.findElement(By.name("rate")).clear();
			oBrowser.findElement(By.name("rate")).sendKeys(oExcel.getCellData("IntRate", i));
			
			oBrowser.findElement(By.name("months")).clear();
			oBrowser.findElement(By.name("months")).sendKeys(oExcel.getCellData("Tenure", i));
			
			oBrowser.findElement(By.xpath("//input[@value='Calculate']")).click();
			
			Thread.sleep(3000);
		}
		
	}
}
