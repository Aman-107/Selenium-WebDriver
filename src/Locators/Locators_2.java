package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class Locators_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String name = "Dark Shadow";
        Locators_2 obj = new Locators_2();
		String password = obj.getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[contains(@name,'inputPassword')]")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()=' Remember my username']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit signInBtn')]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	}

public String getPassword(WebDriver driver) throws InterruptedException {
	
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	
  String temppass = driver.findElement(By.cssSelector("form p")).getText();		
  String []pass = temppass.split("'");
  for(String it : pass) {
		System.out.println(it);
	}
	String bypass = pass[1];
	return bypass;
}
}
