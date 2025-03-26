package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Locators_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Sibling - Child to parent transverse -> this will work only if sibling are right side not for the left child
		// Sibling -> header/div/button[1]/following-sibling::button[1]
		// GrandParents and so on -> //header/div/button[1]/parent::div/parent::header/a
		//parents -> //header/div/button[1]/parent::div/button[3]
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText());
		
	}

}
