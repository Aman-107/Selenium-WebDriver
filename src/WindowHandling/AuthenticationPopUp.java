package WindowHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthenticationPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
//	driver.get("https://the-internet.herokuapp.com/");  // without username and password accessing the URL
	driver.get("https://admin:admin@the-internet.herokuapp.com/");
	
	driver.findElement(By.linkText("Basic Auth")).click();
	
//	driver.get("https://foo:baar@httpbin.org/basic-auth/foo/baar");
	}

}

/* Java Handling can be done by switching window e.g alerts etc 
 * 
 * Handling Window Authentication Pop Up 
 * Syntax -> driver.get(http://Username:Password@SiteURL); // where ever it finds the login pop it automatically fills up
 * 
 * 
 * Handling File Upload from Windows using AutoIT
 * */
