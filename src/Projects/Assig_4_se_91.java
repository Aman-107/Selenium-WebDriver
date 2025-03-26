package Projects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assig_4_se_91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Click Here"))).click().build().perform();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.close();

		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
	}

}
