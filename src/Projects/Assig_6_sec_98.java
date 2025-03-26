package Projects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assig_6_sec_98 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String text = driver.findElement(By.xpath("//label[@for='honda']")).getText().trim();
		driver.findElement(By.id("checkBoxOption3")).click();
		//System.out.println(text);
		
		WebElement st = driver.findElement(By.id("dropdown-class-example"));
		Select dp = new Select(st);
		dp.selectByVisibleText(text);
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		String []alertMsg = driver.switchTo().alert().getText().split(" ");
		String alertVerify = alertMsg[1].split(",")[0].trim();

		//System.out.println(alertVerify);

		if(alertVerify.equals(text)) {
			System.out.println("It's Present and the option is " + text);
		}
		else {
			System.out.println("In Alert text, passed keyword is not there");
		}
		driver.switchTo().alert().accept();
	}

}
