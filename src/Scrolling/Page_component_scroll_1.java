package Scrolling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Page_component_scroll_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		// Web Page Scrolling
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		// Scrolling within specific table/element
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");  
		// to scroll down -> .scrollTop = value
		// to scroll right -> .scrollLeft = value
		
		List<WebElement> amount = driver.findElements(By.xpath("//fieldset/div/table/tbody/tr/td[4]"));
		int sum =0;
		
		for(int i=0; i<amount.size(); i++) {
			sum += Integer.parseInt(amount.get(i).getText());
		}
		System.out.println(sum);
		
		int uiAmt = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(": ")[1]);
//		System.out.println(uiAmt);
		
		Assert.assertEquals(sum, uiAmt);
		
		
		// Passing the sendKeys value using JavascriptExecutor
		// Locate the input field
        WebElement inputField = driver.findElement(By.id("name")); // Replace with actual ID

        // Use JavaScriptExecutor to set value
        js.executeScript("arguments[0].value='Shadow';", inputField);

        // Verify the entered value
        String enteredValue = (String) js.executeScript("return arguments[0].value;", inputField);
        System.out.println("Entered Value: " + enteredValue);
		//driver.findElement(By.id("name")).sendKeys("Shadow");
	}

}
