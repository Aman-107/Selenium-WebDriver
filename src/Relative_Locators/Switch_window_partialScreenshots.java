package Relative_Locators;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Switch_window_partialScreenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//Switching Window

		driver.switchTo().newWindow(WindowType.WINDOW); // switching to new window
	//	driver.switchTo().newWindow(WindowType.TAB);    // switching to new tab 
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();

		String parentWindowId = it.next();
		String childWindow =it.next();
		driver.switchTo().window(childWindow);
		
		// Extracting the first course title of the page
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
		.get(1).getText();
		
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);

		//Screenshot
		File file=name.getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(file, new File("logo.png"));
// here ss will be of 'name' edit box bcoz we are using name webelement as driver and will stored at working project directory
// i.e. refresh current project i.e. Selenium_WebDriver and at last it will be saved		
		
		//driver.quit();
		
		//GEt Height & Width -> WebElement.getRect().getDimension().getHeight/Width() -> Syntax
		System.out.println(name.getRect().getDimension().getHeight()); // height of the name edit box
		System.out.println(name.getRect().getDimension().getWidth()); // width of the name edit box
		
	}

}
