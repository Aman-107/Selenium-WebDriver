package Dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Static_Dropdowns_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticdropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		// storing in staticdropdown of WebElement i.e. location of dropdown
		Select dropdown = new Select(staticdropdown); // Select class and dropdown is object.
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED"); // here value will be from inspect element.
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		System.out.println(staticdropdown.getText()); // this will give all the Options present in it.
		System.out.println(dropdown.getFirstSelectedOption().getText()); // this will give the current element selected.
		
		
		// Dropdown in which add on has to be done
		driver.findElement(By.className("paxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// selecting 5 adults
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		// Dynammic Dropdown -> based on user preference they are visible i.e. when user select dropdown then only dropdown 
		// values appear
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='VNS']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click(); // handling with indexes
		/* here whole xpath's indexing has been selected for 2nd
		as in dynammic dropdown when user comes on the second dropdowndown then on same there's a two value present for the same
		xpath hence we select the 2 as it was our need.      */
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		// using the parent child relationship -> parent xpath space child xpath -> scope of search limited to parent xpath only.

	}

}
