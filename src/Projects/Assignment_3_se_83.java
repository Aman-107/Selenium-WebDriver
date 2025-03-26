package Projects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_3_se_83 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String cred = driver.findElement(By.cssSelector(".text-center.text-white")).getText(); 
		cred = cred.replace("(", "").replace(")", "");  // Remove parentheses
        String[] parts = cred.split(" and "); //Split the string based on the 'and' keyword including whitespace
        String username = parts[0].split("is ")[1];    //Extract username
        String password = parts[1].split("is ")[1]; //Extract password
        
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//span[text()=' User']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancelBtn")));
        driver.findElement(By.id("okayBtn")).click();
        
        WebElement st = driver.findElement(By.xpath("//div[@class='form-group']/select[@class='form-control']"));
        Select dp = new Select(st);
        dp.selectByValue("consult");
        
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        
        wait.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
        
        List<WebElement> items = driver.findElements(By.cssSelector(".card-title"));
//        System.out.println(items);
        
        for(int i=0; i<items.size();i++) {
        	driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
        }
        
        driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
        
        
     //   System.out.println(username + password);
	}

}
