package StreamAPI_Lambda_expression;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pagination_Filters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
		
		
		List<String> vegPrice;
		
		do {
			List<WebElement> vegName = driver.findElements(By.xpath("//tr/td[1]"));
		vegPrice = vegName.stream().filter(s->s.getText().contains("Cherry")).map(s->vegPrice(s))
                .collect(Collectors.toList());
		vegPrice.forEach(s->System.out.println(s));
		
		if(vegPrice.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(vegPrice.size() < 1);
	}

	private static String vegPrice(WebElement s) {
		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		// TODO Auto-generated method stub
		return price;
	}

}

/* Filters checking

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filter {

public static void main(String[] args) {
// TODO Auto-generated method stub

        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results
       List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice"))
       								  .collect(Collectors.toList());

       //1 result
       Assert.assertEquals(veggies.size(), filteredList.size());
 }

}

*/

// Cherry