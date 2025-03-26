package Projects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Functional_testing_sec8 {
	// Automate Big Basket by yourself.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Select cucumber,brocolli Add to cart for cucumber and brocolli Open the cart
		 * page */

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] veggeis = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot" };
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> vegetables = Arrays.asList(veggeis);
		// System.out.println(vegetables);
		int j = 0; // for breaking of the loop

		for (int i = 0; i < items.size(); i++) {
			String name = items.get(i).getText(); // get is used in when many elements are there with same tags like in 
			// spice jett, hence we use get to exactly match at the ith position, keep in mind that both text and add to 
			// cart should have same number of elements.

			String[] name2 = name.split("-");
			String actualName = name2[0].trim();
//			String actualName = name2[0];
			// System.out.println(actualName); // whitespace there thatswhy code was not working

			if (vegetables.contains(actualName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// important line here we have first selected the whole parent then child(to be
				// precise for click)
				j++;
				if (j == veggeis.length) {
					break;
				}
			}
		}
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();

	}

}
