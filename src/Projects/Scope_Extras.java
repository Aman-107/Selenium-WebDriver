package Projects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scope_Extras {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Totals links present: " + driver.findElements(By.tagName("a")).size());
		// .size() is not available in selenium rather .getSize() is available.what should i do.
		// i use driver.findelement() rather than driver.findelements();
		
		// Limiting webDriver scope
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println("Links present in footer are: " + footer.findElements(By.tagName("a")).size());
		
		// Limiting sub driver scopes
		WebElement subFooter = footer.findElement(By.xpath("(//table/tbody/tr/td/ul)[1]"));
		System.out.println("Links in 1 section are: " + subFooter.findElements(By.tagName("a")).size());
		
		// Opening all the sub footer section links in new window by ctrl + left click/enter
		for(int i=1; i<subFooter.findElements(By.tagName("a")).size(); i++) {
			String linkTab =Keys.chord(Keys.CONTROL,Keys.ENTER);
			subFooter.findElements(By.tagName("a")).get(i).sendKeys(linkTab);
			Thread.sleep(2000);
		}
		
		// handling each opened window and getting title of it
		// here driver came in picture since now we going to work on windows which will work on full web page driver only
		Set<String> wind = driver.getWindowHandles(); 
		Iterator<String> it = wind.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			//driver.close();
		}
	}

}
