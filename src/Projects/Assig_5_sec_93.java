package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assig_5_sec_93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		
		// switch to header frames.
		driver.switchTo().frame("frame-top");
		
		// switch to middle frame
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.tagName("div")).getText());
		
		// switch to default frame webpage
		driver.switchTo().defaultContent();
	}

}
