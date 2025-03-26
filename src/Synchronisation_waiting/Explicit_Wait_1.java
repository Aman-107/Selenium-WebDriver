package Synchronisation_waiting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait_1 {
// It is applied at each targeted lines hence we have to implement for many elements 
// No performance issue	
// Cons : More Code 	
	
public static void main(String[] args) throws InterruptedException {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			
			String[] veggeis = {"Brocolli","Cauliflower","Cucumber","Beetroot"};
			Implicit_Wait_1 obj = new Implicit_Wait_1();
			obj.addItems(driver,veggeis);

			driver.findElement(By.className("cart-icon")).click();
			driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
			driver.findElement(By.cssSelector(".promoBtn")).click();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
			/* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			 wait.until(ExpectedConditions. == common syntax learn.
			 keep in mind we have to enter the locator not the webDriver i.e. only By.cssSelector("xyz");
			 manually implementing at the specific/targeted element wait time  */
			System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
				
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

}}
