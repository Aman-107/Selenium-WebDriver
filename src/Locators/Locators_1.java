package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Locators_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// this is used to wait till the objects are visible on the page
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Shadow");
		driver.findElement(By.name("inputPassword")).sendKeys("Charpahiye");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Aman Kumar Maurya");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("baahubali@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("shadow107@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");
		Thread.sleep(1000); /* when the page is in changing state i.e. URL doesn't changes but the layout of the page changes and
		selenium tries to fill the details in no seconds hence we can encouter an error in transition pages to avoid these we use
		the Thread.sleep(Duration_in_millisecods) to wait for that timeperiod and this error is called element interceptor */
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Shadow");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[contains(@value,'rmbr')]")).click();
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
		
		
		
		
		
		
		
//      String temppass = driver.findElement(By.cssSelector("form p")).getText();		
//		String []pass = temppass.split("'");
//		for(String it : pass) {
//			System.out.println(it);
//		}
//		
//		String bypass = pass[1];
		
	}

}
