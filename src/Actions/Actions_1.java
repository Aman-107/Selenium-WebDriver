package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Actions_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		// Calling Action class object and driver is passed as argument since we have to perform operations on driver
		Actions action = new Actions(driver);
		action.moveToElement(move).build().perform();
		// .build().perform() -> is mandatory steps as it first build the arguments then performs it
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
		.doubleClick().build().perform();
		// for keys to enter in caps and selecting the passed arguments
		action.moveToElement(move).contextClick().build().perform(); // for right click
	}
  
}

/* Actions : 
    * Actions are user-initiated interactions with a digital interface, such as clicking buttons, selecting options, or entering
    * data. Actions can also refer to the user experience of taking a specific action across the web, such as using a cross-site
    * follow button
 -> How to MouseOver on object with Selenium?
 -> Performing Mouse and keyboard interactions with Selenium
 -> Context click on element
 -> Double click on element
 -> Drag and dropping the element
 
 * Frames :
 -> What are Frames?
 	* A frame in web design is a part of a web page or browser window that displays content independently from its container.
 	* Frames can be used to divide a browser window into multiple sub-windows, each displaying a different HTML document
 -> How to Identify Frames in application ?
 -> How to handle frames ?
 -> Best Practices when working with Frames application.   */