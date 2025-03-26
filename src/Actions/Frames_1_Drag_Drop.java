package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Frames_1_Drag_Drop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//Switching from current webpage to frames 
		//search for iframes tag and write the whole path for iframe to select
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement desti = driver.findElement(By.id("droppable"));
		//creating the source and destination path
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source,desti).build().perform();
		//using action dragging and dropping the content present on webpage.
		
		driver.switchTo().defaultContent();
		//switch back to webpage from frames.
	}
}


/* Frames can be implemented in 3 ways -> 
1: .frame(int index) -> suppose there are n frames in page and we want to select nth frame then in int index will as 'n-1'.
 2: .frame(String nameOrId) -> in these we have to pass the 'name' or 'Id' value of the iframe.
 3: .frame(WebElement frameElement) -> in these we have to pass the iframe general path or locator.
*/