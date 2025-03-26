package Calenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Specific_date_month_year {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		String date = "10";
		String month = "7";
		String year = "2030";
		String[] userCal = {month,date,year};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.className("react-date-picker__inputGroup")).click(); // selecting calendar tab
		driver.findElement(By.cssSelector(".react-calendar__navigation")).click(); // selecting month year tab
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click(); //selecting year
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click(); // selecting user date
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		// selecting user month -> parsing string to integer -> Integer.parseInt(string)
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click(); //selecting date
		
		//System.out.println(driver.findElement(By.className("react-date-picker__inputGroup")).getText());
		List<WebElement> uiCal = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		// storing calendar info into list as they are splitted in three sub tags
		
		for(int i=0; i<uiCal.size(); i++) {
			//uiCal.get(i).getAttribute("value");
			System.out.println(uiCal.get(i).getAttribute("value")); // extracting value of calendar
			Assert.assertEquals(uiCal.get(i).getAttribute("value"), userCal[i]); // Asserting with user and picked calendar
		}
	}

}
