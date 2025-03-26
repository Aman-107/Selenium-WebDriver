package StreamAPI_Lambda_expression;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Custom_selenium_methos_streams_mapper {

	// to print the price of "potato"
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// select the column 1 veggies
		List<WebElement> uiElement = driver.findElements(By.xpath("//tr/td[1]"));
	
		// filtering out the "Potato" WebElement and passing it to vegPrice argument
		List<String> price = uiElement.stream().filter(s->s.getText().contains("Potato")).map(s->vegPrice(s))
							 .collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
	}

	private static String vegPrice(WebElement s) {
		// TODO Auto-generated method stub
		s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		// directly returned code i.e. used the sibling concept
		// Note : here only half of locator is being passed bcoz we are accepting the WebElement from 's' (splitting like frame)
		// and then doing operation on that element only
		return (s.findElement(By.xpath("following-sibling::td[1]")).getText());
	}

}
