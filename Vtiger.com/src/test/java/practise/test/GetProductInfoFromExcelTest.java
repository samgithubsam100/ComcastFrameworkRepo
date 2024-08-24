package practise.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class GetProductInfoFromExcelTest {
	
	
	
	@Test(dataProvider = "getdata")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://amazon.in/");
		
		//search product
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(brandName);
		driver.findElement(By.xpath("//div[@class=\"nav-search-submit nav-sprite\"]")).click();
		//capture product info
		driver.findElement(By.xpath("//img[contains(@alt, '"+productName+"')]/ancestor::div[@class='puisg-row']/descendant::span[@class='a-price-whole']")).getText();
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable {
		ExcelUtility eLib= new ExcelUtility();
		int rowCount = eLib.getRowcount("product");
		Object[][] objArr= new Object[rowCount][2];

		
			for(int i=0; i<rowCount; i++) {
			
		objArr[i][0]=eLib.getDataFromExcel("product", i+1, 0);
		objArr[i][1]=eLib.getDataFromExcel("product", i+1, 1);
		
			}
		return objArr;


	}

}
