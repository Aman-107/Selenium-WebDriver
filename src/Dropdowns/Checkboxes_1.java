package Dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class Checkboxes_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Verifying whether the checkbox is selected or not
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		
		// getting the total count of the checkbox present on the page
		
		System.out.println(driver.findElements(By.cssSelector("input[type ='checkbox']")).size());
		
	}

}
