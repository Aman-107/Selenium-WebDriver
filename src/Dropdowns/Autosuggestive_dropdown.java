package Dropdowns;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.List;

public class Autosuggestive_dropdown {
    public static void main(String[] args) throws InterruptedException {
    	
    	EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Enter partial text to trigger suggestions
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		List<WebElement> option = driver.findElements(By.className("ui-menu-item"));
		
		// Iterate through options and select "India"
		for (WebElement it : option) {
			if (it.getText().equalsIgnoreCase("India")) {
				it.click();
				break;
			}
		}

		// Allow some time to ensure the selection is updated
		Thread.sleep(2000);

		// Fetch the selected value from the input field
		String selectedValue = driver.findElement(By.id("autosuggest")).getAttribute("value");
		// always use .getAttribute("value") whenever there is preference selection.
	/*   The issue lies in the way you are attempting to retrieve the text from the element after selecting a value. 
		  The getText() method doesn't always return the value of an input field. Instead, for input fields, you need 
		  to use the getAttribute("value") method to retrieve the currently entered text or selected value.   */
		System.out.println("Selected Value: " + selectedValue);

		// Quit the browser
		driver.quit();
    }
}
