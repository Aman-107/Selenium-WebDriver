 package Relative_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Friendly_Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// Above Relative locator
		WebElement nameEditbox = driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		
		// using relative locators for click -> Below
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		
		// using Left relative 
		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		// using right relative
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
			
	}

}

/*
 * above() : Element located above with respect to the specified element
 * Below() : Element located below with respect to the specified element
 * toLeftOf() : Element located to the left of specified element.
 * toRightOf() : Element located to the right of the specified element.
 * 
 * Here relative locator has to present other than the webelement locator i.e they can't be present in the tagname.
 
 Syntax : 
 	driver.findElement(withTagName("XX").above(WebElement));
 
 Note : we have to manually 'import static org.openqa.selenium.support.locators.RelativeLocator.*;' since it's a static package
      Relative locator doesn't accept the 'flex' -> it will be present at the end of the tag 
*/