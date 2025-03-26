package StreamAPI_Lambda_expression;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Web_table_sorting_stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// select the column 1
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// store the column value in list
		List<WebElement> uiElement = driver.findElements(By.xpath("//tr/td[1]"));

		// sort the list and store it in another list
		List<String> sortedVeg = uiElement.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> scriptVeg = sortedVeg.stream().sorted().collect(Collectors.toList());
		// compare both the list
		Assert.assertTrue(scriptVeg.equals(sortedVeg));
	}

}
