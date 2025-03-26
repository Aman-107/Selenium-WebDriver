package Synchronisation_waiting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Implicit_Wait_1 {
// It is applied at globally hence we have to implement only once 
// more readable i.e. optimised	
	
	public static void main(String[] args) throws InterruptedException {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // both are same below one is used in selenium 
//	of version < 4 and above one is latest selenium feature 		
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			
			String[] veggeis = {"Brocolli","Cauliflower","Cucumber","Beetroot"};
			Implicit_Wait_1 obj = new Implicit_Wait_1();
			obj.addItems(driver,veggeis);

			driver.findElement(By.className("cart-icon")).click();
			driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
			driver.findElement(By.cssSelector(".promoBtn")).click();
			System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
			/* here we are unable to fetch the promo info value because it's taking some time and we have disabled the implicit 
			 wait + don't have written the thread.sleep, hence we will use implicit wait bcoz for every block of statement it
			 will wait for 5 seconds but if the code executed before given time i.e. 5 then it will proceed further block 
			 will not stop till 5 second.
			
			 Cons : In performance testing : Suppose a page have to load before 3 sec but due to latency issue it's loading
			 time has increased to 5 sec, since we have implemented the implicit wait time of 5 second therefore it will not
			 catch the bug and it went un-noticed.  */		
		}

public void addItems(WebDriver driver, String[] veggeis) {
	List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
	List<String> vegetables = Arrays.asList(veggeis);
	
	int j = 0;  // for breaking of the loop
	
	for(int i=0; i<items.size(); i++) {
		String name = items.get(i).getText(); // get is used in when many elements are there with same tags like in spice 
	//	jett, hence we use get to exactly match at the ith position, keep in mind that both text and add to cart should have
	//	same number of elements.

		String[] name2 = name.split("-");
		String actualName = name2[0].trim();
//		String actualName = name2[0];
	//	System.out.println(actualName); // whitespace there thatswhy code was not working
		
		
		if(vegetables.contains(actualName)) {
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();  
			// important line here we have first selected the whole parent then child(to be precise for click)
			j++;
			if(j==veggeis.length) {
				break;
			}
		}
	}
}

}