package Actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Window_handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> wind = driver.getWindowHandles();
		Iterator<String> it = wind.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		String user = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(user);
		
	}

}
