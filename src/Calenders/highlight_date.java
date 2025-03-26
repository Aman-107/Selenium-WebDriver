package Calenders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class highlight_date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// selecting current date
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		
		// Verifying whether the returned calendar is disabled or not i.e. element on UI is disabled or not.
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It's Enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}

}



/* 
In latest selenium language " .getAttribute() " has been changed for some websites (mostly which uses Angular Framework) hecnce now we 
have to use the " .getDomAttribute() " to the attribute value. 


*/