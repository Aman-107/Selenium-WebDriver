package Projects;
// writing any project try to break down the full page driver into components driver


//import java.util.List;

//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class Assig_7_sec_104 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		
//		int rowData = 2;
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		
//		// Script to scroll to the table section of the table
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,350)");
//		
//		// Storing the values of columns and rows of the table
//		driver.findElement(By.id("product"));
//		List <WebElement> rows = driver.findElements(By.xpath("(//table[@id='product']/tbody)[1]/tr"));
//		List <WebElement> cols = driver.findElements(By.xpath("(//table[@id='product']/tbody)[1]/tr/th"));
//		
//		// printing the ros and columns value
//		System.out.println("Number of rows present in table are: " + rows.size());
//		System.out.println("Number of columns present in table are: " + cols.size());
//		
//		// Extracting the desired row data from the table 
//		for(int i=0; i<rows.size(); i++) {
//			if(i == rowData) {
//				System.out.println(rows.get(rowData).getText());
//				break;
//				}
//			}
//		
//		
//	}
//
//}

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig_7_sec_104 {

	public static void main(String[] args) {

// TODO Auto-generated method stub

	//	System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");
		WebElement table = driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
	}
}
